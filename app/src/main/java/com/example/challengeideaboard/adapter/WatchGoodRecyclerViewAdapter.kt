package com.example.challengeideaboard.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeideaboard.R
import com.example.challengeideaboard.api_network.DataModel

class WatchGoodRecyclerViewAdapter(
    private val context: Context,
    private val mOutList: MutableList<DataModel.WhoGoodItem>?
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var mInList: MutableList<DataModel.WhoGoodItem>
    val inflater: LayoutInflater = LayoutInflater.from(context)
    var mOnItemCheckListener: OnItemCheckListener? = null

    init {
        mInList = mOutList ?: mutableListOf<DataModel.WhoGoodItem>()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view: View
        view = inflater.inflate(R.layout.viewholder_watchgood_recyclerview_item, parent, false)
        return editorRecommandViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mInList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is editorRecommandViewHolder) holder.bind(position)
    }

    inner class editorRecommandViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var watchGoodUserTextView = view.findViewById<TextView>(R.id.watchGoodUserTextView)

        fun bind(position: Int) {
            watchGoodUserTextView.text=mInList[position].user_name
        }
    }
    fun updateData(mList: MutableList<DataModel.WhoGoodItem>?) {
        mInList = mList ?:  mutableListOf<DataModel.WhoGoodItem>()
        notifyDataSetChanged()
    }

    interface OnItemCheckListener {
//        fun onCLickGood(mBoardId: Int,mUserName :String)
//        fun onClickReply(mBoardId: Int,mUserName :String,mMsg: String)
//        fun onOpenReply(mData: DataModel.BoardItem)
    }

    fun setOnItemCheckListener(mOnItemCheckListener: OnItemCheckListener) {
//        this.mOnItemCheckListener = mOnItemCheckListener
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}