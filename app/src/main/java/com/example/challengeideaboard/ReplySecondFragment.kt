package com.example.challengeideaboard


import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challengeideaboard.adapter.ReplySecondRecyclerViewAdapter
import com.example.challengeideaboard.api_network.DataModel
import com.example.challengeideaboard.api_network.SharePreferenceUtil
import com.example.challengeideaboard.utilities.GlobalLoading
import com.example.challengeideaboard.viewmodel.PushReplySecondViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_reply_second.view.*

class ReplySecondFragment : Fragment() {
lateinit var ReplySecondFragmentRootView:View
    lateinit var data:DataModel.MsgsItem
    lateinit var mPushReplySecondViewModelViewModel: PushReplySecondViewModel
    lateinit var mPushReplySecondViewModelTriggerObserver: Observer<Int>
    lateinit var mPushReplySecondViewModelObserver: Observer<DataModel.ResponsePushReplySecond>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        ReplySecondFragmentRootView= inflater.inflate(R.layout.fragment_reply_second, container, false)
        data= Gson().fromJson(arguments!!.getString("MsgData"),DataModel.MsgsItem::class.java)
        ReplySecondFragmentRootView.mShowReplySecondRecyclerView.layoutManager=LinearLayoutManager(context)
        ReplySecondFragmentRootView.mShowReplySecondRecyclerView.adapter=
            ReplySecondRecyclerViewAdapter(
                context!!,
                data.remsgs
            )
        ReplySecondFragmentRootView.replySecondImageView.setOnClickListener {
            var token="Bearer ${SharePreferenceUtil.getUserToken(context!!)}"
            mPushReplySecondViewModelViewModel.RequestPushReplySecond(token, data.boards_id,data.id, SharePreferenceUtil.getUser(this.context!!),ReplySecondFragmentRootView.replySecondEditText.text.toString())
            collapseKeyboard()
            ReplySecondFragmentRootView.replySecondEditText.text.clear()
            GlobalLoading.showGlobalLoading(context!!)
        }
        mPushReplySecondViewModelViewModel= ViewModelProvider(this).get(PushReplySecondViewModel::class.java)
        mPushReplySecondViewModelTriggerObserver = Observer {
            when(it){
                0->{

                }
                200-> {
                    GlobalLoading.hideGlobalLoading()
                    mPushReplySecondViewModelViewModel.setPushReplySecondResponseDataTrigger(0)
                }
//                403-> {
//
//                }
                401 ->{
                    GlobalLoading.hideGlobalLoading()
                    SharePreferenceUtil.removeUser(context!!)
                    SharePreferenceUtil.removeToken(context!!)
                    Toast.makeText(context,"登入失效，請重新登入", Toast.LENGTH_SHORT).show()
                    (activity as MainActivity).checkLogin()
                    clickBackIcon()
                }
                else ->{
                    GlobalLoading.hideGlobalLoading()
//                    var error=mPushReplyViewModelViewModel.getErrorMessage().value
                    var error="請求失敗"
                    showAlertDialog(error)
                }
            }
        }
        mPushReplySecondViewModelObserver = Observer {
           clickBackIcon()
        }
        mPushReplySecondViewModelViewModel.getData().observe(viewLifecycleOwner, mPushReplySecondViewModelTriggerObserver)
        mPushReplySecondViewModelViewModel.getpushReplySecondResponseData().observe(viewLifecycleOwner, mPushReplySecondViewModelObserver)
        return ReplySecondFragmentRootView
    }
    companion object {
        @JvmStatic
        fun newInstance() = ReplySecondFragment()
    }

    private fun clickBackIcon() {

        if (this.fragmentManager!!.backStackEntryCount > 0) {
            this.fragmentManager!!.popBackStack()
        } else {
            this.activity!!.finish()
        }
    }
    private fun showAlertDialog(error:String?) {
        var mDialog = AlertDialog.Builder(this.context)
            .setMessage(error)
            .setPositiveButton("確認", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {

                }
            })
        mDialog.show()
    }
    private fun collapseKeyboard() {
        val inputMethodManager =
            context!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (inputMethodManager != null && (context as Activity).currentFocus != null) {
            inputMethodManager!!.hideSoftInputFromWindow(
                (context as Activity).currentFocus!!.windowToken, InputMethodManager.HIDE_NOT_ALWAYS
            )
        }
    }
}
