package com.example.challengeideaboard


import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challengeideaboard.adapter.WatchGoodRecyclerViewAdapter
import com.example.challengeideaboard.api_network.DataModel
import com.example.challengeideaboard.api_network.SharePreferenceUtil
import com.example.challengeideaboard.viewmodel.GetGoodViewModel
import kotlinx.android.synthetic.main.fragment_watch_good.view.*

lateinit var WatchGoodFragmentRootView :View
lateinit var mAdapter: WatchGoodRecyclerViewAdapter

lateinit var mGetGoodViewModelViewModel: GetGoodViewModel
lateinit var mGetGoodViewModelTriggerObserver: Observer<Int>
lateinit var mGetGoodViewModelObserver: Observer<DataModel.ResponseGetGood>
var mBoardId=-99
class WatchGoodFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBoardId=arguments!!.getInt("BoardId") ?: -99
        WatchGoodFragmentRootView= inflater.inflate(R.layout.fragment_watch_good, container, false)
        mAdapter= WatchGoodRecyclerViewAdapter(
            context!!,
            mutableListOf<DataModel.WhoGoodItem>()
        )
        WatchGoodFragmentRootView.watchGoodRecyclerView.layoutManager=LinearLayoutManager(context)
        WatchGoodFragmentRootView.watchGoodRecyclerView.adapter=mAdapter

        mGetGoodViewModelViewModel= ViewModelProvider(this).get(GetGoodViewModel::class.java)
        mGetGoodViewModelTriggerObserver = Observer {
            when(it){
                0->{

                }
                200-> {
                    mGetGoodViewModelViewModel.setGetGoodResponseDataTrigger(0)
                }
//                403-> {
//
//                }
                401 ->{
                    SharePreferenceUtil.removeUser(context!!)
                    SharePreferenceUtil.removeToken(context!!)
                    Toast.makeText(context,"登入失效，請重新登入",Toast.LENGTH_SHORT).show()
                    (activity as MainActivity).checkLogin()
                    clickBackIcon()
                }
                else ->{
//                    var error=mGetGoodViewModelViewModel.getErrorMessage().value
                    var error="請求失敗"
                    showAlertDialog(error)
                }
            }
        }
        mGetGoodViewModelObserver = Observer {
            mAdapter.updateData(it.whogood)
        }
        mGetGoodViewModelViewModel.getData().observe(viewLifecycleOwner, mGetGoodViewModelTriggerObserver)
        mGetGoodViewModelViewModel.getgetGoodResponseData().observe(viewLifecycleOwner, mGetGoodViewModelObserver)
        WatchGoodFragmentRootView.watchGoodLeftImageView.setOnClickListener { clickBackIcon() }
         return WatchGoodFragmentRootView
    }

    override fun onResume() {
        super.onResume()
        var token="Bearer ${SharePreferenceUtil.getUserToken(context!!)}"
        mGetGoodViewModelViewModel.RequestGetGood(token,mBoardId)
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
    companion object {
        @JvmStatic
        fun newInstance() = WatchGoodFragment()
    }

    private fun clickBackIcon() {

        if (this.fragmentManager!!.backStackEntryCount > 0) {
            this.fragmentManager!!.popBackStack()
        } else {
            this.activity!!.finish()
        }
    }
}
