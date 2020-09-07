package com.example.baseapplication.helper.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide


fun ImageView.showImage(url:String){
    Glide.with(this).load(url).into(this);
}
