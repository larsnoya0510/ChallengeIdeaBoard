package com.example.challengeideaboard

import android.content.Context
import android.graphics.Color
import android.text.Spannable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeideaboard.api_network.DataModel
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import androidx.recyclerview.widget.LinearLayoutManager


class ReplyFirstRecyclerViewAdapter(
    private val context: Context,
    private val mOutList: MutableList<DataModel.MsgsItem>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var mInList: MutableList<DataModel.MsgsItem>
    val inflater: LayoutInflater = LayoutInflater.from(context)
    var mOnItemCheckListener: OnItemCheckListener? = null

    init {
        mInList = mOutList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view: View
        view = inflater.inflate(R.layout.viewholder_first_reply_recyclerview_item, parent, false)
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
        var secondReplyRecyclerView = view.findViewById<RecyclerView>(R.id.secondReplyRecyclerView)
//        var pushGoodConstraintLayout = view.findViewById<ConstraintLayout>(R.id.pushGoodConstraintLayout)
//        var pushMsgConstraintLayout = view.findViewById<ConstraintLayout>(R.id.pushMsgConstraintLayout)
//        var msgTagTextView = view.findViewById<TextView>(R.id.msgTagTextView)

        fun bind(position: Int) {
            var nameLength=mInList[position].msg_user.length
            val spannable = SpannableStringBuilder("${mInList[position].msg_user}${mInList[position].msg}")
            spannable.setSpan(ForegroundColorSpan(Color.BLUE),0,nameLength, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            replyTextView.setText(spannable)
            createTimeTextView.text=mInList[position].create_time
            secondReplyRecyclerView.layoutManager= LinearLayoutManager(context)
            secondReplyRecyclerView.adapter=ReplySecondRecyclerViewAdapter(context,mInList[position].remsgs)
//            cardViewLinearLayout.setOnClickListener {
//                mOnItemCheckListener!!.onCheck(mInList[position].book_id)
//            }
//            worksDateTextView.text = mInList[position].updated_at
        }
    }
    fun updateData(mList: MutableList<DataModel.MsgsItem>) {
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