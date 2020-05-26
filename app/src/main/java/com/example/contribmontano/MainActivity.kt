package com.example.contribmontano

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var model: MontanoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.model = ViewModelProvider(this).get(MontanoViewModel::class.java)

        this.model.requestRepositories()

        this.model.getRepositories().observe(this, Observer { list ->

            list.forEach { resp ->
                Log.d("response",resp.name)
            }

        })
    }
}
