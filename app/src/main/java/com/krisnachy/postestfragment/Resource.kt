package com.krisnachy.postestfragment

interface Resource {
    companion object {
        val tabList = arrayOf(
            R.string.chat, R.string.status, R.string.call
        )

        val pagerFragments = arrayOf(
            ChatFragment.create(), StatusFragment.create(), CallFragment.create()
        )
    }
}