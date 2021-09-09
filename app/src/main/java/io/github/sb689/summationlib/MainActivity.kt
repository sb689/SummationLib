package io.github.sb689.summationlib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.github.sb689.sumlib.SumUp

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val result = SumUp(applicationContext).getSum(5,6)
        Log.d("MainActivity", "sum result is  = $result")
    }
}