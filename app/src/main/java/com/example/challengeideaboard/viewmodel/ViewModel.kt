package com.example.challengeideaboard.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challengeideaboard.api_network.APIFunction
import com.example.challengeideaboard.api_network.DataModel

class ViewModel {
}
class LoginViewModel() : ViewModel() {
    private var loginResponseData = MutableLiveData<DataModel.ResponseLogin>()
    private var loginResponseDataTrigger = MutableLiveData<Int>()
    private var errorMessage = MutableLiveData<String>()
    fun RequestLogin(userName:String,password:String){
        APIFunction.login(DataModel.LoginBody(userName,password),this)
    }
    fun setLoginResponseDataTrigger(result: Int,mData: DataModel.ResponseLogin) {
        loginResponseDataTrigger.postValue(result)
        setResponse(mData)
    }
    fun setLoginResponseDataTrigger(result: Int) {
        loginResponseDataTrigger.postValue(result)
    }
    fun setLoginResponseDataTrigger(result: Int,mErrorMeaasge:String) {
        loginResponseDataTrigger.postValue(result)
        setErrorMessage(mErrorMeaasge)
    }
    fun setErrorMessage(mErrorMeaasge:String){
        errorMessage.postValue(mErrorMeaasge)
    }
    fun setResponse( mData: DataModel.ResponseLogin) {
        loginResponseData.value=mData
    }
    fun geLoginResponseData(): MutableLiveData<DataModel.ResponseLogin> {
        return loginResponseData
    }
    fun getData(): MutableLiveData<Int> {
        return loginResponseDataTrigger
    }
    fun getErrorMessage(): MutableLiveData<String> {
        return errorMessage
    }
}
class RegisterViewModel() : ViewModel() {
    private var registerResponseData = MutableLiveData<DataModel.ResponseRegister>()
    private var registerResponseDataTrigger = MutableLiveData<Int>()
    private var errorMessage = MutableLiveData<String>()
    fun RequestRegister(userName:String,password:String){
        APIFunction.register(DataModel.RegisterBody(userName,password),this)
    }
    fun setRegisterResponseDataTrigger(result: Int,mData: DataModel.ResponseRegister) {
        registerResponseDataTrigger.postValue(result)
        setResponse(mData)
    }
    fun setRegisterResponseDataTrigger(result: Int) {
        registerResponseDataTrigger.postValue(result)
    }
    fun setRegisterResponseDataTrigger(result: Int,mErrorMeaasge:String) {
        registerResponseDataTrigger.postValue(result)
        setErrorMessage(mErrorMeaasge)
    }
    fun setErrorMessage(mErrorMeaasge:String){
        errorMessage.postValue(mErrorMeaasge)
    }

    fun setResponse( mData: DataModel.ResponseRegister) {
        registerResponseData.value=mData
    }
    fun getRegisterResponseData(): MutableLiveData<DataModel.ResponseRegister> {
        return registerResponseData
    }
    fun getData(): MutableLiveData<Int> {
        return registerResponseDataTrigger
    }
    fun getErrorMessage(): MutableLiveData<String> {
        return errorMessage
    }
}
class LogoutViewModel() : ViewModel() {
    private var logoutResponseData = MutableLiveData<DataModel.ResponseLogout>()
    private var logoutResponseDataTrigger = MutableLiveData<Int>()
    private var errorMessage = MutableLiveData<String>()
    fun RequestLogout(token:String,userName:String){
        APIFunction.logout(DataModel.LogoutBody(token,userName),this)
    }
    fun setLogoutResponseDataTrigger(result: Int,mData: DataModel.ResponseLogout) {
        logoutResponseDataTrigger.postValue(result)
        setResponse(mData)
    }
    fun setLogoutResponseDataTrigger(result: Int) {
        logoutResponseDataTrigger.postValue(result)
    }
    fun setLogoutResponseDataTrigger(result: Int,mErrorMeaasge:String) {
        logoutResponseDataTrigger.postValue(result)
        setErrorMessage(mErrorMeaasge)
    }
    fun setErrorMessage(mErrorMeaasge:String){
        errorMessage.postValue(mErrorMeaasge)
    }
    fun setResponse( mData: DataModel.ResponseLogout) {
        logoutResponseData.value=mData
    }
    fun geLoginResponseData(): MutableLiveData<DataModel.ResponseLogout> {
        return logoutResponseData
    }
    fun getData(): MutableLiveData<Int> {
        return logoutResponseDataTrigger
    }
    fun getErrorMessage(): MutableLiveData<String> {
        return errorMessage
    }
}
class BoardViewModel() : ViewModel() {
    private var boardResponseData = MutableLiveData<DataModel.ResponseBoard>()
    private var boardResponseDataTrigger = MutableLiveData<Int>()
    private var errorMessage = MutableLiveData<String>()
    fun RequestBoard(){
        APIFunction.board(this)
    }
    fun setBoardResponseDataTrigger(result: Int,mData: DataModel.ResponseBoard) {
        boardResponseDataTrigger.postValue(result)
        setResponse(mData)
    }
    fun setBoardResponseDataTrigger(result: Int) {
        boardResponseDataTrigger.postValue(result)
    }
    fun setBoardResponseDataTrigger(result: Int,mErrorMeaasge:String) {
        boardResponseDataTrigger.postValue(result)
        setErrorMessage(mErrorMeaasge)
    }
    fun setErrorMessage(mErrorMeaasge:String){
        errorMessage.postValue(mErrorMeaasge)
    }
    fun setResponse( mData: DataModel.ResponseBoard) {
        boardResponseData.value=mData
    }
    fun getBoardResponseData(): MutableLiveData<DataModel.ResponseBoard> {
        return boardResponseData
    }
    fun getData(): MutableLiveData<Int> {
        return boardResponseDataTrigger
    }
    fun getErrorMessage(): MutableLiveData<String> {
        return errorMessage
    }
}
class PushGoodViewModel() : ViewModel() {
    private var pushGoodResponseData = MutableLiveData<DataModel.ResponsePushGood>()
    private var pushGoodResponseDataTrigger = MutableLiveData<Int>()
    private var errorMessage = MutableLiveData<String>()
    fun RequestPushGood(token:String,boardId:Int,userName:String){
        APIFunction.pushGood(DataModel.PushGoodBody(token,boardId,userName),this)
    }
    fun setPushGoodResponseDataTrigger(result: Int,mData: DataModel.ResponsePushGood) {
        pushGoodResponseDataTrigger.postValue(result)
        setResponse(mData)
    }
    fun setPushGoodResponseDataTrigger(result: Int) {
        pushGoodResponseDataTrigger.postValue(result)
    }
    fun setPushGoodResponseDataTrigger(result: Int,mErrorMeaasge:String) {
        pushGoodResponseDataTrigger.postValue(result)
        setErrorMessage(mErrorMeaasge)
    }
    fun setErrorMessage(mErrorMeaasge:String){
        errorMessage.postValue(mErrorMeaasge)
    }
    fun setResponse( mData: DataModel.ResponsePushGood) {
        pushGoodResponseData.value=mData
    }
    fun getpushGoodResponseData(): MutableLiveData<DataModel.ResponsePushGood> {
        return pushGoodResponseData
    }
    fun getData(): MutableLiveData<Int> {
        return pushGoodResponseDataTrigger
    }
    fun getErrorMessage(): MutableLiveData<String> {
        return errorMessage
    }
}
class PushMsgViewModel() : ViewModel() {
    private var pushMsgResponseData = MutableLiveData<DataModel.ResponsePushMsg>()
    private var pushMsgResponseDataTrigger = MutableLiveData<Int>()
    private var errorMessage = MutableLiveData<String>()
    fun RequestPushMsg(token:String,author:String,content:String){
        APIFunction.pushMsg(DataModel.PushMsgBody(token,author,content),this)
    }
    fun setPushMsgResponseDataTrigger(result: Int,mData: DataModel.ResponsePushMsg) {
        pushMsgResponseDataTrigger.value=result
        setResponse(mData)
    }
    fun setPushMsgResponseDataTrigger(result: Int) {
        pushMsgResponseDataTrigger.value=result
    }
    fun setPushMsgResponseDataTrigger(result: Int,mErrorMeaasge:String) {
        pushMsgResponseDataTrigger.value=result
        setErrorMessage(mErrorMeaasge)
    }
    fun setErrorMessage(mErrorMeaasge:String){
        errorMessage.value=mErrorMeaasge
    }
    fun setResponse( mData: DataModel.ResponsePushMsg) {
        pushMsgResponseData.value=mData
    }
    fun getpushMsgResponseData(): MutableLiveData<DataModel.ResponsePushMsg> {
        return pushMsgResponseData
    }
    fun getData(): MutableLiveData<Int> {
        return pushMsgResponseDataTrigger
    }
    fun getErrorMessage(): MutableLiveData<String> {
        return errorMessage
    }
}
class PushReplyViewModel() : ViewModel() {
    private var pushReplyResponseData = MutableLiveData<DataModel.ResponsePushReply>()
    private var pushReplyResponseDataTrigger = MutableLiveData<Int>()
    private var errorMessage = MutableLiveData<String>()
    fun RequestPushReply(token:String,board_id:Int,msg_user:String,msg:String){
        APIFunction.pushReply(DataModel.PushReplyBody(token,board_id,msg_user,msg),this)
    }
    fun setPushReplyResponseDataTrigger(result: Int,mData: DataModel.ResponsePushReply) {
        pushReplyResponseDataTrigger.value=result
        setResponse(mData)
    }
    fun setPushReplyResponseDataTrigger(result: Int) {
        pushReplyResponseDataTrigger.value=result
    }
    fun setPushReplyResponseDataTrigger(result: Int,mErrorMeaasge:String) {
        pushReplyResponseDataTrigger.value=result
        setErrorMessage(mErrorMeaasge)
    }
    fun setErrorMessage(mErrorMeaasge:String){
        errorMessage.value=mErrorMeaasge
    }
    fun setResponse( mData: DataModel.ResponsePushReply) {
        pushReplyResponseData.value=mData
    }
    fun getpushReplyResponseData(): MutableLiveData<DataModel.ResponsePushReply> {
        return pushReplyResponseData
    }
    fun getData(): MutableLiveData<Int> {
        return pushReplyResponseDataTrigger
    }
    fun getErrorMessage(): MutableLiveData<String> {
        return errorMessage
    }
}
class PushReplySecondViewModel() : ViewModel() {
    private var pushReplySecondResponseData = MutableLiveData<DataModel.ResponsePushReplySecond>()
    private var pushReplySecondResponseDataTrigger = MutableLiveData<Int>()
    private var errorMessage = MutableLiveData<String>()
    fun RequestPushReplySecond(token:String,board_id:Int,msg_id:Int,remsg_user:String,remsg:String){
        APIFunction.pushReplySecond(DataModel.PushReplySecondBody(token,board_id,msg_id,remsg_user,remsg),this)
    }
    fun setPushReplySecondResponseDataTrigger(result: Int,mData: DataModel.ResponsePushReplySecond) {
        pushReplySecondResponseDataTrigger.value=result
        setResponse(mData)
    }
    fun setPushReplySecondResponseDataTrigger(result: Int) {
        pushReplySecondResponseDataTrigger.value=result
    }
    fun setPushReplySecondResponseDataTrigger(result: Int,mErrorMeaasge:String) {
        pushReplySecondResponseDataTrigger.value=result
        setErrorMessage(mErrorMeaasge)
    }
    fun setErrorMessage(mErrorMeaasge:String){
        errorMessage.value=mErrorMeaasge
    }
    fun setResponse( mData: DataModel.ResponsePushReplySecond) {
        pushReplySecondResponseData.value=mData
    }
    fun getpushReplySecondResponseData(): MutableLiveData<DataModel.ResponsePushReplySecond> {
        return pushReplySecondResponseData
    }
    fun getData(): MutableLiveData<Int> {
        return pushReplySecondResponseDataTrigger
    }
    fun getErrorMessage(): MutableLiveData<String> {
        return errorMessage
    }
}