package io.github.sb689.sumlib

import timber.log.Timber

class SumUp {

    fun tellAJoke():String{
        return "it is summer here under 5 feet snpw, haha"
    }
 fun getSum(a: Int, b:Int):Int{
     Timber.d("doing an addition")
     return a+b;
 }
}