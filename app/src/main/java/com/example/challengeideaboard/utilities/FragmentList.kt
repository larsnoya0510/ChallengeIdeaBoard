package com.example.challengeideaboard.utilities

import com.example.challengeideaboard.IdeaBoardFragment
import com.example.challengeideaboard.LoginFragment


class MainFragmentList {
    val mIdeaBoardFragment :IdeaBoardFragment by lazy { IdeaBoardFragment.newInstance()}
    val mLoginFragment :LoginFragment by lazy { LoginFragment.newInstance() }

}




