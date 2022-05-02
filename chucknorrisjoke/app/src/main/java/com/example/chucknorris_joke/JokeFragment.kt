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
import org.koin.android.ext.android.inject


class JokeFragment : Fragment(R.layout.fragment_main) {

    var fact: TextView? = null
    var button: Button? = null

    private val viewModel: JokeViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.i("JokeFragment", "onCreate Called")

        val fragmentView = inflater.inflate(R.layout.fragment_main, container, false)

        fact = fragmentView.findViewById(R.id.fact)
        fact?.text = viewModel.currentJoke.value

        viewModel.currentJoke.observe(
            viewLifecycleOwner,
            Observer { currentJoke ->
                updateJoke(currentJoke)
            })


        button = fragmentView.findViewById(R.id.button)
        button?.text = "Next"

        button?.setOnClickListener {
            context?.let { context -> viewModel.getJoke(context) }
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