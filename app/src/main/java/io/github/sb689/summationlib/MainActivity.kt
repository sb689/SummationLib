package io.github.sb689.summationlib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


data class User(var userId: String, var name: String)


class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }



}