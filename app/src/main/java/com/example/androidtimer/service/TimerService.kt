package com.example.androidtimer.service

import android.app.IntentService
import android.content.Intent
import android.util.Log

class TimerService :IntentService(TimerService::class.simpleName){

    override fun onHandleIntent(workIntent: Intent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Log.i("Observe","Testing")
    }

}
