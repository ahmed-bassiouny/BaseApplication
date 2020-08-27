package com.example.baseapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.baseapplication.model.interactor.UserInteractor
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val interactor: UserInteractor by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt.setOnClickListener {

            interactor.login("465123", "123456") { success, error ->
                Log.e("ahmed", success.toString())

                Log.e("ahmed", error)

            }
        }
    }
}