package com.example.dihomework.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dihomework.apiService.XRepo

class AdviceViewModel(private var repo: XRepo) : ViewModel() {
    private var _result: MutableLiveData<String> = MutableLiveData()
    var result:LiveData<String> = _result

    fun load(){
        repo.load { _result.value = it }
    }


}