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
        fun pushMsg(pushMsgBodyData: DataModel.PushMsgBody, viewModel: PushMsgViewModel) {
            val call: Call<DataModel.ResponsePushMsg> =
                ApiClient.getClient.pushMsg(pushMsgBodyData.token,pushMsgBodyData)
            call.enqueue(object : Callback<DataModel.ResponsePushMsg> {
                override fun onResponse(
                    call: Call<DataModel.ResponsePushMsg>?,
                    response: Response<DataModel.ResponsePushMsg>
                ) {
                    if (response!!.isSuccessful) { // 2XX
                        viewModel.setPushMsgResponseDataTrigger(200, response.body())

                    } else {
                        viewModel.setPushMsgResponseDataTrigger(
                            response!!.code(),
                            response.errorBody().string()
                        )
                    }
                }

                override fun onFailure(call: Call<DataModel.ResponsePushMsg>?, t: Throwable?) {
                    viewModel.setErrorMessage(APIResponseMessage.onFailure)
                }
            })
        }
        fun pushReply(pushReplyBodyData: DataModel.PushReplyBody, viewModel: PushReplyViewModel) {
            val call: Call<DataModel.ResponsePushReply> =
                ApiClient.getClient.pushReply(pushReplyBodyData.token,pushReplyBodyData)
            call.enqueue(object : Callback<DataModel.ResponsePushReply> {
                override fun onResponse(
                    call: Call<DataModel.ResponsePushReply>?,
                    response: Response<DataModel.ResponsePushReply>
                ) {
                    if (response!!.isSuccessful) { // 2XX
                        viewModel.setPushReplyResponseDataTrigger(200, response.body())

                    } else {
                        viewModel.setPushReplyResponseDataTrigger(
                            response!!.code(),
                            response.errorBody().string()
                        )
                    }
                }

                override fun onFailure(call: Call<DataModel.ResponsePushReply>?, t: Throwable?) {
                    viewModel.setErrorMessage(APIResponseMessage.onFailure)
                }
            })
        }
        fun pushReplySecond(pushReplySecondBodyData: DataModel.PushReplySecondBody, viewModel: PushReplySecondViewModel) {
            val call: Call<DataModel.ResponsePushReplySecond> =
                ApiClient.getClient.pushReplySecond(pushReplySecondBodyData.token,pushReplySecondBodyData)
            call.enqueue(object : Callback<DataModel.ResponsePushReplySecond> {
                override fun onResponse(
                    call: Call<DataModel.ResponsePushReplySecond>?,
                    response: Response<DataModel.ResponsePushReplySecond>
                ) {
                    if (response!!.isSuccessful) { // 2XX
                        viewModel.setPushReplySecondResponseDataTrigger(200, response.body())

                    } else {
                        viewModel.setPushReplySecondResponseDataTrigger(
                            response!!.code(),
                            response.errorBody().string()
                        )
                    }
                }

                override fun onFailure(call: Call<DataModel.ResponsePushReplySecond>?, t: Throwable?) {
                    viewModel.setErrorMessage(APIResponseMessage.onFailure)
                }
            })
        }
        fun getGood(getGoodBodyData: DataModel.GetGoodBody, viewModel: GetGoodViewModel) {
            val call: Call<DataModel.ResponseGetGood> =
                ApiClient.getClient.getGood(getGoodBodyData.token,getGoodBodyData)
            call.enqueue(object : Callback<DataModel.ResponseGetGood> {
                override fun onResponse(
                    call: Call<DataModel.ResponseGetGood>?,
                    response: Response<DataModel.ResponseGetGood>
                ) {
                    if (response!!.isSuccessful) { // 2XX
                        viewModel.setGetGoodResponseDataTrigger(200, response.body())

                    } else {
                        viewModel.setGetGoodResponseDataTrigger(
                            response!!.code(),
                            response.errorBody().string()
                        )
                    }
                }

                override fun onFailure(call: Call<DataModel.ResponseGetGood>?, t: Throwable?) {
                    viewModel.setErrorMessage(APIResponseMessage.onFailure)
                }
            })
        }
    }


}