package com.soyaeeb.musicpartner.helper.media.contentresolver

import android.content.ContentUris
import android.content.Context
import android.database.Cursor
import android.graphics.Bitmap
import android.os.Build
import android.provider.MediaStore
import android.provider.MediaStore.Audio.AlbumColumns.*
import android.provider.MediaStore.Images
import android.util.Size
import androidx.annotation.RequiresApi
import androidx.annotation.WorkerThread
import com.soyaeeb.musicpartner.model.music.audio.AudioMusic
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.R)
class AudioFilesContentResolver @Inject constructor(
    @ApplicationContext val context: Context
) {
    private var audioFileCursor: Cursor? = null
    // private var albumArt: Bitmap? = null

    private val audioProjection = arrayOf(
        MediaStore.Audio.AudioColumns._ID,
        MediaStore.Audio.AudioColumns.DISPLAY_NAME,
        MediaStore.Audio.AudioColumns.TITLE,
        MediaStore.Audio.AudioColumns.ARTIST,
        MediaStore.Audio.AudioColumns.ALBUM_ARTIST,
        MediaStore.Audio.AudioColumns.DATA,
        MediaStore.Audio.AudioColumns.DURATION,
    )
    private val audioSelection = "${MediaStore.Audio.AudioColumns.IS_MUSIC} = ?"
    private val audioSelectionArgs = arrayOf("1")
    private val audioSortOrder = "${MediaStore.Audio.Media.DISPLAY_NAME} ASC"

    @WorkerThread
    fun getAllAudioFiles(): Flow<List<AudioMusic>> = getAudioFileList()

    private fun getAudioFileList() = flow<List<AudioMusic>> {
        val audioMusicList = mutableListOf<AudioMusic>()

        audioFileCursor = context.contentResolver.query(
            /* uri = */ MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            /* projection = */ audioProjection,
            /* selection = */ audioSelection,
            /* selectionArgs = */ audioSelectionArgs,
            /* sortOrder = */ audioSortOrder
        )

        audioFileCursor?.use { cursor ->
            val idColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID)
            val displayNameColumn =
                cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME)
            val titleColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)
            val artistColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST)
            val albumArtistColumn =
                cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ARTIST)
            val dataColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)
            val durationColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION)

            cursor.apply {
                if (count > 0) {
                    while (cursor.moveToNext()) {
                        val id = getLong(idColumn)
                        val displayName = getString(displayNameColumn)
                        val title = getString(titleColumn)
                        val artist = getString(artistColumn)
                        val albumArtist = getString(albumArtistColumn)
                        val data = getString(dataColumn)
                        val duration = getLong(durationColumn)
                        val uri = ContentUris.withAppendedId(
                            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                            id
                        )
                        audioMusicList += AudioMusic(
                            id = id,
                            uri = uri,
                            displayName = displayName,
                            title = title,
                            artist = artist,
                            albumArtist = albumArtist,
                            data = data,
                            duration = duration
                        )

                    }

                }
            }
        }
        emit(audioMusicList)
    }
}