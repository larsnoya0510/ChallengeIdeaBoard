package com.example.challengeideaboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.challengeideaboard.api_network.DataModel
import com.example.challengeideaboard.api_network.SharePreferenceUtil
import com.example.challengeideaboard.utilities.GlobalLoading
import com.example.challengeideaboard.utilities.MainFragmentList
import com.example.challengeideaboard.viewmodel.BoardViewModel
import com.example.challengeideaboard.viewmodel.LoginViewModel
import com.example.challengeideaboard.viewmodel.LogoutViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mFragmentList: MainFragmentList
    lateinit var mLogoutViewModelViewModel: LogoutViewModel
    lateinit var mLogoutViewModelTriggerObserver: Observer<Int>
    lateinit var mLogoutViewModelObserver: Observer<DataModel.ResponseLogout>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mFragmentList = MainFragmentList()
        GlobalLoading.showGlobalLoading(this!!)
        initView()
        checkLogin()
        LoginTextView.setOnClickListener { gotoLogin() }
        LogoutTextView.setOnClickListener { gotoLogout() }

        mLogoutViewModelViewModel= ViewModelProvider(this).get(LogoutViewModel::class.java)
        mLogoutViewModelTriggerObserver = Observer {
            when(it){
                200-> {
                    mLogoutViewModelViewModel.setLogoutResponseDataTrigger(0)
                            SharePreferenceUtil.removeToken(this)
                            SharePreferenceUtil.removeUser(this)
                            checkLogin()
                }
                403-> {

                }
                else ->{

                }
            }
        }
        mLogoutViewModelObserver = Observer {

        }
        mLogoutViewModelViewModel.getData().observe(this, mLogoutViewModelTriggerObserver)
        mLogoutViewModelViewModel.geLoginResponseData().observe(this, mLogoutViewModelObserver)



    }

    override fun onResume() {
        super.onResume()

    }

    fun checkLogin(){
        if(SharePreferenceUtil.getUserToken(this).isNullOrEmpty()){
            LoginTextView.visibility= View.VISIBLE
            LogoutTextView.visibility= View.GONE
            authorTextView.text=""
        }
        else{
            LoginTextView.visibility= View.GONE
            LogoutTextView.visibility= View.VISIBLE
            authorTextView.text=SharePreferenceUtil.getUser(this)
        }
    }
    fun gotoLogin(){
        var action = this.supportFragmentManager!!.beginTransaction()
        action.replace(R.id.fragmentContainer,
            mFragmentList.mLoginFragment
        )
        action.addToBackStack(null)
        action.commit()
    }
    fun gotoLogout(){
//        SharePreferenceUtil.removeToken(this)
////        SharePreferenceUtil.removeUser(this)
////        checkLogin()
        var token="Bearer ${SharePreferenceUtil.getUserToken(this!!)}"
        var username=authorTextView.text.toString()
        mLogoutViewModelViewModel.RequestLogout(token,username)
    }
    fun initView()
    {
        var action = this.supportFragmentManager!!.beginTransaction()
        action.replace(R.id.fragmentContainer,
            mFragmentList.mIdeaBoardFragment
        )
//        action.addToBackStack(null)
        action.commit()

    }
}
