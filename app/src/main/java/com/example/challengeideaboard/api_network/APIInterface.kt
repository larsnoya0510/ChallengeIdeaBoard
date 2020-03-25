package com.example.challengeideaboard.api_network

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )
    @POST("api/frontlogin")
    fun loginAccount(
        @Body body: DataModel.LoginBody
    ): Call<DataModel.ResponseLogin>

    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )
    @POST("api/frontlogout")
    fun logoutAccount(
        @Header("Authorization") token: String,
        @Body body: DataModel.LogoutBody
    ): Call<DataModel.ResponseLogout>

    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )
    @POST("api/frontstore")
    fun registerAccount(
        @Body body: DataModel.RegisterBody
    ): Call<DataModel.ResponseRegister>

    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )
    @GET("api/frontall")
    fun getBoard(

    ): Call<DataModel.ResponseBoard>

    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )
    @POST("api/frontgood")
    fun pushGood(
        @Header("Authorization") token: String,
        @Body body: DataModel.PushGoodBody
    ): Call<DataModel.ResponsePushGood>

    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )
    @POST("api/frontboard")
    fun pushMsg(
        @Header("Authorization") token: String,
        @Body body: DataModel.PushMsgBody
    ): Call<DataModel.ResponsePushMsg>
////=========================================
////    @Headers(
////        "Accept: application/json",
////        "Content-Type: application/json"
////    )
////    @GET("api/users/{id}")
////    fun getProfile(
////        @Header("Authorization") token: String, @Path("id") id: Int
////
////    ): Call<DataModel.responseProfile>
//
//    @Headers(
//        "Accept: application/json",
//        "Content-Type: application/json"
//    )
//    @GET("api/sms-code")
//    fun sendSMSCode(
////        @Body body: DataModel.smsBody
//        @Query("mobile") mobile: String, @Query("purpose") purpose: Int
//    ): Call<Void>
//
//    @Headers(
//        "Accept: application/json",
//        "Content-Type: application/json"
//    )
//    @POST("api/reset-password")
//    fun resetPassword(
//        @Body body: DataModel.resetPasswordBody
//    ): Call<Void>
//
//    @Headers(
//        "Accept: application/json",
//        "Content-Type: application/json"
//    )
//    @POST("api/sign-up")
//    fun signUp(
//        @Body body: DataModel.signUpBody
//    ): Call<Void>
//
////    @Headers(
////        "Accept: application/json",
////        "Content-Type: application/json"
////    )
//    @PUT("api/users/{id}")
//    fun updateProfile(
//        @Header("Authorization") token: String,
//        @Path("id") id: Int,
//        @Body body: DataModel.updateProfileBody
//    ): Call<Void>
//
////    @Headers(
////        "Accept: application/json",
////        "content-type: multipart/form-data;",
////        "Content-Type: application/x-www-form-urlencoded"
////    )
//    @Multipart
//    @POST("api/media")
//    fun uploadImage(
//        @Header("Authorization") token: String,
//        @Part  file:MultipartBody.Part
//    ): Call<DataModel.responseImage>
//
//    @Headers(
//        "Accept: application/json",
//        "Content-Type: application/json"
//    )
//    @GET("api/announcements")
//    fun getAnnouncements(
//
//    ): Call<DataModel.ResponseAnnouncements>
//    @Headers(
//        "Accept: application/json",
//        "Content-Type: application/json"
//    )
//    @GET("api/announcements")
//    fun getAnnouncementsPage(
//        @Query("page") page: Int
//    ): Call<DataModel.ResponseAnnouncements>
//
//    @Headers(
//        "Accept: application/json",
//        "Content-Type: application/json"
//    )
//    @GET("api/tags")
//    fun getTags(
//        @Header("Authorization") token: String
//
//    ): Call<DataModel.responseTags>
//
////    @GET("reverseGeocode")
////    fun getAddress(
////        @Query("f") f: String="pjson",
////        @Query("langCode") langCode: String="tw",
////        @Query("featureTypes") featureTypes: String="",
////        @Query("location") location: String
////
////    ): Call<DataModel.responseAddress>
//
//    @GET("api/geocode/json")
//    fun getAddress(
//        @Query("latlng") latlng: String,
//        @Query("sensor") sensor: String,
//        @Query("language") language: String,
//        @Query("key") key: String
//
//    ): Call<DataModel.responseAddress>
//
//    @GET("api/geocode/json")
//    fun getLatlng(
//        @Query("address") address: String,
//        @Query("sensor") sensor: String,
//        @Query("language") language: String,
//        @Query("key") key: String
//
//    ): Call<DataModel.responseAddress>
//
//    @GET("api/distancematrix/json")
//    fun getDistance(
//        @Query("origins") origins: String,
//        @Query("destinations") destinations: String,
//        @Query("language") language: String,
//        @Query("key") key: String
//
//    ): Call<DataModel.ResponseDistance>
//
//    @Headers(
//        "Accept: application/json",
//        "Content-Type: application/json"
//    )
//    @POST("api/orders")
//    fun createOrder(
//        @Header("Authorization") token: String,
//        @Body body: DataModel.CreateOrderBody
//    ): Call<DataModel.ResponseOrderDetail>
//
//    @Headers(
//        "Accept: application/json",
//        "Content-Type: application/json"
//    )
//    @GET("api/orders")
//    fun getOrders(
//        @Header("Authorization") token: String
//    ): Call<DataModel.ResponseOrders>
//    @Headers(
//        "Accept: application/json",
//        "Content-Type: application/json"
//    )
//    @GET("api/orders")
//    fun getOrdersPage(
//        @Header("Authorization") token: String,
//        @Query("page") page: Int
//    ): Call<DataModel.ResponseOrders>
//    @Headers(
//        "Accept: application/json",
//        "Content-Type: application/json"
//    )
//    @GET("api/orders/{id}")
//    fun getOrderDetial(
//        @Header("Authorization") token: String,
//        @Path("id") id: Int
//    ): Call<DataModel.ResponseOrderDetail>
//
//    @Headers(
//        "Accept: application/json",
//        "Content-Type: application/json"
//    )
//    @PUT("/api/orders/{id}/cancel")
//    fun cancelOrder(
//        @Header("Authorization") token: String,
//        @Path("id") id: Int,
//        @Body body: DataModel.CancelOrderBody
//    ): Call<Void>
//
//    @Headers(
//        "Accept: application/json",
//        "Content-Type: application/json"
//    )
//    @POST("/api/payments")
//    fun requestPayment_Old(
//        @Header("Authorization") token: String,
//        @Body body: DataModel.RequestPaymentBody
//    ): Call<DataModel.ResponseRequestPayment>
//
//    @Headers(
//        "Accept: application/json",
//        "Content-Type: application/json"
//    )
//    @GET("/api/orders/{orderId}/payment")
//    fun requestPayment(
//        @Header("Authorization") token: String,
//        @Path("orderId") orderId: Int,
//        @Query("channel") channel: String,
//        @Query("method") lat: Int
//    ): Call<DataModel.ResponseRequestPayment>
//
//    @Headers(
//        "Accept: application/json",
//        "Content-Type: application/json"
//    )
//    @POST("/api/order-feedback")
//    fun createOrderFeedback(
//        @Header("Authorization") token: String,
//        @Body body: DataModel.CreateOrderFeedbackBody
//    ): Call<Void>
//    @Headers(
//        "Accept: application/json",
//        "Content-Type: application/json"
//    )
//    @GET("/api/nearby-taxi")
//    fun getNearByTaxi(
//        @Header("Authorization") token: String,
//        @Query("lat") lat: String,
//        @Query("lng") lng: String
//    ): Call<DataModel.ResponseGetNearByTaxi>
//
//    @Headers(
//        "Accept: application/json",
//        "Content-Type: application/json"
//    )
//    @GET("api/passenger-current-state")
//    fun getCurrentState(
//        @Header("Authorization") token: String
//    ): Call<DataModel.ResponseGetCurrentState>
//
//    @GET("/api/taxi-fees")
//    fun getEstimateTaxiFee(
//        @Header("Authorization") token: String,
//        @Query("distance") distance: String
//    ): Call<DataModel.ResponseGetEstimateTaxiFee>
//
//    @Headers(
//        "Accept: application/json",
//        "Content-Type: application/json"
//    )
//    @POST("api/logout")
//    fun logoutAccount(
//        @Header("Authorization") token: String
//    ): Call<Void>
//
//    //==ecpay===
//    @POST("/Cashier/AioCheckOut/V5")
//    fun getPaymentPage(
//        @Body body: DataModel.GetPaymentPageBody
//    ): Call<String>
//
//    @Headers(
//        "Accept: application/json",
//        "Content-Type: application/json"
//    )
//    @GET("api/cards")
//    fun getMenGoCard(
//        @Header("Authorization") token: String
//
//    ): Call<DataModel.ResponseMenGoCard>
//
//    @Headers(
//        "Accept: application/json",
//        "Content-Type: application/json"
//    )
//    @DELETE("api/cards/{id}")
//    fun deleteMenGoCard(
//        @Header("Authorization") token: String,
//        @Path("id") cardId: Int
//    ): Call<Void>
//
//    @Headers(
//        "Accept: application/json",
//        "Content-Type: application/json"
//    )
//    @POST("api/cards")
//    fun createMenGoCard(
//        @Header("Authorization") token: String,
//        @Body body: DataModel.CreateMenGoCardBody
//    ): Call<DataModel.ResponseCreateMenGoCard>
//
//    @Headers(
//        "Accept: application/json",
//        "Content-Type: application/json"
//    )
//    @GET("api/orders/{orderId}/payment?channel=mengo&method=1")
//    fun requestPaymentMenGoCard(
//        @Header("Authorization") token: String,
//        @Path("orderId") orderId: Int
//    ): Call<DataModel.ResponsePaymentMenGoCard>
//
//    @Headers(
//        "Accept: application/json",
//        "Content-Type: application/json"
//    )
//    @POST("api/payments/{paymentId}/pay?channel=mengo")
//    fun payByMenGoCard(
//        @Header("Authorization") token: String,
//        @Path("paymentId") paymentId: Int
//    ): Call<Void>
}