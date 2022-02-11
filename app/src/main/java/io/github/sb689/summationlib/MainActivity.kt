package io.github.sb689.summationlib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.sb689.sumlib.SumUp


data class User(var userId: String, var name: String)


class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lib = SumUp().getSum(1,2)


    }



}