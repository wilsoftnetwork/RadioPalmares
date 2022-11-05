package com.radiopalmares.wilsoft
import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

        private lateinit var Bplay:Button
        private lateinit var Bpause:Button
        private lateinit var MPlayer:MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Bplay = findViewById(R.id.buttonPlay)
        Bpause = findViewById(R.id.buttonPause)
        RadioPalmares()

    }


    private fun RadioPalmares(){

        val url ="https://panel.wilhost.com:8002/stream"

        MPlayer = MediaPlayer()
        MPlayer.setDataSource(url)
        MPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
        MPlayer.prepareAsync()

        MPlayer.setOnPreparedListener{

            Play(this)
        }

    }

    private fun Play (context: Context){

        Bplay.setOnClickListener {
            MPlayer.start()
            Toast.makeText(context, "En Play...", Toast.LENGTH_SHORT).show()
        }


        Bpause.setOnClickListener {
            MPlayer.pause()
            Toast.makeText(context, "En Pausa...", Toast.LENGTH_SHORT).show()
        }



    }


}









