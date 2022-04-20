package com.example.chucknorris_joke

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


class JokeFragment : Fragment(R.layout.fragment_main) {

    var jokeModel: JokeModel? = null
    var fact: TextView? = null
    var button: Button? = null

    private lateinit var viewModel: JokeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.i("JokeFragment", "onCreate Called")

        val fragmentView = inflater.inflate(R.layout.fragment_main, container, false)

        viewModel = ViewModelProvider(this).get(JokeViewModel::class.java)
        viewModel.currentJoke.observe(
            viewLifecycleOwner,
            Observer { currentJoke -> updateJoke(currentJoke) })

        fact = fragmentView.findViewById(R.id.fact)
        fact?.setText(viewModel.currentJoke.value)

        button = fragmentView.findViewById(R.id.button)
        button?.setText("Next")

        button?.setOnClickListener {
            context?.let { context -> viewModel.getData(context) }
//            viewModel.getData()
        }

        Log.i("JokeFragment", "Called ViewModelProvider.get")

        return fragmentView
    }


    fun updateJoke(joke: String) {
        fact?.setText(joke)
    }


    //Log.i nos métodos do ciclo de vida
    override fun onStart() {
        super.onStart()
        Log.i("JokeFragment", "onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.i("JokeFragment", "onResume Called")

    }

    override fun onPause() {
        super.onPause()
        Log.i("JokeFragment", "onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.i("JokeFragment", "onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("JokeFragment", "onDestroy Called")
    }
}