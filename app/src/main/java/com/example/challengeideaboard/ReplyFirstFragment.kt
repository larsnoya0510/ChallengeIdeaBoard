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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challengeideaboard.api_network.DataModel
import com.example.challengeideaboard.api_network.SharePreferenceUtil
import com.example.challengeideaboard.viewmodel.PushReplyViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_reply.view.*
import kotlinx.android.synthetic.main.viewholder_first_reply_recyclerview_item.view.*

class ReplyFirstFragment : Fragment() {
lateinit var ReplyFragmentRootView:View
    lateinit var data:DataModel.BoardItem
    lateinit var mPushReplyViewModelViewModel: PushReplyViewModel
    lateinit var mPushReplyViewModelTriggerObserver: Observer<Int>
    lateinit var mPushReplyViewModelObserver: Observer<DataModel.ResponsePushReply>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        ReplyFragmentRootView= inflater.inflate(R.layout.fragment_reply, container, false)
        data= Gson().fromJson(arguments!!.getString("Data"),DataModel.BoardItem::class.java)
        ReplyFragmentRootView.mShowReplyRecyclerView.layoutManager=LinearLayoutManager(context)
        ReplyFragmentRootView.mShowReplyRecyclerView.adapter=ReplyFirstRecyclerViewAdapter(context!!,data.msgs)
        ReplyFragmentRootView.replyImageView.setOnClickListener {
            var token="Bearer ${SharePreferenceUtil.getUserToken(context!!)}"
            mPushReplyViewModelViewModel.RequestPushReply(token, data.id, SharePreferenceUtil.getUser(this.context!!),ReplyFragmentRootView.replyEditText.text.toString())
            collapseKeyboard()
            ReplyFragmentRootView.replyEditText.text.clear()
        }
        mPushReplyViewModelViewModel= ViewModelProvider(this).get(PushReplyViewModel::class.java)
        mPushReplyViewModelTriggerObserver = Observer {
            when(it){
                0->{

                }
                200-> {
                    mPushReplyViewModelViewModel.setPushReplyResponseDataTrigger(0)
                }
//                403-> {
//
//                }
                else ->{
//                    var error=mPushReplyViewModelViewModel.getErrorMessage().value
                    var error="請求失敗"
                    showAlertDialog(error)
                }
            }
        }
        mPushReplyViewModelObserver = Observer {
           clickBackIcon()
        }
        mPushReplyViewModelViewModel.getData().observe(viewLifecycleOwner, mPushReplyViewModelTriggerObserver)
        mPushReplyViewModelViewModel.getpushReplyResponseData().observe(viewLifecycleOwner, mPushReplyViewModelObserver)
        return ReplyFragmentRootView
    }
    companion object {
        @JvmStatic
        fun newInstance() = ReplyFirstFragment()
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
