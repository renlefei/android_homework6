package com.example.dihomework.apiService

import android.os.Handler
import android.os.Looper
import com.example.dihomework.model.Advice
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class XRepo(private val apiService: ApiService) {

    //private lateinit var callResponse: ((String) -> Unit)

    fun load(response: (String) -> Unit){
        //this.callResponse = response

        var call = apiService.getAdvice()
        call.enqueue(object : retrofit2.Callback<Advice> {
            override fun onResponse(call: Call<Advice>, response: Response<Advice>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        response(it.slip.advice)
                        //callResponse.invoke(it.slip.advice)
                    }
                }
            }
            override fun onFailure(call: Call<Advice>, t: Throwable) {
            }
        })

    }
}