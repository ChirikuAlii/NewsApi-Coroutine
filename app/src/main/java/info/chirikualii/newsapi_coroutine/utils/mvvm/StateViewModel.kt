package info.chirikualii.newsapi_coroutine.utils.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


/**
 * Created by chirikuAlii on 25/06/2020.
 * github.com/chirikualii
 */

abstract class StateViewModel<State> : ViewModel(){

    protected val TAG =this.javaClass.simpleName
    val state = MutableLiveData<State>()
}