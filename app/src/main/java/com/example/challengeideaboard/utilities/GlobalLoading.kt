package com.example.challengeideaboard.utilities

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.example.challengeideaboard.R

@SuppressLint("StaticFieldLeak")
//class Global {
//    companion object{
//        var isLogin =false
//    }
//}
object  GlobalLoading {
    private lateinit var searchingFailView: View
    private lateinit var myLoadingRoot: ViewGroup
    private lateinit var mAlertDialogBuilder : androidx.appcompat.app.AlertDialog.Builder
    private lateinit var mAlertDialog : androidx.appcompat.app.AlertDialog
    fun showGlobalLoading(context: Context){
        val inflater = LayoutInflater.from(context)
        val mView = inflater.inflate(R.layout.view_progress_bar_loading, null)
        mAlertDialogBuilder= androidx.appcompat.app.AlertDialog.Builder(context,R.style.DialogTheme)
        mAlertDialogBuilder.setView(mView)
        mAlertDialog=mAlertDialogBuilder.show()
    }
    fun hideGlobalLoading(){
        if (::mAlertDialog.isInitialized) { mAlertDialog.dismiss() }
    }
}