package com.example.challengeideaboard.api_network

import com.example.challengeideaboard.viewmodel.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class APIFunction {
    companion object {
        fun login(loginBodyData: DataModel.LoginBody, viewModel: LoginViewModel) {
            val call: Call<DataModel.ResponseLogin> =
                ApiClient.getClient.loginAccount(loginBodyData)
            call.enqueue(object : Callback<DataModel.ResponseLogin> {
                override fun onResponse(
                    call: Call<DataModel.ResponseLogin>?,
                    response: Response<DataModel.ResponseLogin>
                ) {
                    if (response!!.isSuccessful) { // 2XX
                        viewModel.setLoginResponseDataTrigger(200, response.body())

                    } else {
                        viewModel.setLoginResponseDataTrigger(
                            response!!.code(),
                            response.errorBody().string()
                        )
                    }
                }

                override fun onFailure(call: Call<DataModel.ResponseLogin>?, t: Throwable?) {
                    viewModel.setErrorMessage(APIResponseMessage.onFailure)
                }
            })
        }

        fun register(registerBodyData: DataModel.RegisterBody, viewModel: RegisterViewModel) {
            val call: Call<DataModel.ResponseRegister> =
                ApiClient.getClient.registerAccount(registerBodyData)
            call.enqueue(object : Callback<DataModel.ResponseRegister> {
                override fun onResponse(
                    call: Call<DataModel.ResponseRegister>?,
                    response: Response<DataModel.ResponseRegister>
                ) {
                    if (response!!.isSuccessful) { // 2XX
                        viewModel.setRegisterResponseDataTrigger(200, response.body())

                    } else {
                        viewModel.setRegisterResponseDataTrigger(
                            response!!.code(),
                            response.errorBody().string()
                        )
                    }
                }

                override fun onFailure(
                    call: Call<DataModel.ResponseRegister>?,
                    t: Throwable?
                ) {
                    viewModel.setErrorMessage(APIResponseMessage.onFailure)
                }
            })
        }

        fun logout(logoutBodyData: DataModel.LogoutBody, viewModel: LogoutViewModel) {
            val call: Call<DataModel.ResponseLogout> =
                ApiClient.getClient.logoutAccount(logoutBodyData.token,logoutBodyData)
            call.enqueue(object : Callback<DataModel.ResponseLogout> {
                override fun onResponse(
                    call: Call<DataModel.ResponseLogout>?,
                    response: Response<DataModel.ResponseLogout>
                ) {
                    if (response!!.isSuccessful) { // 2XX
                        viewModel.setLogoutResponseDataTrigger(200, response.body())

                    } else {
                        viewModel.setLogoutResponseDataTrigger(
                            response!!.code(),
                            response.errorBody().string()
                        )
                    }
                }

                override fun onFailure(call: Call<DataModel.ResponseLogout>?, t: Throwable?) {
                    viewModel.setErrorMessage(APIResponseMessage.onFailure)
                }
            })
        }
        fun board(viewModel: BoardViewModel) {
            val call: Call<DataModel.ResponseBoard> =
                ApiClient.getClient.getBoard()
            call.enqueue(object : Callback<DataModel.ResponseBoard> {
                override fun onResponse(
                    call: Call<DataModel.ResponseBoard>?,
                    response: Response<DataModel.ResponseBoard>
                ) {
                    if (response!!.isSuccessful) { // 2XX
                        viewModel.setBoardResponseDataTrigger(200, response.body())

                    } else {
                        viewModel.setBoardResponseDataTrigger(
                            response!!.code(),
                            response.errorBody().string()
                        )
                    }
                }

                override fun onFailure(call: Call<DataModel.ResponseBoard>?, t: Throwable?) {
                    viewModel.setErrorMessage(APIResponseMessage.onFailure)
                }
            })
        }
        fun pushGood(pushGoodBodyData: DataModel.PushGoodBody, viewModel: PushGoodViewModel) {
            val call: Call<DataModel.ResponsePushGood> =
                ApiClient.getClient.pushGood(pushGoodBodyData.token,pushGoodBodyData)
            call.enqueue(object : Callback<DataModel.ResponsePushGood> {
                override fun onResponse(
                    call: Call<DataModel.ResponsePushGood>?,
                    response: Response<DataModel.ResponsePushGood>
                ) {
                    if (response!!.isSuccessful) { // 2XX
                        viewModel.setPushGoodResponseDataTrigger(200, response.body())

                    } else {
                        viewModel.setPushGoodResponseDataTrigger(
                            response!!.code(),
                            response.errorBody().string()
                        )
                    }
                }

                override fun onFailure(call: Call<DataModel.ResponsePushGood>?, t: Throwable?) {
                    viewModel.setErrorMessage(APIResponseMessage.onFailure)
                }
            })
        }
//        fun signUp(signUpBody:DataModel.signUpBody, viewModel: SignUpViewModel){
////            var signUpData=DataModel.signUpBody(account,password,verify_code,role,gender,first_name,last_name)
//            val call: Call<Void> = ApiClient.getClient.signUp(signUpBody)
//            call.enqueue(object : Callback<Void> {
//                override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
//                    if (response!!.isSuccessful) { // 2XX
//                        viewModel.setSignUpResult("200 Successful")
//
//                    } else {
////                        viewModel.setSignUpResult(response.message())
//                        viewModel.setSignUpResult(returnResponseErrorBody(response.errorBody().string()))
//                    }
//                }
//
//                override fun onFailure(call: Call<Void>?, t: Throwable?) {
////                    viewModel.setSignUpResult(t.toString())
//                    viewModel.setSignUpResult(APIResponseMessage.onFailure)
//                }
//            })
//        }
//        fun login(loginBodyData:DataModel.LoginBody, viewModel: LoginViewModel){
////            var loginBodyData=DataModel.LoginBody(account,password,role)
//            val call: Call<DataModel.ResponseLogin> = ApiClient.getClient.loginAccount(loginBodyData)
//            call.enqueue(object : Callback<DataModel.ResponseLogin> {
//                override fun onResponse(call: Call<DataModel.ResponseLogin>?, response: Response<DataModel.ResponseLogin>?) {
//                    if (response!!.isSuccessful) { // 2XX
////                        viewModel.setLoginResult("200 Successful")
//                        viewModel.setResponse("200 Successful",response.body())
//
//                    } else {
//                        viewModel.setLoginResult(returnResponseErrorBody(response.errorBody().string()))
//
////                        viewModel.setLoginResult(response.message())
////                        viewModel.setLoginResult(response.errorBody())
//
//                    }
//                }
//
//                override fun onFailure(call: Call<DataModel.ResponseLogin>?, t: Throwable?) {
////                    viewModel.setLoginResult(t.toString())
//                    viewModel.setLoginResult(APIResponseMessage.onFailure)
//                }
//            })
//        }
//        fun getProfile(getProfileBodyData:DataModel.getProfileBody,viewModel : GetProfileViewModel){
////            var getProfileData=DataModel.getProfileBody(token,id)
//            val call: Call<DataModel.responseProfile> = ApiClient.getClient.getProfile(getProfileBodyData.token,getProfileBodyData.id)
//            call.enqueue(object : Callback<DataModel.responseProfile> {
//                override fun onResponse(call: Call<DataModel.responseProfile>?, response: Response<DataModel.responseProfile>?) {
//                    if (response!!.isSuccessful) { // 2XX
//                        viewModel.setResponse("200",response.body())
//
//                    } else {
////                        viewModel.setGetProfileResult(response.code().toString())
//                        viewModel.setGetProfileResult(returnResponseErrorBody(response.errorBody().string()))
//                    }
//                }
//
//                override fun onFailure(call: Call<DataModel.responseProfile>?, t: Throwable?) {
////                    viewModel.setGetProfileResult(t.toString())
//                    viewModel.setGetProfileResult(APIResponseMessage.onFailure)
//                }
//            })
//        }
    }

}