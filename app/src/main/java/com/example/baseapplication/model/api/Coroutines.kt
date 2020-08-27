package com.Akoon.akoon.model.api

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import java.net.UnknownHostException


object Coroutines {



    fun main(work: suspend (() -> Unit)) : CoroutineScope{
        val scrope = CoroutineScope(Dispatchers.Main)
        scrope.launch {
            work()
        }
        return scrope
    }

}