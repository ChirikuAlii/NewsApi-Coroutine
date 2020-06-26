package info.chirikualii.newsapi_coroutine.ui

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import info.chirikualii.newsapi_coroutine.data.repository.HeadlineRepo
import info.chirikualii.newsapi_coroutine.utils.mvvm.StateViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


/**
 * Created by chirikuAlii on 25/06/2020.
 * github.com/chirikualii
 */

class MainViewModel(private val repo : HeadlineRepo) : StateViewModel<MainState>(){


    fun doLoadHeadline(){
        viewModelScope.launch {

            try {
                val result = withContext(Dispatchers.IO){
                    repo.getHeadlineNews()
                }

                Log.d(TAG,"success load headline ${Gson().toJsonTree(result)}")
                state.value = result.articles?.let { MainState.OnShowHeadline(it) }

            }catch (e:Throwable){
                Log.e(TAG,"error load headline ${e.message}")
            }

        }
    }
}