package com.example.challengeideaboard


import android.content.SharedPreferences
import android.os.Bundle
import android.text.InputType.TYPE_TEXT_FLAG_MULTI_LINE
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challengeideaboard.api_network.DataModel
import com.example.challengeideaboard.api_network.SharePreferenceUtil
import com.example.challengeideaboard.viewmodel.BoardViewModel
import com.example.challengeideaboard.viewmodel.PushGoodViewModel
import com.example.challengeideaboard.viewmodel.PushMsgViewModel
import kotlinx.android.synthetic.main.fragment_idea_board.view.*
import android.view.inputmethod.InputMethodManager.HIDE_NOT_ALWAYS
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.content.DialogInterface
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.ViewModel


/**
 * A simple [Fragment] subclass.
 */
class IdeaBoardFragment : Fragment() {
    lateinit var mBoardViewModelViewModel: BoardViewModel
    lateinit var mBoardViewModelTriggerObserver: Observer<Int>
    lateinit var mBoardViewModelObserver: Observer<DataModel.ResponseBoard>

    lateinit var mPushGoodViewModelViewModel:PushGoodViewModel
    lateinit var mPushGoodViewModelTriggerObserver: Observer<Int>
    lateinit var mPushGoodViewModelObserver: Observer<DataModel.ResponsePushGood>

    lateinit var mPushMsgViewModelViewModel: PushMsgViewModel
    lateinit var mPushMsgViewModelTriggerObserver: Observer<Int>
    lateinit var mPushMsgViewModelObserver: Observer<DataModel.ResponsePushMsg>

    lateinit var IdeaBoardFragmentRootView:View
    lateinit var mAdapter:BoardRecyclerViewAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        IdeaBoardFragmentRootView= inflater.inflate(R.layout.fragment_idea_board, container, false)
//        IdeaBoardFragmentRootView.postEditText.setImeOptions(EditorInfo.IME_ACTION_SEND)
        IdeaBoardFragmentRootView.postEditText.setInputType(TYPE_TEXT_FLAG_MULTI_LINE)
        IdeaBoardFragmentRootView.postEditText.setSingleLine(false)
        IdeaBoardFragmentRootView.postEditText.setMaxLines(4)
        IdeaBoardFragmentRootView.postImageView.setOnClickListener {
            var token="Bearer ${SharePreferenceUtil.getUserToken(context!!)}111"
            var user = SharePreferenceUtil.getUser(context!!)
            if(SharePreferenceUtil.getUserToken(context!!).isNullOrEmpty()){
                Toast.makeText(context,"請先登入",Toast.LENGTH_SHORT).show()
            }
            else {
                mPushMsgViewModelViewModel.RequestPushMsg(token, user, IdeaBoardFragmentRootView.postEditText.text.toString())
                //            Toast.makeText(context,IdeaBoardFragmentRootView.postEditText.text.toString(),Toast.LENGTH_SHORT).show()
                collapseKeyboard()
                IdeaBoardFragmentRootView.postEditText.text.clear()
            }

        }
        mAdapter=BoardRecyclerViewAdapter(this.context!!, mutableListOf<DataModel.BoardItem>())
        mAdapter.setOnItemCheckListener(object : BoardRecyclerViewAdapter.OnItemCheckListener{
            override fun onClickMsg(mUserName: String, mContent: String) {

            }

            override fun onCLickGood(mBoardId: Int, mUserName: String) {
                var token="Bearer ${SharePreferenceUtil.getUserToken(context!!)}"
                if(SharePreferenceUtil.getUserToken(context!!).isNullOrEmpty()){
                    Toast.makeText(context,"請先登入",Toast.LENGTH_SHORT).show()
                }
                else {
                    mPushGoodViewModelViewModel.RequestPushGood(token, mBoardId, mUserName)
                }
            }

        })
        IdeaBoardFragmentRootView.boardRecyclerView.layoutManager=LinearLayoutManager(this.context)
        IdeaBoardFragmentRootView.boardRecyclerView.adapter = mAdapter

        mBoardViewModelViewModel= ViewModelProvider(this).get(BoardViewModel::class.java)
        mBoardViewModelTriggerObserver = Observer {
            when(it){
                200-> {
                    mBoardViewModelViewModel.setBoardResponseDataTrigger(0)
                }
//                403-> {
//
//                }
                else ->{
                    var error=mBoardViewModelViewModel.getErrorMessage().value
                    showAlertDialog(error)
                }
            }
        }
        mBoardViewModelObserver = Observer {
            mAdapter.updateData(it.all)
        }
        mBoardViewModelViewModel.getData().observe(viewLifecycleOwner, mBoardViewModelTriggerObserver)
        mBoardViewModelViewModel.getBoardResponseData().observe(viewLifecycleOwner, mBoardViewModelObserver)

        mPushGoodViewModelViewModel= ViewModelProvider(this).get(PushGoodViewModel::class.java)
        mPushGoodViewModelTriggerObserver = Observer {
            when(it){
                200-> {
                    mPushGoodViewModelViewModel.setPushGoodResponseDataTrigger(0)
                }
//                403-> {
//
//                }
                else ->{
                    var error=mPushGoodViewModelViewModel.getErrorMessage().value
                    showAlertDialog(error)
                }
            }
        }
        mPushGoodViewModelObserver = Observer {
            mBoardViewModelViewModel.RequestBoard()
        }
        mPushGoodViewModelViewModel.getData().observe(viewLifecycleOwner, mPushGoodViewModelTriggerObserver)
        mPushGoodViewModelViewModel.getpushGoodResponseData().observe(viewLifecycleOwner, mPushGoodViewModelObserver)

        mPushMsgViewModelViewModel= ViewModelProvider(this).get(PushMsgViewModel::class.java)
        mPushMsgViewModelTriggerObserver = Observer {
            when(it){
                200-> {
                    mPushMsgViewModelViewModel.setPushMsgResponseDataTrigger(0)
                }
//                403-> {
//
//                }
                else ->{
                    var error=mPushMsgViewModelViewModel.getErrorMessage().value
                    showAlertDialog(error)
                }
            }
        }
        mPushMsgViewModelObserver = Observer {
            mBoardViewModelViewModel.RequestBoard()
        }
        mPushMsgViewModelViewModel.getData().observe(viewLifecycleOwner, mPushMsgViewModelTriggerObserver)
        mPushMsgViewModelViewModel.getpushMsgResponseData().observe(viewLifecycleOwner, mPushMsgViewModelObserver)
        return IdeaBoardFragmentRootView
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
            context!!.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        if (inputMethodManager != null && (context as Activity).currentFocus != null) {
            inputMethodManager!!.hideSoftInputFromWindow(
                (context as Activity).currentFocus!!.windowToken, HIDE_NOT_ALWAYS
            )
        }
    }

    override fun onResume() {
        super.onResume()
        mBoardViewModelViewModel.RequestBoard()
    }

    companion object {
        @JvmStatic
        fun newInstance() = IdeaBoardFragment()
    }

    private fun clickBackIcon() {

        if (this.fragmentManager!!.backStackEntryCount > 0) {
            this.fragmentManager!!.popBackStack()
        } else {
            this.activity!!.finish()
        }
    }

}
