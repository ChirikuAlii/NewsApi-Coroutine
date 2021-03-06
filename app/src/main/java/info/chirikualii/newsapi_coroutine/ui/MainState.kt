package info.chirikualii.newsapi_coroutine.ui

import info.chirikualii.newsapi_coroutine.data.local.ArticleEnitity
import info.chirikualii.newsapi_coroutine.data.remote.response.Article


/**
 * Created by chirikuAlii on 25/06/2020.
 * github.com/chirikualii
 */

sealed class MainState {

    data class OnShowHeadline(val listData :List<ArticleEnitity>) : MainState()
    data class OnLoading(var isLoading : Boolean = false) : MainState()
}