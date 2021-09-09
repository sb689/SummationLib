package io.github.sb689.sumlib

import android.content.Context
import timber.log.Timber

class SumUp  constructor(var context: Context) {

 fun getSum(a: Int, b:Int):Int{
     Timber.d("doing an addition")
     return a+b;
 }
}