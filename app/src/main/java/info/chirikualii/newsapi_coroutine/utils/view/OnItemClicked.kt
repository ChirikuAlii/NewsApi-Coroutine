package info.chirikualii.newsapi_coroutine.utils.view

import info.chirikualii.newsapi_coroutine.data.local.ArticleEnitity
import info.chirikualii.newsapi_coroutine.data.remote.response.Article


/**
 * Created by chirikuAlii on 26/06/2020.
 * github.com/chirikualii
 */

interface OnItemClicked {

    fun onArticleClicked(article: ArticleEnitity){}
}