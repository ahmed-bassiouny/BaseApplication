package com.Akoon.akoon.helper

interface AdapterClick<T> {

    fun click(position:Int,t:T)
    fun longCLick(position:Int,t:T){}
}