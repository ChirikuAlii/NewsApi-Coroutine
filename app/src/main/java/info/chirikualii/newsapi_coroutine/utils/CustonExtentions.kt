package info.chirikualii.newsapi_coroutine.utils

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by chirikuAlii on 26/06/2020.
 * github.com/chirikualii
 */

fun Long.timeMillisToDateTime(format: String?=null):String{
    try {
        var format = format
        if (format == null){
            format = "MM/dd/yy, hh:mm:ss aa"
        }

        val sdf = SimpleDateFormat(format)
        return sdf.format(Date(this))
    }catch (e:Throwable){
        Log.e("Utils","error parse ${e.message}")
    }
    return this.toString()
}



