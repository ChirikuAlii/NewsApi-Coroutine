package info.chirikualii.newsapi_coroutine.utils

import java.io.IOException


/**
 * Created by chirikuAlii on 30/06/2020.
 * github.com/chirikualii
 */

class ApiException (message: String): IOException(message)
class NoInternetException (message: String): IOException(message)