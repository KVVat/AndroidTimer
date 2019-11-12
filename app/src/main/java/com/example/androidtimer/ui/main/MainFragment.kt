package com.example.androidtimer.ui.main

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation.findNavController
import com.example.androidtimer.R
import com.example.androidtimer.service.TimerService
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        message.setOnClickListener {
            Toast.makeText(this.context,"blur blur blur",Toast.LENGTH_SHORT).show()
            findNavController(it).navigate(R.id.action_mainFragment_to_detailFragment, null)//, options)
        }
        // TODO: Use the ViewModel

        //val intent = Intent(activity, TimerService::class.java)
        //intent.putExtra("data", "Hello Intent service used for handling asynchronous task")
        //activity?.startService(intent)
    }


}
