package com.gads.crowdfunding.presentation

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.RelativeLayout
import com.gads.crowdfunding.R

class Loader(context: Context) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loader_ui)

        window?.setLayout(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT
        )

        window?.setBackgroundDrawableResource(android.R.color.transparent)
    }
}