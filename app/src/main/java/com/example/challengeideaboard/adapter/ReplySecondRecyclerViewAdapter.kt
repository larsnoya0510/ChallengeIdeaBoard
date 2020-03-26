package com.example.challengeideaboard.adapter

import android.content.Context
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeideaboard.R
import com.example.challengeideaboard.api_network.DataModel
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class ReplySecondRecyclerViewAdapter(
    private val context: Context,
    private val mOutList: MutableList<DataModel.RemsgsItem>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var mInList: MutableList<DataModel.RemsgsItem>
    val inflater: LayoutInflater = LayoutInflater.from(context)
    var mOnItemCheckListener: OnItemCheckListener? = null

    init {
        mInList = mOutList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view: View
        view = inflater.inflate(R.layout.viewholder_second_reply_recyclerview_item, parent, false)
        return editorRecommandViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mInList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is editorRecommandViewHolder) holder.bind(position)
    }

    inner class editorRecommandViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var replyTextView = view.findViewById<TextView>(R.id.replyTextView)
        var createTimeTextView = view.findViewById<TextView>(R.id.createTimeTextView)


        fun bind(position: Int) {
            var nameLength=mInList[position].remsg_user.length
            val spannable = SpannableStringBuilder("${mInList[position].remsg_user}  ${mInList[position].remsg}")
            spannable.setSpan(ForegroundColorSpan(Color.BLUE),0,nameLength, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            replyTextView.setText(spannable)
//            createTimeTextView.text=mInList[position].create_time
            createTimeTextView.text=dateDiff( Date(System.currentTimeMillis()),stringTimetoData(mInList[position].create_time))
        }
    }
    fun stringTimetoData(mData: String): Date {
        //處理時間顯示
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        var date = format.parse(mData)
        return date
    }
    fun dateToString(date: Date) :String{
        val sdf = SimpleDateFormat("MM月dd號")
        val dateString = sdf.format(date)
        return dateString
    }
    fun dateDiff(NowTime: Date, PostTime: Date): String {
        var result=""
        val formatDate = SimpleDateFormat("yyyy-MM-dd　HH:mm:ss")
//        val sd = SimpleDateFormat(format)
        val nd = (1000 * 24 * 60 * 60).toLong()
        val nh = (1000 * 60 * 60).toLong()
        val nm = (1000 * 60).toLong()
        val ns: Long = 1000
        val diff: Long
        var day: Long = 0
        try {
            diff = NowTime.time - PostTime.time
            day = diff / nd
            val hour = diff % nd / nh//小時
            val min = diff % nd % nh / nm//分鍾
//            val sec = diff % nd % nh % nm / ns// 計算差多少秒
            // 輸出結果
            if (day >= 1) {
//                return day
                result= dateToString(PostTime)
            } else if(day==0L && hour>=1L) {
                result= "${hour}小時前"

            } else if(day==0L && hour<1L) {
                result= "${min}分鐘前"
            }
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        finally {
            return result
        }

    }
    fun updateData(mList: MutableList<DataModel.RemsgsItem>) {
        mInList = mList
        notifyDataSetChanged()
    }

    interface OnItemCheckListener {
//        fun onCheck(workId: Int)
//        fun onStarClick(workId: Int, mutableList: MutableList<DataModel.EditorRecommandItem>,collectionState:Int)

    }

    fun setOnItemCheckListener(mOnItemCheckListener: OnItemCheckListener) {
        this.mOnItemCheckListener = mOnItemCheckListener
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}