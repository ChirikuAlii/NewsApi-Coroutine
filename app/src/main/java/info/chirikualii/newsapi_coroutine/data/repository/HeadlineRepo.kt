package info.chirikualii.newsapi_coroutine.data.repository

import android.util.Log
import info.chirikualii.newsapi_coroutine.data.local.ArticleDao
import info.chirikualii.newsapi_coroutine.data.local.ArticleEnitity
import info.chirikualii.newsapi_coroutine.data.remote.ApiService
import info.chirikualii.newsapi_coroutine.data.remote.response.HeadlineResponse
import info.chirikualii.newsapi_coroutine.utils.mvvm.StateRepository


/**
 * Created by chirikuAlii on 25/06/2020.
 * github.com/chirikualii
 */
class HeadlineRepo(val service: ApiService,val articleDao: ArticleDao) :
    StateRepository() {

    suspend fun getHeadlineNewsRemote() : HeadlineResponse{
        Log.d(HeadlineRepo::class.java.simpleName,"get remote")

      return safeApiRequest {
           val result = service.getHeadlineNews()
            result.body()?.articles
            ?.map {
                ArticleEnitity(
                    author = it.author,
                    content = it.content,
                    description = it.description,
                    publishedAt = it.publishedAt.toString(),
                    title = it.title,
                    url = it.url,
                    urlToImage = it.urlToImage
                )
            }
            ?.forEach { articleEntity -> articleDao.addArticle(articleEntity) }

            result
        }

    }

    suspend fun getHeadlineNewsLocal() :List<ArticleEnitity>{
        Log.d(HeadlineRepo::class.java.simpleName,"get local")
        return articleDao.getArticle()
    }
}