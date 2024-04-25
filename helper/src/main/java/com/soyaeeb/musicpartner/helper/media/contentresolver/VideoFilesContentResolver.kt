package com.soyaeeb.musicpartner.helper.media.contentresolver

import android.content.ContentUris
import android.content.Context
import android.database.Cursor
import android.os.Build
import android.provider.MediaStore
import androidx.annotation.RequiresApi
import androidx.annotation.WorkerThread
import com.soyaeeb.musicpartner.model.music.video.VideoMusic
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class VideoFilesContentResolver @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private var videoFileCursor : Cursor ? = null
    private val collection =
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            MediaStore.Video.Media.getContentUri(
                MediaStore.VOLUME_EXTERNAL
            )
        }else {
            MediaStore.Video.Media.EXTERNAL_CONTENT_URI
        }

    private val projection = arrayOf(
        MediaStore.Video.Media._ID,
        MediaStore.Video.Media.DISPLAY_NAME,
        MediaStore.Video.Media.TITLE,
        MediaStore.Video.Media.DURATION,
        MediaStore.Video.Media.SIZE,
        MediaStore.Video.Media.ARTIST
    )

    @RequiresApi(Build.VERSION_CODES.R)
    private val selection = "${MediaStore.Video.Media.DURATION} >= ?"

    private val selectionArgs = arrayOf(
        TimeUnit.MILLISECONDS.convert(5, TimeUnit.SECONDS).toString()
    )

    private val sortOrder = "${MediaStore.Video.Media.DISPLAY_NAME} ASC"


    @RequiresApi(Build.VERSION_CODES.R)
    private fun getVideoFiles() =  flow<List<VideoMusic>> {
        val videoMusicList = mutableListOf<VideoMusic>()

        videoFileCursor = context.contentResolver.query(
            /* uri = */ collection,
            /* projection = */ projection,
            /* selection = */ selection,
            /* selectionArgs = */ selectionArgs,
            /* sortOrder = */ sortOrder
        )

        videoFileCursor?.use { cursor ->
            val idColumn = cursor.getColumnIndexOrThrow(MediaStore.Video.Media._ID)
            val nameColumn = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME)
            val titleColumn = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.TITLE)
            val durationColumn = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DURATION)
            val sizeColumn = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.SIZE)
            val artistColumn = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.ARTIST)

            cursor.apply {
                if(count > 0){
                    while (cursor.moveToNext()){
                        val id = getLong(idColumn)
                        val name = getString(nameColumn)
                        val title = getString(titleColumn)
                        val duration = getLong(durationColumn)
                        val size = getInt(sizeColumn)
                        val artist = getString(artistColumn)
                        val uri = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, id)
                        videoMusicList += VideoMusic(
                            id = id,
                            uri = uri,
                            displayName = name,
                            artist = artist,
                            title = title,
                            duration = duration,
                            size = size
                        )
                    }
                }
            }
        }
        emit(videoMusicList)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    @WorkerThread
    fun getAllVideoFiles() : Flow<List<VideoMusic>> = getVideoFiles()
}
