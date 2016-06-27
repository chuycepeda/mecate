package com.smart.cities.model.commands

import groovy.transform.CompileStatic

@CompileStatic
class RegisterCommand{

    String password
    String name
    String email

    Boolean validateCommand(){
        def pattern = /[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[A-Za-z]{2,4}/
        this.email ==~ pattern &&  this.email != this.password && this.password
    }

}