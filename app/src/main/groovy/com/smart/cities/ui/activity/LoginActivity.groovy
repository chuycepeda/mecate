package com.smart.cities.ui.activity

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.smart.cities.commons.SingleFragmentActivity
import com.smart.cities.ui.fragment.LoginFragment
import groovy.transform.CompileStatic

@CompileStatic
class LoginActivity extends SingleFragmentActivity {

    static Intent newIntentWithContext(Context context){
        Intent intent = new Intent(context, LoginActivity)
        intent
    }
    @Override
    Fragment createFragment() {
        new LoginFragment()
    }
}