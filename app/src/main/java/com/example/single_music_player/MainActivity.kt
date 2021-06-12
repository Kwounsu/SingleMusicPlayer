package com.example.single_music_player

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var playButton: Button
    lateinit var stopButton: Button
    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playButton = findViewById(R.id.button_play)
        stopButton = findViewById(R.id.button_pause)
        mediaPlayer = MediaPlayer.create(this, R.raw.abc_song)

        // Buttons: Play, Pause, Backward, Forward
        playButton.setOnClickListener {
            mediaPlayer.start()
            stopButton.isEnabled = true
            playButton.isEnabled = false
            playButton.visibility = View.GONE
            stopButton.visibility = View.VISIBLE
        }
        stopButton.setOnClickListener {
            mediaPlayer.pause()
            stopButton.isEnabled = false
            playButton.isEnabled = true
            stopButton.visibility = View.GONE
            playButton.visibility = View.VISIBLE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}