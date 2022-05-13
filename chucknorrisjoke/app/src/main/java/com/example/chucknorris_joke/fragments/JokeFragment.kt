package com.example.chucknorris_joke.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.chucknorris_joke.R
import com.example.chucknorris_joke.viewModels.JokeViewModel
import org.koin.android.ext.android.inject


class JokeFragment : Fragment(R.layout.fragment_main) {

    var fact: TextView? = null
    var button: Button? = null
    var image: ImageView? = null

    private val viewModel: JokeViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val fragmentView = inflater.inflate(R.layout.fragment_main, container, false)

        fact = fragmentView.findViewById(R.id.fact)
        fact?.text = viewModel.currentJoke.value

        image = fragmentView.findViewById(R.id.imageChuck)

        viewModel.imageChuck.observe(
            viewLifecycleOwner,
            Observer { imageChuck ->
                Glide.with(requireContext())
                    .load(imageChuck) //imagem da api não tá funcionando
                    .error(R.drawable.chucknorris) //imagem estática
                    .into(image!!)
            }
        )

        viewModel.currentJoke.observe(
            viewLifecycleOwner,
            Observer { currentJoke ->
                updateJoke(currentJoke)
            })


        viewModel.currentError.observe(
            viewLifecycleOwner,
            Observer { currentError ->
                Toast.makeText(context, currentError, Toast.LENGTH_LONG).show()
            }
        )

        button = fragmentView.findViewById(R.id.button)
        button?.text = "Next"
        button?.setOnClickListener {
            context?.let { context -> viewModel.getJoke() }
        }

        return fragmentView
    }

    fun updateJoke(joke: String) {
        fact?.setText(joke)
    }

}