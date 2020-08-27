package com.Akoon.akoon.helper

import android.content.Context
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.*

fun String?.value () : String{
    return this?: ""
}

fun Double?.value () : Double{
    return this?: 0.0
}

fun Int?.value () : Int{
    return this?: 0
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun ImageView.showImage(url:String){
    Glide.with(this).load(url).into(this);
}

fun Fragment.hideKeyboard(){
    val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view!!.getWindowToken(), 0)
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