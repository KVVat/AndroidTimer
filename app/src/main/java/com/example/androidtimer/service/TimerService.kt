package com.example.androidtimer.service

import android.app.IntentService
import android.content.Intent
import android.util.Log
import android.widget.Toast

class TimerService :IntentService(TimerService::class.simpleName){

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this,"serviceStarting",Toast.LENGTH_SHORT).show()
        return super.onStartCommand(intent, flags, startId)
    }
    override fun onHandleIntent(workIntent: Intent?) {
        if (workIntent != null) {
            val data = workIntent?.getStringExtra("data")
            Log.i("TAG","Message is : $data")
        }
    }

}
