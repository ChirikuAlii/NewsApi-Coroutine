package info.chirikualii.newsapi_coroutine.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import info.chirikualii.newsapi_coroutine.R
import info.chirikualii.newsapi_coroutine.data.remote.response.Article
import info.chirikualii.newsapi_coroutine.ui.detailHeadline.DetailHeadlineActivity
import info.chirikualii.newsapi_coroutine.utils.view.OnItemClicked
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() , Observer<MainState> ,OnItemClicked {

    val mViewModel : MainViewModel by inject()

    lateinit var headlineListAdapter: HeadlineListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mViewModel.state.observe(this,this)
        mViewModel.doLoadHeadline()
        setupView()
    }

    private fun setupView() {
        headlineListAdapter = HeadlineListAdapter(this)

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = headlineListAdapter


    }

    override fun onChanged(state: MainState?) {

        when (state) {

            is MainState.OnShowHeadline -> {
                val arraylist = arrayListOf<Article>()
                arraylist.addAll(state.listData)
                headlineListAdapter.addList(arraylist)
                Log.d(MainActivity::class.java.simpleName,"load article ${Gson().toJsonTree(state.listData)}")
            }

        }
    }

    override fun onArticleClicked(article: Article) {
        super.onArticleClicked(article)

        val articleJson = Gson().toJson(article)

        val intent = Intent(this,DetailHeadlineActivity::class.java)
        intent.putExtra("ARTICLE",articleJson)

        startActivity(intent)
    }
}
