package com.example.challengeideaboard

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeideaboard.api_network.DataModel
import com.example.challengeideaboard.api_network.SharePreferenceUtil
import com.google.gson.Gson

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
        var pushReplyConstraintLayout = view.findViewById<ConstraintLayout>(R.id.pushReplyConstraintLayout)
        var viewGoodConstraintLayout = view.findViewById<ConstraintLayout>(R.id.viewGoodConstraintLayout)

        fun bind(position: Int) {
            authorTextView.text=mInList[position].author
            createTimeTextView.text=mInList[position].create_time
            contentTextView.text=mInList[position].content
            goodsCountTextView.text=mInList[position].goods_count.toString()
            msgsCountTextView.text="${mInList[position].msgs_count.toString()}則留言"
            authorTextView.text=mInList[position].author
            replyFirstRecyclerView.layoutManager=LinearLayoutManager(context)
            var adapter=ReplyFirstRecyclerViewAdapter(context,mInList[position].msgs)
            adapter.setOnItemCheckListener(object:ReplyFirstRecyclerViewAdapter.OnItemCheckListener{
                override fun OnOpenReplySecond(mData: DataModel.MsgsItem) {
                    if(SharePreferenceUtil.getUserToken(context!!).isNullOrEmpty()){
                        Toast.makeText(context,"請先登入", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        var mBundle = Bundle()
                        mBundle.putSerializable("MsgData", Gson().toJson(mData))
                        (context as MainActivity).mFragmentList.mReplySecondFragment.arguments = mBundle
                        var action = (context as MainActivity).supportFragmentManager!!.beginTransaction()
                        action.replace(
                            R.id.fragmentContainer,
                            (context as MainActivity).mFragmentList.mReplySecondFragment
                        )
                        action.addToBackStack(null)
                        action.commit()
                    }
                }

            })
            replyFirstRecyclerView.adapter=adapter

            pushGoodConstraintLayout.setOnClickListener {
                mOnItemCheckListener!!.onCLickGood(mInList[position].id, SharePreferenceUtil.getUser(context))
            }
            pushReplyConstraintLayout.setOnClickListener {
                mOnItemCheckListener!!.onOpenReply(mInList[position])
            }
            viewGoodConstraintLayout.setOnClickListener {
                mOnItemCheckListener!!.onOpenGoodView(mInList[position].id)
            }
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
        fun onClickReply(mBoardId: Int,mUserName :String,mMsg: String)
        fun onOpenReply(mData:DataModel.BoardItem)
        fun onOpenGoodView(mBoardId: Int)
    }

    fun setOnItemCheckListener(mOnItemCheckListener: OnItemCheckListener) {
        this.mOnItemCheckListener = mOnItemCheckListener
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}