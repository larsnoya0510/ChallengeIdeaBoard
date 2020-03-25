package com.example.challengeideaboard


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challengeideaboard.api_network.DataModel
import com.example.challengeideaboard.api_network.SharePreferenceUtil
import com.example.challengeideaboard.viewmodel.BoardViewModel
import com.example.challengeideaboard.viewmodel.PushGoodViewModel
import kotlinx.android.synthetic.main.fragment_idea_board.view.*

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

    lateinit var IdeaBoardFragmentRootView:View
    lateinit var mAdapter:BoardRecyclerViewAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        IdeaBoardFragmentRootView= inflater.inflate(R.layout.fragment_idea_board, container, false)
        mAdapter=BoardRecyclerViewAdapter(this.context!!, mutableListOf<DataModel.BoardItem>())
        mAdapter.setOnItemCheckListener(object : BoardRecyclerViewAdapter.OnItemCheckListener{
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
                403-> {

                }
                else ->{

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
                403-> {

                }
                else ->{

                }
            }
        }
        mPushGoodViewModelObserver = Observer {
            mBoardViewModelViewModel.RequestBoard()
        }
        mPushGoodViewModelViewModel.getData().observe(viewLifecycleOwner, mPushGoodViewModelTriggerObserver)
        mPushGoodViewModelViewModel.getpushGoodResponseData().observe(viewLifecycleOwner, mPushGoodViewModelObserver)
        return IdeaBoardFragmentRootView
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
