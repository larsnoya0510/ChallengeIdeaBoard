package com.example.challengeideaboard.api_network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

object DataModel {
    data class LoginBody(
        var user_name: String,
        var password: String
    )
    data class ResponseLogin(
        @Expose
        @SerializedName("info")
        val info: String,
        @Expose
        @SerializedName("now_user")
        val now_user: User?
    )

    data class User(
        @Expose
        @SerializedName("id")
        val id: Int,
        @Expose
        @SerializedName("user_name")
        val user_name: String,
        @Expose
        @SerializedName("api_token")
        val api_token: String,
        @Expose
        @SerializedName("create_time")
        val create_time: String

    )
    data class LogoutBody(
        var token: String,
        var user_name: String

    )
    data class ResponseLogout(
        @Expose
        @SerializedName("info")
        val info: String
    )
    data class RegisterBody(
        var user_name: String,
        var password: String
    )
    data class ResponseRegister(
        @Expose
        @SerializedName("info")
        val info: String,
        @Expose
        @SerializedName("create")
        val create: User?
    )
    data class BoardBody(
        var token: String
    )
    data class ResponseBoard(
        @Expose
        @SerializedName("all")
        val all: MutableList<BoardItem>
    )
    data class BoardItem(
        @Expose
        @SerializedName("id")
        val id: Int,
        @Expose
        @SerializedName("author")
        val author: String,
        @Expose
        @SerializedName("content")
        val content: String,
        @Expose
        @SerializedName("create_time")
        val create_time: String,
        @Expose
        @SerializedName("goods_count")
        val goods_count: Int,
        @Expose
        @SerializedName("msgs_count")
        val msgs_count: Int,
        @Expose
        @SerializedName("goods")
        val goods: MutableList<GoodsItem>,
        @Expose
        @SerializedName("msgs")
        val msgs: MutableList<MsgsItem>
    )
    data class GoodsItem(
        @Expose
        @SerializedName("id")
        val id: Int,
        @Expose
        @SerializedName("user_id")
        val user_id: String,
        @Expose
        @SerializedName("user_name")
        val user_name: String,
        @Expose
        @SerializedName("boards_id")
        val boards_id: Int,
        @Expose
        @SerializedName("create_time")
        val create_time: String
    )
    data class MsgsItem(
        @Expose
        @SerializedName("id")
        val id: Int,
        @Expose
        @SerializedName("boards_id")
        val boards_id: Int,
        @Expose
        @SerializedName("msg_user")
        val msg_user: String,
        @Expose
        @SerializedName("msg")
        val msg: String,
        @Expose
        @SerializedName("create_time")
        val create_time: String,
        @Expose
        @SerializedName("remsgs")
        val remsgs: MutableList<RemsgsItem>
    )
    data class RemsgsItem(
        @Expose
        @SerializedName("id")
        val id: Int,
        @Expose
        @SerializedName("boards_id")
        val boards_id: Int,
        @Expose
        @SerializedName("msg_id")
        val msg_id: Int,
        @Expose
        @SerializedName("remsg_user")
        val remsg_user: String,
        @Expose
        @SerializedName("remsg")
        val remsg: String,
        @Expose
        @SerializedName("create_time")
        val create_time: String,
        @Expose
        @SerializedName("remsgs")
        val remsgs: MutableList<RemsgsItem>
    )
    data class PushGoodBody(
        var token: String,
        var board_id :Int,
        var user_name: String
    )
    data class ResponsePushGood(
        @Expose
        @SerializedName("info")
        val info: String,
        @Expose
        @SerializedName("action")
        val action: Action?
    )
    data class Action(
        @Expose
        @SerializedName("user_id")
        val user_id: Int,
        @Expose
        @SerializedName("boards_id")
        val boards_id: Int,
        @Expose
        @SerializedName("user_name")
        val user_name: String,
        @Expose
        @SerializedName("create_time")
        val create_time: String,
        @Expose
        @SerializedName("id")
        val id: Int
    )
///=============================

//    data class Address(
//        @Expose
//        @SerializedName("title")
//        val title: String,
//        @Expose
//        @SerializedName("address")
//        val address: String
//    )
//
//    data class responseImage(
//        @Expose
//        @SerializedName("files")
//        val files: MutableList<ImageData>
//    )
//
//    data class ImageData(
//        @Expose
//        @SerializedName("image_name")
//        val image_name: String,
//        @Expose
//        @SerializedName("image_url")
//        val image_url: String
//    )
//
//    data class ResponseAnnouncements(
//        @Expose
//        @SerializedName("current_page")
//        val current_page: Int,
//        @Expose
//        @SerializedName("data")
//        var data: MutableList<AnnouncementDetail>,
//        @Expose
//        @SerializedName("first_page_url")
//        val first_page_url: String,
//        @Expose
//        @SerializedName("from")
//        val from: Int,
//        @Expose
//        @SerializedName("last_page")
//        val last_page: Int,
//        @Expose
//        @SerializedName("last_page_url")
//        val last_page_url: String,
//        @Expose
//        @SerializedName("next_page_url")
//        val next_page_url: String?,
//        @Expose
//        @SerializedName("path")
//        val path: String,
//        @Expose
//        @SerializedName("per_page")
//        val per_page: Int,
//        @Expose
//        @SerializedName("prev_page_url")
//        val prev_page_url: String,
//        @Expose
//        @SerializedName("to")
//        val to: Int,
//        @Expose
//        @SerializedName("total")
//        val total: Int
//    )
//
//    data class AnnouncementDetail(
//        @Expose
//        @SerializedName("id")
//        val id: Int,
//        @Expose
//        @SerializedName("title")
//        val title: String,
//        @Expose
//        @SerializedName("content")
//        val content: String,
//        @Expose
//        @SerializedName("cover_image_name")
//        val cover_image_name: String?,
//        @Expose
//        @SerializedName("created_at")
//        val created_at: String,
//        @Expose
//        @SerializedName("updated_at")
//        val updated_at: String?,
//        @Expose
//        @SerializedName("cover_image_url")
//        val cover_image_url: String
//    )
//    data class responseTags(
//        @Expose
//        @SerializedName("list")
//        val list: MutableList<Tags>
//    )
//    data class Tags(
//        @Expose
//        @SerializedName("id")
//        val id: Int,
//        @Expose
//        @SerializedName("name")
//        val name: String,
//
//        var selected: Boolean=false
//    )
//    data class responseAddress(
//        @Expose
//        @SerializedName("results")
//        val results: ArrayList<FullAddress>
//    )
//    data class address_components_element(
//        @Expose
//        @SerializedName("long_name")
//        val long_name: String,
//        @Expose
//        @SerializedName("short_name")
//        val short_name: String,
//        @Expose
//        @SerializedName("types")
//        val types: MutableList<String>
//    )
//    data class FullAddress(
//        @Expose
//        @SerializedName("formatted_address")
//        val formatted_address: String,
//        @Expose
//        @SerializedName("geometry")
//        val geometry: GoogleLocation,
//        @Expose
//        @SerializedName("address_components")
//        val address_components: MutableList<address_components_element>
//    )
//    data class GoogleLocation(
//        @Expose
//        @SerializedName("location")
//        val location: GoogleLocationDetail
//    )
//    data class GoogleLocationDetail(
//        @Expose
//        @SerializedName("lat")
//        val lat: String,
//        @Expose
//        @SerializedName("lng")
//        val lng:String
//    )
//    data class ResponseDistance(
//        @Expose
//        @SerializedName("destination_addresses")
//        val destination_addresses:  ArrayList<String>,
//        @Expose
//        @SerializedName("origin_addresses")
//        val origin_addresses:  ArrayList<String>,
//        @Expose
//        @SerializedName("rows")
//        val rows: ArrayList<Elements>
//    )
//    data class Elements(
//        @Expose
//        @SerializedName("elements")
//        val elements: ArrayList<DistanceInfo>
//    )
//    data class DistanceInfo(
//        @Expose
//        @SerializedName("distance")
//        val distance: DistanceDetail,
//        val duration: DurationDetail
//    )
//    data class DistanceDetail(
//        @Expose
//        @SerializedName("text")
//        val text: String,
//        @Expose
//        @SerializedName("value")
//        val value: String
//    )
//    data class DurationDetail(
//        @Expose
//        @SerializedName("duration")
//        val text: String,
//        @Expose
//        @SerializedName("value")
//        val value: String
//    )
//    data class ResponseCreateOrders(
//        @Expose
//        @SerializedName("current_page")
//        val current_page: Int,
//        @Expose
//        @SerializedName("data")
//        var data: MutableList<AnnouncementDetail>,
//        @Expose
//        @SerializedName("first_page_url")
//        val first_page_url: String,
//        @Expose
//        @SerializedName("from")
//        val from: Int,
//        @Expose
//        @SerializedName("last_page")
//        val last_page: Int,
//        @Expose
//        @SerializedName("last_page_url")
//        val last_page_url: String,
//        @Expose
//        @SerializedName("next_page_url")
//        val next_page_url: String,
//        @Expose
//        @SerializedName("path")
//        val path: String,
//        @Expose
//        @SerializedName("per_page")
//        val per_page: Int,
//        @Expose
//        @SerializedName("prev_page_url")
//        val prev_page_url: String,
//        @Expose
//        @SerializedName("to")
//        val to: Int,
//        @Expose
//        @SerializedName("total")
//        val total: Int
//    )
//
//    data class ResponseOrders(
//        @Expose
//        @SerializedName("current_page")
//        val current_page: Int,
//        @Expose
//        @SerializedName("data")
//        var data: MutableList<ResponseOrderDetail>,
//        @Expose
//        @SerializedName("first_page_url")
//        val first_page_url: String,
//        @Expose
//        @SerializedName("from")
//        val from: Int,
//        @Expose
//        @SerializedName("last_page")
//        val last_page: Int,
//        @Expose
//        @SerializedName("last_page_url")
//        val last_page_url: String,
//        @Expose
//        @SerializedName("next_page_url")
//        val next_page_url: String,
//        @Expose
//        @SerializedName("path")
//        val path: String,
//        @Expose
//        @SerializedName("per_page")
//        val per_page: Int,
//        @Expose
//        @SerializedName("prev_page_url")
//        val prev_page_url: String,
//        @Expose
//        @SerializedName("to")
//        val to: Int,
//        @Expose
//        @SerializedName("total")
//        val total: Int
//    )
//
//    data class ResponseOrderDetail(
//        @Expose
//        @SerializedName("id")
//        val id: Int,
//        @Expose
//        @SerializedName("status")
//        var status: Int,
//        @Expose
//        @SerializedName("from_address")
//        val from_address: String,
//        @Expose
//        @SerializedName("from_lat")
//        val from_lat: Float,
//        @Expose
//        @SerializedName("from_lng")
//        val from_lng: Float,
//        @Expose
//        @SerializedName("to_address")
//        val to_address: String,
//        @Expose
//        @SerializedName("to_lat")
//        val to_lat: Float,
//        @Expose
//        @SerializedName("to_lng")
//        val to_lng: Float,
//        @Expose
//        @SerializedName("est_distance")
//        val est_distance: Float,
//        @Expose
//        @SerializedName("est_fee_low")
//        val est_fee_low: Int,
//        @Expose
//        @SerializedName("fee")
//        val fee: Int?,
//        @Expose
//        @SerializedName("arrived_at")
//        val arrived_at: String?,
//        @Expose
//        @SerializedName("picked_up_at")
//        val picked_up_at:  String?,
//        @Expose
//        @SerializedName("remark")
//        val remark:  String?,
//        @Expose
//        @SerializedName("created_at")
//        val created_at: String,
//        @Expose
//        @SerializedName("updated_at")
//        val updated_at: String,
//        @Expose
//        @SerializedName("driver_origin_lat")
//        val driver_origin_lat: String?,
//        @Expose
//        @SerializedName("driver_origin_lng")
//        val driver_origin_lng: String?,
//        @Expose
//        @SerializedName("est_fee_high")
//        val est_fee_high: String,
//        @Expose
//        @SerializedName("confirmed_at")
//        val confirmed_at: String?,
//        @Expose
//        @SerializedName("number")
//        val number: String,
//        @Expose
//        @SerializedName("waiting_at")
//        val waiting_at: String?,
//        @Expose
//        @SerializedName("payment")
//        val payment: ResponsePayment?,
//        @Expose
//        @SerializedName("feedback")
//        val feedback: ResponseFeedback?,
//        @Expose
//        @SerializedName("driver")
//        val driver:ResponseDriver,
//        @Expose
//        @SerializedName("passenger")
//        val passenger: ResponsePassenger
//    )
//    data class ResponsePayment(
//        @Expose
//        @SerializedName("id")
//        val id: Int,
//        @Expose
//        @SerializedName("order_id")
//        val order_id: Int,
//        @Expose
//        @SerializedName("status")
//        val status: Int,
//        @Expose
//        @SerializedName("channel")
//        val channel: String,
//        @Expose
//        @SerializedName("method")
//        val method: Int,
//        @Expose
//        @SerializedName("response")
//        val response: String?,
//        @Expose
//        @SerializedName("confirmed_at")
//        val confirmed_at: String?,
//        @Expose
//        @SerializedName("created_at")
//        val created_at: String?,
//        @Expose
//        @SerializedName("updated_at")
//        val updated_at: String?
//    )
//    data class ResponseFeedback(
//        @Expose
//        @SerializedName("id")
//        val id: Int,
//        @Expose
//        @SerializedName("created_at")
//        val created_at: String,
//        @Expose
//        @SerializedName("driver_message")
//        val driver_message: String?,
//        @Expose
//        @SerializedName("driver_score")
//        val driver_score: Float?,
//        @Expose
//        @SerializedName("passenger_message")
//        val passenger_message: String?,
//        @Expose
//        @SerializedName("passenger_score")
//        val passenger_score: Float?
//    )
//    data class ResponseDriver(
//        @Expose
//        @SerializedName("id")
//        val id: Int,
//        @Expose
//        @SerializedName("account")
//        val account: String,
//        @Expose
//        @SerializedName("created_at")
//        val created_at: String,
//        @Expose
//        @SerializedName("updated_at")
//        val updated_at: String,
//        @Expose
//        @SerializedName("status")
//        val status: Int,
//        @Expose
//        @SerializedName("profile")
//        val profile: ResponseDriverProfile,
//        @Expose
//        @SerializedName("car")
//        val car: ResponseDriverCar,
//        @Expose
//        @SerializedName("tags")
//        val tags: MutableList<Tags>
//        )
//    data class ResponseDriverProfile(
//        @Expose
//        @SerializedName("id")
//        val id: Int,
//        @Expose
//        @SerializedName("user_id")
//        val user_id: Int,
//        @Expose
//        @SerializedName("account")
//        val account: String,
//        @Expose
//        @SerializedName("name")
//        val name: String,
//        @Expose
//        @SerializedName("number")
//        val number: String,
//        @Expose
//        @SerializedName("email")
//        val email: String,
//        @Expose
//        @SerializedName("id_card")
//        val id_card: String,
//        @Expose
//        @SerializedName("address")
//        val address: String,
//        @Expose
//        @SerializedName("birthday")
//        val birthday: String,
//        @Expose
//        @SerializedName("avatar_image_name")
//        val avatar_image_name: String,
//        @Expose
//        @SerializedName("score")
//        val score: Float,
//        @Expose
//        @SerializedName("lat")
//        val lat: String,
//        @Expose
//        @SerializedName("lng")
//        val lng: String,
//        @Expose
//        @SerializedName("geo_hash")
//        val geo_hash: String,
//        @Expose
//        @SerializedName("line_id")
//        val line_id: String,
//        @Expose
//        @SerializedName("business_id")
//        val business_id: String,
//        @Expose
//        @SerializedName("description")
//        val description: String,
//        @Expose
//        @SerializedName("created_at")
//        val created_at: String,
//        @Expose
//        @SerializedName("updated_at")
//        val updated_at: String,
//        @Expose
//        @SerializedName("avatar_image_url")
//        val avatar_image_url: String
//
//    )
//    data class ResponseDriverCar(
//        @Expose
//        @SerializedName("id")
//        val id: Int,
//        @Expose
//        @SerializedName("user_id")
//        val user_id: Int,
//        @Expose
//        @SerializedName("licence_number")
//        val licence_number: String?,
//        @Expose
//        @SerializedName("manufacturer")
//        val manufacturer: String?,
//        @Expose
//        @SerializedName("model")
//        val model: String?,
//        @Expose
//        @SerializedName("year")
//        val year: Int,
//        @Expose
//        @SerializedName("seats")
//        val seats: Int,
//        @Expose
//        @SerializedName("style")
//        val style: String?,
//        @Expose
//        @SerializedName("engine_displacement")
//        val engine_displacement: Int,
//        @Expose
//        @SerializedName("checked_1_at")
//        val checked_1_at: String?,
//        @Expose
//        @SerializedName("checked_2_at")
//        val checked_2_at: String?,
//        @Expose
//        @SerializedName("created_at")
//        val created_at: String?,
//        @Expose
//        @SerializedName("updated_at")
//        val updated_at: String?,
//        @Expose
//        @SerializedName("image_name")
//        val image_name: String?,
//        @Expose
//        @SerializedName("type")
//        val type: Int,
//        @Expose
//        @SerializedName("image_url")
//        val image_url: String?
//
//    )
//    data class ResponsePassenger(
//        @Expose
//        @SerializedName("id")
//        val id: Int,
//        @Expose
//        @SerializedName("account")
//        val account: String,
//        @Expose
//        @SerializedName("created_at")
//        val created_at: String,
//        @Expose
//        @SerializedName("updated_at")
//        val updated_at: String,
//        @Expose
//        @SerializedName("status")
//        val status: Int
//    )
//    data class ResponseRequestPayment(
//        @Expose
//        @SerializedName("action")
//        val action: String?,
//        @Expose
//        @SerializedName("method")
//        val method: String?,
//        @Expose
//        @SerializedName("parameters")
//        var parameters: ResponseParameters
//
//    )
//    data class ResponseParameters(
//        @Expose
//        @SerializedName("MerchantID")
//        val MerchantID: String?,
//        @Expose
//        @SerializedName("MerchantTradeNo")
//        val MerchantTradeNo: String?,
//        @Expose
//        @SerializedName("MerchantTradeDate")
//        val MerchantTradeDate: String?,
//        @Expose
//        @SerializedName("PaymentType")
//        val PaymentType: String?,
//        @Expose
//        @SerializedName("TotalAmount")
//        val TotalAmount: String?,
//        @Expose
//        @SerializedName("TradeDesc")
//        val TradeDesc: String?,
//        @Expose
//        @SerializedName("ItemName")
//        val ItemName: String?,
//        @Expose
//        @SerializedName("ReturnURL")
//        val ReturnURL: String?,
//        @Expose
//        @SerializedName("ChoosePayment")
//        val ChoosePayment: String?,
//        @Expose
//        @SerializedName("ClientBackURL")
//        val ClientBackURL: String?,
//        @Expose
//        @SerializedName("CheckMacValue")
//        val CheckMacValue: String?
//    )
//    data class ResponseGetNearByTaxi(
//        @Expose
//        @SerializedName("drivers")
//        var drivers: MutableList<DriverLatlng>
//    )
//    data class DriverLatlng(
//        @Expose
//        @SerializedName("lat")
//        var lat:String,
//        @Expose
//        @SerializedName("lng")
//        var lng: String
//    )
//    data class ResponseGetCurrentState(
//        @Expose
//        @SerializedName("id")
//        val id: Int,
//        @Expose
//        @SerializedName("account")
//        val account: String,
//        @Expose
//        @SerializedName("created_at")
//        val created_at: String,
//        @Expose
//        @SerializedName("updated_at")
//        val updated_at: String,
//        @Expose
//        @SerializedName("status")
//        val status: Int,
//        @Expose
//        @SerializedName("order")
//        val order: ResponseOrderDetail?,
//        @Expose
//        @SerializedName("addresses")
//        val addresses: MutableList<Address>,
//        @Expose
//        @SerializedName("announcement")
//        val announcement: AnnouncementDetail
//    )
//    data class ResponseGetEstimateTaxiFee(
//        @Expose
//        @SerializedName("time")
//        val time: String,
//        @Expose
//        @SerializedName("distance")
//        val distance: String,
//        @Expose
//        @SerializedName("est_fee_low")
//        val est_fee_low: Int,
//        @Expose
//        @SerializedName("est_fee_high")
//        val est_fee_high: Int
//    )
//    data class ResponseGetPaymentPage(
//        @Expose
//        @SerializedName("time")
//        val time: String
//    )
//    data class ResponsePaymentMenGoCard(
//        @Expose
//        @SerializedName("payment_id")
//        val payment_id: Int,
//        @Expose
//        @SerializedName("order_id")
//        val order_id: Int,
//        @Expose
//        @SerializedName("fee")
//        val fee: Int,
//        @Expose
//        @SerializedName("balance")
//        val balance: Balance
//    )
//    data class Balance(
//        @Expose
//        @SerializedName("is_success")
//        val is_success: Boolean,
//        @Expose
//        @SerializedName("points")
//        val points: Int
//    )
//    data class ResponseMenGoCard(
//        @Expose
//        @SerializedName("cards")
//        val cards: MutableList<ResponseMenGoCardDetail>
//    )
//    data class ResponseMenGoCardDetail(
//        @Expose
//        @SerializedName("id")
//        val id: Int,
//        @Expose
//        @SerializedName("type")
//        val type: String,
//        @Expose
//        @SerializedName("number")
//        var number: String,
//        @Expose
//        @SerializedName("balance")
//        val balance: Int
//    )
//    data class ResponseCreateMenGoCard(
//        @Expose
//        @SerializedName("is_success")
//        val is_success: Boolean,
//        @Expose
//        @SerializedName("error_message")
//        val error_message: String?
//    )
//    //==request
//    data class getProfileBody(
//        val token: String,
//        val id: Int
//    )
//
//
//
//    data class smsBody(
//        val mobile: String,
//        val purpose: Int
//    )
//
//    data class resetPasswordBody(
//        val account: String,
//        val new_password: String,
//        val verify_code: String,
//        val role: Int
//    )
//
//    data class signUpBody(
//        val account: String,
//        val password: String,
//        val verify_code: String,
//        val role: Int,
//        val gender: Int,
//        val first_name: String,
//        val last_name: String
//    )
//
//    data class updateProfileBody(
//        val gender: Int,
//        val first_name: String,
//        val last_name: String,
//        val email: String,
//        val avatar_image_name: String,
//        val address_list: MutableList<Address>
//    )
//    data class getTagsBody(
//        val token: String
//    )
//    data class getGetAddressBody(
////        val location: String
//         var latlng:String
//    )
//    data class getGetLatlngBody(
//        val location: String
//    )
//    data class getDistanceBody(
//        var fromLatlng:String,
//        var toLatlng:String
//    )
//    data class GetCurrentStateBody(
//        val token: String
//    )
//
//    data class CreateOrderBody(
//        val token: String,
//        val from_address: String,
//        val from_lat: Float,
//        val from_lng: Float,
//        val to_address: String,
//        val to_lat: Float,
//        val to_lng: Float,
//        val est_distance: Float,
//        val remark: String,
//        val car_type: Int,
//        val tags: MutableList<Int>
//    )
//    data class GetOrdersBody(
//        val token: String
//    )
//    data class GetOrdersPageBody(
//        val token: String,
//        val page:Int
//    )
//    data class GetOrderDetailBody(
//        val token: String,
//        val id: Int
//    )
//    data class CancelOrderBody(
//        val token: String,
//        val id: Int,
//        val message: String
//    )
//    data class RequestPaymentBody(
//        val token: String,
//        val order_id: Int,
//        val channel: String,
//        val method: Int
//    )
//    data class CreateOrderFeedbackBody(
//        val token: String,
//        val order_id: Int,
//        val score: Int,
//        val message :String
//    )
//    data class GetNearByTaxiBody(
//        val token: String,
//        val lat: String,
//        val lng: String
//    )
//    data class GetEstimateTaxiFeeBody(
//        val token: String,
//        val distance: String
//    )
//
//    data class LogoutBody(
//        val token: String
//    )
//    //==ecpay
//    data class GetPaymentPageBody(
//        val MerchantID: String,
//        val MerchantTradeNo: String,
//        val MerchantTradeDate: String,
//        val PaymentType: String,
//        val TotalAmount: String,
//        val TradeDesc: String,
//        val ItemName: String,
//        val ReturnURL: String,
//        val ChoosePayment: String,
//        val ClientBackURL: String,
//        val CheckMacValue: String
//    )
//    data class GetMenGoCardBody(
//        val token: String
//    )
//    data class RequestPaymentMenGoCardBody(
//        val token: String,
//        val orderId:Int
//    )
//    data class DeleteMenGoCardBody(
//        val token: String,
//        val id: Int
//    )
//    data class CreateMenGoCardBody(
//        val token: String,
//        val id_card_number: String,
//        val card_number: String
//    )
//    data class PayByMenGoCardBody(
//        val token: String,
//        val paymentId: Int
//    )
}