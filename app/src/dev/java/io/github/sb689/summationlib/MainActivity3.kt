package io.github.sb689.summationlib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*
import kotlin.concurrent.thread

class MainActivity3 : AppCompatActivity() {
    private val TAG = "MainActivity3"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        //val result = SumUp().getSum(5,6)
        //Log.d("MainActivity", "sum result is  = $result")

        Log.d(TAG, "starting coroutine test")

        Log.d(TAG, "ending coroutine test")
    }

    fun testCoroutine():Unit{
        CoroutineScope(Dispatchers.IO).launch {
            val result =   withContext(Dispatchers.IO) {
                sumUp(5, 6);
            }

        }
    }

    suspend fun sumUp(a: Int, b: Int): Int {
        delay(5000)
        return a+b;
    }

    suspend fun getUserStandard(userId: String): User {
        delay(1000)
        return User(userId, "Filip")
    }

    fun getUserFromNetworkCallback(
        userId: String,
        onUserResponse: (User?, Throwable?) -> Unit) {
        thread {

            try {
                Thread.sleep(1000)
                val user = User(userId, "tree")
                onUserResponse(user, null)

            } catch (error: Throwable) {
                onUserResponse(null, error)
            }
        }
    }

    fun getUserFromNetworkCallback(
        userId: String,
        onUserReady: (User) -> Unit) {
        thread {
            Thread.sleep(1000)

            val user = User(userId, "Filip")
            onUserReady(user)
        }
        println("end")
    }

    private fun  coroutineTest() {
        with(CoroutineScope(Dispatchers.Main)) {
            val parentJob = launch {
                delay(500)
                println("I’m the parent")
                delay(200)
            }
            launch(context = parentJob) {
                delay(200)
                println("I’m a child")
                delay(200)
            }
            if (parentJob.children.iterator().hasNext()) {
                println("The Job has children ${parentJob.children}")
            } else {
                println("The Job has NO children")
            }
            //Thread.sleep(1000)
        }

    }
}