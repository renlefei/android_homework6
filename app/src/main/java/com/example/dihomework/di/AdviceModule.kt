package com.example.dihomework.di
import com.example.dihomework.apiService.ApiService
import com.example.dihomework.apiService.XRepo
import com.example.dihomework.model.AdviceViewModel
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AdviceModule {

    @Provides
    fun providesAdviceApiService() : ApiService{
         val retrofit = Retrofit.Builder()
            .baseUrl("https://api.adviceslip.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

         return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun providesAdviceXRepo(apiService: ApiService) = XRepo(apiService)

    @Provides
    fun ProvidesAdviceViewModel(adviceXRepo: XRepo) = AdviceViewModel(adviceXRepo)

}