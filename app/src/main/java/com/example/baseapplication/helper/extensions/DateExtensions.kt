package com.example.baseapplication.helper.extensions

fun Double?.value () : Double{
    return this?: 0.0
}

fun Int?.value () : Int{
    return this?: 0
}
