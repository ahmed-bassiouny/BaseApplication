package com.Akoon.akoon.base

import android.app.Dialog
import android.content.Context
import android.view.Window
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import org.koin.android.ext.android.inject


abstract class BaseActivity : AppCompatActivity() {

    private var noInternetDialog: Dialog? = null



    private fun handleDialog(status:Boolean){
        initDialog().let {
            if (status) {
                it.hide()
            } else {
                it.show()
            }
        }
    }


    private fun initDialog(): Dialog {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        //dialog.setContentView(R.layout.no_connetion)
        return dialog;
    }

//    fun showFragment(fragment:BaseFragment){
//        supportFragmentManager.beginTransaction().replace(R.id.container, fragment)
//            .commit()
//    }
}

fun AppCompatActivity.hideKeyboard() {
    val view = this.currentFocus
    if (view != null) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}
