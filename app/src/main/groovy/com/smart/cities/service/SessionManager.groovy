package com.smart.cities.service

import android.content.Context
import com.smart.cities.model.User
import groovy.transform.CompileStatic

@CompileStatic
interface SessionManager {

    void setUserSession(User user, Context context)
    User getUserSession(Context context)
    Boolean isUserSession(Context context)
    void setLogout(Context context)

}