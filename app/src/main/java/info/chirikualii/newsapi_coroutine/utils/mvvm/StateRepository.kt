package info.chirikualii.newsapi_coroutine.utils.mvvm

import info.chirikualii.newsapi_coroutine.utils.ApiException
import retrofit2.Response
import java.lang.StringBuilder


/**
 * Created by chirikuAlii on 30/06/2020.
 * github.com/chirikualii
 */

abstract class StateRepository {

    suspend fun <T : Any> safeApiRequest(call: suspend () -> Response<T>): T {
        val response = call.invoke()

        if (response.isSuccessful) {
            return response.body()!!
        } else {
            val message = StringBuilder()
            message.append("Problem in API \n Error code: ${response.code()}")
            throw ApiException(
                message.toString()
            )
        }
    }
}

