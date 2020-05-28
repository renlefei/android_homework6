package com.example.dihomework.apiService

import android.os.Handler
import android.os.Looper
import com.example.dihomework.model.Advice
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class XRepo(private val apiService: ApiService) {

    private lateinit var response: ((String) -> Unit)
    private val handler = Handler(Looper.getMainLooper()) {
        response.invoke(it.obj as String)
        true
    }

    fun load(response: (String) -> Unit){
        this.response = response
        val message = handler.obtainMessage()
        apiService.getAdvice().enqueue(object : retrofit2.Callback<Advice> {
            override fun onResponse(call: Call<Advice>, response: Response<Advice>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        message.obj = it.slip.advice
                        message.sendToTarget()
                    }
                }
            }
            override fun onFailure(call: Call<Advice>, t: Throwable) {
                message.obj = "ERROR"
                message.sendToTarget()
            }
        })

    }
}