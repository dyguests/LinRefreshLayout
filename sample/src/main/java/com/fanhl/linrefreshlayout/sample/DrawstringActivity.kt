package com.fanhl.linrefreshlayout.sample

import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.fanhl.linrefreshlayout.DrawstringRefreshLayout
import kotlinx.android.synthetic.main.activity_drawstring.*
import kotlinx.coroutines.delay
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast

class DrawstringActivity : AppCompatActivity() {

    private val adapter = DefaultAdapter()

    private val viewModel by lazy { ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(ViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawstring)

        assignViews()
        initData()
        refreshData()
    }

    private fun assignViews() {
        refresh_layout.setOnRefreshListener(object : DrawstringRefreshLayout.OnRefreshListener {
            override fun onRefresh() {
                toast("onRefresh")
            }
        })
    }

    private fun initData() {
        recycler_view.adapter = adapter
    }

    private fun refreshData() {
        viewModel.refreshData()
    }

    class ViewModel(application: Application) : AndroidViewModel(application) {
        val data by lazy { MutableLiveData<List<Int>>() }

        fun refreshData() {
//            doAsync {
//                delay(2000)
//            }

//            delay(2000)
        }
    }
}
