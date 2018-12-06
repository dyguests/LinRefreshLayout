package com.fanhl.linrefreshlayout.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fanhl.linrefreshlayout.DrawstringRefreshLayout
import kotlinx.android.synthetic.main.activity_drawstring.*
import org.jetbrains.anko.toast

class DrawstringActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawstring)

        refresh_layout.setOnRefreshListener(object : DrawstringRefreshLayout.OnRefreshListener {
            override fun onRefresh() {
                toast("onRefresh")
            }
        })
    }
}
