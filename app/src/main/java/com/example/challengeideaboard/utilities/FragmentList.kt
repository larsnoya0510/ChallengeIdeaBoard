package com.example.challengeideaboard.utilities

import com.example.challengeideaboard.IdeaBoardFragment
import com.example.challengeideaboard.LoginFragment
import com.example.challengeideaboard.ReplyFirstFragment
import com.example.challengeideaboard.ReplySecondFragment


class MainFragmentList {
    val mIdeaBoardFragment :IdeaBoardFragment by lazy { IdeaBoardFragment.newInstance()}
    val mLoginFragment :LoginFragment by lazy { LoginFragment.newInstance() }
    val mReplyFirstFragment :ReplyFirstFragment by lazy { ReplyFirstFragment.newInstance() }
    val mReplySecondFragment :ReplySecondFragment by lazy { ReplySecondFragment.newInstance() }
}




