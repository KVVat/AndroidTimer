package com.example.androidtimer.ui.main

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtimer.R
import com.example.androidtimer.adapter.RingtonesAdapter
import com.example.androidtimer.databinding.DetailFragmentBinding
import com.example.androidtimer.service.TimerService
import kotlinx.android.synthetic.main.main_activity.*



class DetailFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }

    private lateinit var viewModel: MainViewModel

    var mFragmentView:View?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding =
            DetailFragmentBinding.inflate(inflater,container,false);
        Log.i("Observe","OnLoad Detail Fragment")
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        //binding.viewModel

        mFragmentView =
            inflater.inflate(R.layout.detail_fragment, container, false)
        setupList()

        return binding.root
        //inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

         // TODO: Use the ViewModel
        //val mToolbar = toolbar;

    }

    fun setupList()
    {
        viewModel.init()
        //var ringtones: List<MainViewModel.RingtoneHolder> = viewModel.getRingtones()

        Log.i("Observe","fragmentiew"+mFragmentView)
        if(mFragmentView != null){
            val recyclerView = mFragmentView?.findViewById<RecyclerView>(R.id.listSounds);
            Log.i("Observe","recyclerView"+recyclerView)

            recyclerView?.adapter = RingtonesAdapter(R.layout.row_ringtone,viewModel)
            //recyclerView?.setHasFixedSize(true)
            recyclerView?.setLayoutManager(LinearLayoutManager(context))
            //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            viewModel.getRingtones().observe(this, Observer{

                Log.i("Observe ","Mutable Data Changed"+it.toString())
                //
            })
        }
        //val recyclerView =
        //    activity?.findViewById<RecyclerView>(R.id.listSounds)
        //viewModel.adapterRT = new



    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home->{
                fragmentManager?.popBackStack()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
