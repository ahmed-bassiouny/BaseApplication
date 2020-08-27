package com.Akoon.akoon.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment



abstract class BaseFragment : Fragment() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        ivBack?.setOnClickListener {
//            activity?.onBackPressed()
//        }

        initViews()
        clickListener();
    }

//    fun showFragment(fragment:BaseFragment,addToBackStack:Boolean = true){
//        val ft = activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, fragment)
//        if (addToBackStack) ft?.addToBackStack("back")
//        ft?.commit()
//    }


    fun removeFragment(fragment:BaseFragment){
        val ft = activity?.supportFragmentManager?.beginTransaction()?.remove(fragment)
        ft?.commit()
    }


//    fun showDialog(
//        title: String = "",
//        message:String = "",
//        positive:String = "",
//        negative:String = "",
//        btnPositive: (() -> Unit) = {},
//        btnNegative: () -> (Unit) = {},
//        isError: Boolean = false
//    ) {
//        val dialogFragment: AppDialogFragment =
//            AppDialogFragment.newInstance(title, message, positive, negative,isError)
//
//        dialogFragment.btnPositive = { btnPositive() }
//        dialogFragment.btnNegative = { btnNegative() }
//        val ft =
//            activity?.supportFragmentManager?.beginTransaction()
//        ft?.add(dialogFragment, "dialog")
//        ft?.commit()
//    }
//
//    fun showErrorDialog(
//        title: String = getString(R.string.error),
//        message: String = "",
//        positive: String = "",
//        negative: String = "",
//        btnPositive: (() -> Unit) = {},
//        btnNegative: () -> (Unit) = {}
//    ) {
//        showDialog(title, message, positive, negative, btnPositive, btnNegative,true)
//    }


    abstract fun initViews()
    abstract fun clickListener()
}