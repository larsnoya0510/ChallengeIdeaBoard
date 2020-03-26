package com.example.challengeideaboard.utilities

import com.example.challengeideaboard.*


class MainFragmentList {
    val mIdeaBoardFragment :IdeaBoardFragment by lazy { IdeaBoardFragment.newInstance()}
    val mLoginFragment :LoginFragment by lazy { LoginFragment.newInstance() }
    val mReplyFirstFragment :ReplyFirstFragment by lazy { ReplyFirstFragment.newInstance() }
    val mReplySecondFragment :ReplySecondFragment by lazy { ReplySecondFragment.newInstance() }
    val mWatchGoodFragment :WatchGoodFragment by lazy { WatchGoodFragment.newInstance() }
}




