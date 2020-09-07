package com.example.baseapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.baseapplication.model.interactor.CityInteractor
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    // todo it's dummy code to check structure working well
    private val interactor: CityInteractor by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        interactor.getCities({
            Log.e("AHMED FOR TEST",it.size.toString())
        }, {
            Log.e("AHMED FOR TEST",it)
        })

    }
}