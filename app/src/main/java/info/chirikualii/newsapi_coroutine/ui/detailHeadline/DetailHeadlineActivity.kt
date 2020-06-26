package info.chirikualii.newsapi_coroutine.ui.detailHeadline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.google.gson.Gson
import info.chirikualii.newsapi_coroutine.R
import info.chirikualii.newsapi_coroutine.data.remote.response.Article
import kotlinx.android.synthetic.main.activity_detail_headline.*
import kotlinx.android.synthetic.main.item_article.*
import kotlinx.android.synthetic.main.item_article.iv_article

class DetailHeadlineActivity : AppCompatActivity() {

    lateinit var article: Article
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_headline)

        val jsonString = intent.getStringExtra("ARTICLE")

        article = Gson().fromJson(jsonString,Article::class.java)

        setupView()
    }

    private fun setupView() {

        Glide.with(this)
            .load(article.urlToImage)
            .into(iv_article)

        tv_title.text = article.title
        tv_desc.text = article.content
    }
}
