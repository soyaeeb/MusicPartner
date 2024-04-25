package com.soyaeeb.audiomusic.ui

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.soyaeeb.assets.R
import com.soyaeeb.musicpartner.model.music.audio.AudioMusic

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun AudioMusicItem(
    audioMusic: AudioMusic
){
    val context = LocalContext.current
    val audioViewModel = hiltViewModel<AudioViewModel>()
    val albumArt = audioViewModel.loadAlbumArt(audioMusic.uri, context)

    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
            .clickable {
                Toast
                    .makeText(context, "${audioMusic.id} is clicked", Toast.LENGTH_SHORT)
                    .show()
            }
    ) {
        albumArt?.let { bitmap ->
            Image(
                modifier = Modifier
                    .size(55.dp)
                    .clip(CircleShape),
                bitmap = bitmap.asImageBitmap(),
                contentDescription = "Audio Music Icon",
                contentScale = ContentScale.Crop
            )
        }
         if(albumArt == null) {
            Image(
                modifier = Modifier
                    .size(55.dp)
                    .clip(CircleShape),
                painter = painterResource(id = R.drawable.ic_audio_music),
                contentDescription = "Audio Music Icon",
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier.padding(start = 10.dp)
        ) {
            Text(
                text = audioMusic.displayName,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                color = Color.White
            )
            Text(
                text = audioMusic.artist.ifEmpty { "Unknown" },
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                color = Color.White
            )
        }
    }
}
