package com.example.assignment2

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.util.Log
import androidx.core.app.JobIntentService

class MusicPlayer: JobIntentService() {

    override fun onHandleWork(intent: Intent) {
        Log.d("Service", "Music Started")
        val mp = MediaPlayer.create(applicationContext, R.raw.music)
        mp.start()
    }

    companion object{
        fun myBackgroundMusic(context: Context, intent: Intent){
            enqueueWork(context, MusicPlayer::class.java, 1,intent)
        }
    }
}