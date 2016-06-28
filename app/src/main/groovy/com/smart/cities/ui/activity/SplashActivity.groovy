package com.smart.cities.ui.activity

import android.support.v4.app.Fragment
import com.smart.cities.commons.SingleFragmentActivity
import com.smart.cities.ui.fragment.SplashFragment
import groovy.transform.CompileStatic

@CompileStatic
class SplashActivity extends SingleFragmentActivity {

    @Override
    Fragment createFragment() {
        new SplashFragment()
    }
}