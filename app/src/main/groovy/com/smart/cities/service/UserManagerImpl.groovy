package com.smart.cities.service

import com.smart.cities.model.commands.LoginCommand
import com.smart.cities.model.commands.RegisterCommand
import com.smart.cities.network.UserRestOperation
import com.smart.cities.network.impl.RetrofitTemplate
import groovy.transform.CompileStatic

@Singleton
@CompileStatic
class UserManagerImpl implements UserManager {

    static operations = UserRestOperation

    @Override
    void save(RegisterCommand registrationCommand, Closure onSuccess, Closure onError) {
        RetrofitTemplate.instance.withRetrofit(operations as Class, onSuccess, onError) { UserRestOperation restOperations ->
            restOperations.registrationUser(registrationCommand)
        }
    }

    @Override
    void login(LoginCommand loginCommand, Closure onSuccess, Closure onError) {
        RetrofitTemplate.instance.withRetrofit(operations as Class, onSuccess, onError) { UserRestOperation restOperations ->
            restOperations.loginUser(loginCommand)
        }
    }

}