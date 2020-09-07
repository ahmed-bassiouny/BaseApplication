package com.Akoon.akoon.helper

import java.text.SimpleDateFormat
import java.util.*

fun String?.value () : String{
    return this?: ""
}

fun String.toDateFormat():String{
    try {
        val originalFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        val targetFormat =SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        return targetFormat.format(originalFormat.parse(this)?: Date())
    }catch (e:Exception){
        return this
    }
}