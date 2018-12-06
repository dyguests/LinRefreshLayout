package com.fanhl.linrefreshlayout.sample

import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fanhl.linrefreshlayout.DrawstringRefreshLayout
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_drawstring.*

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
                viewModel.refreshData()
            }
        })

        viewModel.apply {
            data.observe(this@DrawstringActivity, Observer {
                adapter.setNewData(it)
            })
        }
    }

    private fun initData() {
        recycler_view.adapter = adapter
    }

    private fun refreshData() {
//        viewModel.refreshData()
    }

    class ViewModel(application: Application) : AndroidViewModel(application) {
        val data by lazy { MutableLiveData<List<Int>>() }

        fun refreshData() {
            val subscribe = Flowable
                .create<List<Int>>({
                    Thread.sleep(2000)
                    it.onNext(List(20) { it })
                }, BackpressureStrategy.LATEST)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    data.value = it
                }
        }
    }
}
