package info.chirikualii.newsapi_coroutine.ui

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import info.chirikualii.newsapi_coroutine.data.repository.HeadlineRepo
import info.chirikualii.newsapi_coroutine.utils.ApiException
import info.chirikualii.newsapi_coroutine.utils.NoInternetException
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
        viewModelScope.launch(Dispatchers.IO) {

            try {
                Log.d(TAG,"do load headline")

                val result = repo.getHeadlineNewsRemote()
                    .let { repo.getHeadlineNewsLocal()  }

                state.postValue(MainState.OnShowHeadline(result))

                Log.d(TAG,"success load headline ${Gson().toJsonTree(result)}")

            }catch (e:Throwable){

                when(e){

                    is ApiException -> {
                        Log.e(TAG,"error load headline api exception ${e.message}")
                    }

                    is NoInternetException -> {
                        Log.e(TAG,"error load headline no internet ${e.message}")
                    }
                }

                try {
                   Log.d(TAG,"do load headline local")

                    val result = repo.getHeadlineNewsLocal()
                    state.postValue(MainState.OnShowHeadline(result))

                    Log.d(TAG,"succes load headline local")
                }catch (e:Throwable){
                    Log.d(TAG,"error load headline local ${e.message}")
                }

            }

        }
    }
}