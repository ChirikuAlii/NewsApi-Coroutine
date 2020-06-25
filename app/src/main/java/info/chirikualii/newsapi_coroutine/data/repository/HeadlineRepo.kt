package info.chirikualii.newsapi_coroutine.data.repository

import info.chirikualii.newsapi_coroutine.data.remote.ApiService
import info.chirikualii.newsapi_coroutine.data.remote.response.HeadlineResponse


/**
 * Created by chirikuAlii on 25/06/2020.
 * github.com/chirikualii
 */
class HeadlineRepo(val service: ApiService) {

    suspend fun getHeadlineNews() : HeadlineResponse{
        return service.getHeadlineNews()
    }
}