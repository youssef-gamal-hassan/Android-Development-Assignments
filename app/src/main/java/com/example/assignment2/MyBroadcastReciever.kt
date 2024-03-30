package com.example.assignment2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadcastReciever:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val isAirplaneOn: Boolean = intent!!.getBooleanExtra("state", false)

        if(isAirplaneOn){
            Toast.makeText(context, "Airplane Mode is on", Toast.LENGTH_LONG).show()
        }


    }
}