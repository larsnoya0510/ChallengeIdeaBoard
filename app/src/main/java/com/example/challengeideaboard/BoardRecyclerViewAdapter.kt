package com.example.challengeideaboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeideaboard.api_network.DataModel
import com.example.challengeideaboard.api_network.SharePreferenceUtil

class BoardRecyclerViewAdapter(
    private val context: Context,
    private val mOutList: MutableList<DataModel.BoardItem>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var mInList: MutableList<DataModel.BoardItem>
    val inflater: LayoutInflater = LayoutInflater.from(context)
    var mOnItemCheckListener: OnItemCheckListener? = null

    init {
        mInList = mOutList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view: View
        view = inflater.inflate(R.layout.viewholder_board_recyclerview_item, parent, false)
        return editorRecommandViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mInList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is editorRecommandViewHolder) holder.bind(position)
    }

    inner class editorRecommandViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var authorTextView = view.findViewById<TextView>(R.id.authorTextView)
        var createTimeTextView = view.findViewById<TextView>(R.id.createTimeTextView)
        var contentTextView = view.findViewById<TextView>(R.id.contentTextView)
        var goodsCountTextView = view.findViewById<TextView>(R.id.goodsCountTextView)
        var msgsCountTextView = view.findViewById<TextView>(R.id.msgsCountTextView)

        var replyFirstRecyclerView = view.findViewById<RecyclerView>(R.id.replyFirstRecyclerView)
        var pushGoodConstraintLayout = view.findViewById<ConstraintLayout>(R.id.pushGoodConstraintLayout)
        var pushMsgConstraintLayout = view.findViewById<ConstraintLayout>(R.id.pushMsgConstraintLayout)
        var msgTagTextView = view.findViewById<TextView>(R.id.msgTagTextView)

        fun bind(position: Int) {
            authorTextView.text=mInList[position].author
            createTimeTextView.text=mInList[position].create_time
            contentTextView.text=mInList[position].content
            goodsCountTextView.text=mInList[position].goods_count.toString()
            msgsCountTextView.text="${mInList[position].msgs_count.toString()}"
            authorTextView.text=mInList[position].author
            replyFirstRecyclerView.layoutManager=LinearLayoutManager(context)
            replyFirstRecyclerView.adapter=ReplyFirstRecyclerViewAdapter(context,mInList[position].msgs)

            pushGoodConstraintLayout.setOnClickListener {
                mOnItemCheckListener!!.onCLickGood(mInList[position].id, SharePreferenceUtil.getUser(context))
            }
            pushMsgConstraintLayout.setOnClickListener {
                mOnItemCheckListener!!.onClickMsg(SharePreferenceUtil.getUser(context),msgTagTextView.text.toString())
            }
//            cardViewLinearLayout.setOnClickListener {
//                mOnItemCheckListener!!.onCheck(mInList[position].book_id)
//            }
//            worksDateTextView.text = mInList[position].updated_at
        }
    }
    fun updateData(mList: MutableList<DataModel.BoardItem>) {
        mInList = mList
        notifyDataSetChanged()
    }

    interface OnItemCheckListener {
//        fun onCheck(workId: Int)
//        fun onStarClick(workId: Int, mutableList: MutableList<DataModel.EditorRecommandItem>,collectionState:Int)
        fun onCLickGood(mBoardId: Int,mUserName :String)
        fun onClickMsg(mUserName :String,mContent: String)
    }

    fun setOnItemCheckListener(mOnItemCheckListener: OnItemCheckListener) {
        this.mOnItemCheckListener = mOnItemCheckListener
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}