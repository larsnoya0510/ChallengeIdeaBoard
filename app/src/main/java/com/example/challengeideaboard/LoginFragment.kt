package com.example.challengeideaboard


import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.challengeideaboard.api_network.DataModel
import com.example.challengeideaboard.api_network.SharePreferenceUtil
import com.example.challengeideaboard.viewmodel.LoginViewModel
import com.example.challengeideaboard.viewmodel.RegisterViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.android.synthetic.main.fragment_login.view.accountEditText
import java.util.regex.Pattern

class LoginFragment : Fragment() {
    lateinit var mLoginViewModelViewModel: LoginViewModel
    lateinit var mLoginViewModelTriggerObserver: Observer<Int>
    lateinit var mLoginViewModelObserver: Observer<DataModel.ResponseLogin>

    lateinit var mRegisterViewModelViewModel: RegisterViewModel
    lateinit var mRegisterViewModelTriggerObserver: Observer<Int>
    lateinit var mRegisterViewModelObserver: Observer<DataModel.ResponseRegister>
    lateinit var LoginFragmentRootView:View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        LoginFragmentRootView= inflater.inflate(R.layout.fragment_login, container, false)
        LoginFragmentRootView.passwordEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s.toString().isNullOrEmpty()) {
                    inputVaildPasswordTextView.visibility = View.INVISIBLE
                }
                else if (checkPassword(s.toString())) {
                    inputVaildPasswordTextView.visibility = View.INVISIBLE
                    LoginFragmentRootView.registerButton.isEnabled=true
                    LoginFragmentRootView.registerButton.setTextColor(Color.BLACK)
                    LoginFragmentRootView.loginButton.isEnabled=true
                    LoginFragmentRootView.loginButton.setTextColor(Color.BLACK)
                } else {
                    inputVaildPasswordTextView.visibility = View.VISIBLE
                    LoginFragmentRootView.registerButton.isEnabled=false
                    LoginFragmentRootView.loginButton.isEnabled=false
                    LoginFragmentRootView.registerButton.setTextColor(Color.GRAY)
                    LoginFragmentRootView.loginButton.setTextColor(Color.GRAY)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        mLoginViewModelViewModel= ViewModelProvider(this).get(LoginViewModel::class.java)
        mLoginViewModelTriggerObserver = Observer {
            when(it){
                200-> {
                mLoginViewModelViewModel.setLoginResponseDataTrigger(0)
                clickBackIcon()
            }
                403-> {
                    Toast.makeText(this.context,"此用戶不存在，請點選註冊",Toast.LENGTH_SHORT).show()
                }
                else ->{

                }
            }
        }
        mLoginViewModelObserver = Observer {
            if(it.now_user!=null) {
                SharePreferenceUtil.saveToken(this.context!!, it.now_user!!.api_token)
                SharePreferenceUtil.saveUser(this.context!!, it.now_user!!.user_name)
            }
            else{
                Toast.makeText(this.context,"此用戶不存在，請點選註冊",Toast.LENGTH_SHORT).show()
            }
        }
        mLoginViewModelViewModel.getData().observe(viewLifecycleOwner, mLoginViewModelTriggerObserver)
        mLoginViewModelViewModel.geLoginResponseData().observe(viewLifecycleOwner, mLoginViewModelObserver)

        mRegisterViewModelViewModel= ViewModelProvider(this@LoginFragment).get(RegisterViewModel::class.java)
        mRegisterViewModelTriggerObserver = Observer {
            when(it){
                0->{

                }
                200-> {
                    mRegisterViewModelViewModel.setRegisterResponseDataTrigger(0)
                }
                else ->{
//                    Toast.makeText(this.context,mRegisterViewModelViewModel.getErrorMessage().value.toString(),Toast.LENGTH_SHORT).show()
                }
            }
        }
        mRegisterViewModelObserver = Observer {
            if(it.create!=null){
                Toast.makeText(this.context,"註冊成功，請點選登入",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this.context,"註冊失敗，請重新註冊",Toast.LENGTH_SHORT).show()
            }
        }
        mRegisterViewModelViewModel.getData().observe(viewLifecycleOwner!!, mRegisterViewModelTriggerObserver)
        mRegisterViewModelViewModel.getRegisterResponseData().observe(viewLifecycleOwner!!, mRegisterViewModelObserver)

        LoginFragmentRootView.loginButton.setOnClickListener { requestLogin() }
        LoginFragmentRootView.registerButton.setOnClickListener { requestRegister() }
        return LoginFragmentRootView
    }
    fun requestLogin(){
        var userName=LoginFragmentRootView.accountEditText.text.toString()
        var password=LoginFragmentRootView.passwordEditText.text.toString()
        if(!userName.isNullOrEmpty() && !password.isNullOrEmpty()){
            mLoginViewModelViewModel.RequestLogin(userName,password)
        }
        else{
            Toast.makeText(this.context,"帳號或密碼不得為空",Toast.LENGTH_SHORT).show()
        }

    }
    fun requestRegister(){
        var userName=LoginFragmentRootView.accountEditText.text.toString()
        var password=LoginFragmentRootView.passwordEditText.text.toString()
        if(!userName.isNullOrEmpty() && !password.isNullOrEmpty()){
            mRegisterViewModelViewModel.RequestRegister(userName,password)
        }
        else{
            Toast.makeText(this.context,"帳號或密碼不得為空",Toast.LENGTH_SHORT).show()
        }

    }
    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }

    private fun clickBackIcon() {
        (activity as MainActivity).checkLogin()
        if (this.fragmentManager!!.backStackEntryCount > 0) {
            this.fragmentManager!!.popBackStack()
        } else {
            this.activity!!.finish()
        }
    }
    private fun checkPassword(phoneStr: String): Boolean {
        //var regex = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
        var regex = "[0-9]\\d{7,19}"
        var p = Pattern.compile(regex)
        var m = p.matcher(phoneStr)
        return m.find()
    }

}
