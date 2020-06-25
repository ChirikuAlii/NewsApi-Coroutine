package info.chirikualii.newsapi_coroutine.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.google.gson.Gson
import info.chirikualii.newsapi_coroutine.R
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() , Observer<MainState> {

    val mViewModel : MainViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mViewModel.state.observe(this,this)
        mViewModel.doLoadHeadline()
        setupView()
    }

    private fun setupView() {

    }

    override fun onChanged(state: MainState?) {

        when (state) {

            is MainState.OnShowHeadline -> {
                Log.d(MainActivity::class.java.simpleName,"load article ${Gson().toJsonTree(state.listData)}")
            }

        }
    }
}
