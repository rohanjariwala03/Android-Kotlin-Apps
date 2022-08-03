package com.example.shared_pref.musicPlayer

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import com.example.shared_pref.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MusicPlayer : AppCompatActivity() {

    private lateinit var mediaController: SeekBar
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var fabPlay: FloatingActionButton
    private lateinit var fabPause: FloatingActionButton
    private lateinit var fabStop: FloatingActionButton
    private lateinit var runnable: Runnable
    private lateinit var handler: Handler

    private lateinit var tvPlayed : TextView
    private lateinit var tvDue : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_player)

        mediaPlayer = MediaPlayer.create(this, R.raw.my_music)
        mediaController = findViewById(R.id.mediaController)
        fabPlay = findViewById(R.id.fabPlay)
        fabPause = findViewById(R.id.fabPause)
        fabStop = findViewById(R.id.fabStop)
        tvPlayed = findViewById(R.id.tvPlayed)
        tvDue = findViewById(R.id.tvDue)

        handler = Handler(Looper.getMainLooper())

        initializeMediaController()

        var stopped = false

        fabPlay.setOnClickListener {
            if(stopped){
                mediaPlayer = MediaPlayer.create(this, R.raw.my_music)
                initializeMediaController()
            }
            stopped = false
            mediaPlayer.start()
            print("HERE3")
        }

        fabPause.setOnClickListener {
            mediaPlayer.pause()
        }

        fabStop.setOnClickListener {
            mediaPlayer.stop()
            mediaPlayer.reset()
            mediaPlayer.release()
            handler.removeCallbacks(runnable)
            mediaController.progress = 0
            stopped = true
        }
    }

    @SuppressLint("SetTextI18n")
    private fun initializeMediaController(){
        mediaController.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser) mediaPlayer.seekTo(progress)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })

        mediaController.max = mediaPlayer.duration
        runnable = Runnable {
            tvDue.text = "${ (mediaPlayer.duration / 1000) - (mediaPlayer.currentPosition/1000) } Secs"
            tvPlayed.text = "${mediaPlayer.currentPosition/1000} Secs"
            mediaController.progress = mediaPlayer.currentPosition
            handler.postDelayed(runnable,1000)
        }
        handler.postDelayed(runnable,1000)
    }
}