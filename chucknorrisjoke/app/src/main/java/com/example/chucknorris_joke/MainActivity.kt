package com.example.chucknorris_joke

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chucknorris_joke.fragments.JokeFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_main, JokeFragment())
            .commit()
    }
}


    