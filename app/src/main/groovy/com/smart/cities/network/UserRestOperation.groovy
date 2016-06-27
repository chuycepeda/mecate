package com.smart.cities.network

import com.smart.cities.model.User
import com.smart.cities.model.commands.LoginCommand
import com.smart.cities.model.commands.RegisterCommand
import groovy.transform.CompileStatic
import retrofit2.Call
import retrofit2.http.*

@CompileStatic
interface UserRestOperation {

    @POST("signup/")
    Call<User> registrationUser(@Body RegisterCommand registration)

    @POST("signin/")
    Call<User> loginUser(@Body LoginCommand login)



}