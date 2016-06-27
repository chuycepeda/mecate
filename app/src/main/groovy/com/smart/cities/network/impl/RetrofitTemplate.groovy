package com.smart.cities.network.impl

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.smart.cities.model.User
import com.smart.cities.network.UserRestOperation
import groovy.transform.CompileStatic
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Singleton
@CompileStatic
class RetrofitTemplate {

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            .create();

    Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://one-smart-city-demo.appspot.com/_ah/api/onesmartcity/v1/")
            .build()

    def withRetrofit(Class operations, Closure onSuccess, Closure onError, Closure action){
        UserRestOperation restOperations = retrofit.create(operations) as UserRestOperation
        Call<User> model = action(restOperations) as Call<User>
        def callback = [
                onResponse :onSuccess,
                onFailure : onError
        ]
        model.enqueue(callback as Callback<User>)
    }

}