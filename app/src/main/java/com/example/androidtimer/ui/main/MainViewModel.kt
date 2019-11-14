package com.example.androidtimer.ui.main

import android.app.Application
import android.content.Context
import android.media.RingtoneManager
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.androidtimer.R
import com.example.androidtimer.adapter.RingtonesAdapter


class MainViewModel(application: Application) : AndroidViewModel(application)
{
    // TODO: Implement the ViewModel


    data class RingtoneHolder(val id:String,val url:String,val title:String="")

    val adapterRT = RingtonesAdapter(R.layout.row_ringtone,this)
    val ringtoneList = MutableLiveData<List<RingtoneHolder>>()

    fun init(){

    }

    fun getRingtones(): MutableLiveData<List<RingtoneHolder>> {
        val ctx:Context = getApplication()
        val ringtoneManager = RingtoneManager(ctx)
        val cursor = ringtoneManager.cursor
        val holders = ArrayList<RingtoneHolder>()

        while (cursor.moveToNext()) {
            val title:String = cursor.getString(RingtoneManager.TITLE_COLUMN_INDEX)
            val id:String    = cursor.getString(RingtoneManager.ID_COLUMN_INDEX)
            val url:String   = cursor.getString(RingtoneManager.URI_COLUMN_INDEX)
            holders.add(RingtoneHolder(id,url,title))
            //Log.d("Ringtone", "TITLE: " + cursor.getString(RingtoneManager.TITLE_COLUMN_INDEX))
        }

        ringtoneList.value = holders
        adapterRT.notifyDataSetChanged()
        return ringtoneList
    }
}
