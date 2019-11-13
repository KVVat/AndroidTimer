package com.example.androidtimer.ui.main

import android.app.Activity
import android.app.Application
import android.content.Context
import android.media.RingtoneManager
import androidx.lifecycle.ViewModel
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log
import androidx.lifecycle.AndroidViewModel


class MainViewModel(application: Application) : AndroidViewModel(application)
{
    // TODO: Implement the ViewModel


    data class RingtoneHolder(val id:String,val url:String,val title:String="")

    fun getRingtones():List<RingtoneHolder>{
        val ctx:Context = getApplication()
        val ringtoneManager = RingtoneManager(ctx)
        val cursor = ringtoneManager.cursor
        val holders = ArrayList<RingtoneHolder>()

        while (cursor.moveToNext()) {
            val title:String = cursor.getString(RingtoneManager.TITLE_COLUMN_INDEX)
            val id:String    = cursor.getString(RingtoneManager.ID_COLUMN_INDEX)
            val url:String   = cursor.getString(RingtoneManager.URI_COLUMN_INDEX)
            holders.add(RingtoneHolder(id,url,title))
            Log.d("Ringtone", "TITLE: " + cursor.getString(RingtoneManager.TITLE_COLUMN_INDEX))
        }

        return holders
    }
}
