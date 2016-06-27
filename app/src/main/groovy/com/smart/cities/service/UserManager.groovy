package com.smart.cities.service

import com.smart.cities.model.commands.LoginCommand
import com.smart.cities.model.commands.RegisterCommand
import groovy.transform.CompileStatic

@CompileStatic
interface UserManager {

    void save(RegisterCommand registrationCommand, Closure onSuccess, Closure onError)
    void login(LoginCommand loginCommand, Closure onSuccess, Closure onError)

}