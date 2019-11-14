package com.example.androidtimer.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtimer.BR
import com.example.androidtimer.ui.main.MainViewModel

class RingtonesAdapter(val layoutId:Int,val viewModel:MainViewModel)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    init {
        Log.i("Observe","Ringtones Adapter init "+viewModel.toString())
    }

    override fun getItemCount(): Int {
       // Log.i("com.example.androidtimer.adapter.Ringtone","GetItemCount"+viewModel?.ringtoneList.value?.size)
        return viewModel?.ringtoneList.value?.size?:0
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
       // Log.i("com.example.androidtimer.adapter.Ringtone","Create View holder")
        //if(viewType == layoutId){
        val binding
                = DataBindingUtil.inflate<ViewDataBinding>(layoutInflater,viewType,parent,false)
        return GenericViewHolder(binding)
        //}

    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       // Log.i("com.example.androidtimer.adapter.Ringtone","Bind")

        val gh = holder as GenericViewHolder

        gh.bind(viewModel, position )
    }

    override fun getItemViewType(position: Int): Int {
        return this.layoutId
    }

    /**
     * ViewHolder for Each Line (Use Data binding to show data)
     */
    internal inner class GenericViewHolder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        //val rootView: View = binding.root

        fun bind(viewModel: MainViewModel, position: Int) {
            //viewModel.fetchMovieImagesAt(position);
            //BR
            //binding.setVariable(BR.model, viewModel)
            binding.setVariable(BR.posRingtone, position)

            if (viewModel.ringtoneList.getValue() != null) {
                var ringtoneList =
                    viewModel.ringtoneList.getValue();//.get(position)//get(position)

                binding.setVariable(BR.holder,ringtoneList?.get(position))
            }
            binding.executePendingBindings()
        }

    }

}