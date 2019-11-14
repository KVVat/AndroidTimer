package com.example.androidtimer.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtimer.R
import com.example.androidtimer.databinding.DetailFragmentBinding



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

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel

        mFragmentView = binding.root
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
         // TODO: Use the ViewModel
        //val mToolbar = toolbar;
        setupList()
    }

    fun setupList()
    {
        viewModel.init()
        //var ringtones: List<MainViewModel.RingtoneHolder> = viewModel.getRingtones()

        Log.i("Observe","fragmentiew"+mFragmentView)
        if(mFragmentView != null){
            val recyclerView = mFragmentView?.findViewById<RecyclerView>(R.id.listSounds)?.apply {
                layoutManager =LinearLayoutManager(context)
                adapter =  viewModel.adapterRT//RingtonesAdapter(R.layout.row_ringtone,viewModel)

                setHasFixedSize(true)

                Log.i("Observe","recyclerView applied")
                addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            }
            Log.i("Observe","recyclerView"+recyclerView)

            //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            viewModel.getRingtones().observe(this, Observer{

                Log.i("Observe ","Mutable Data Changed"+it.toString())
                viewModel.adapterRT.notifyDataSetChanged()
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
