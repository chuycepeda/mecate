package com.smart.cities.ui.activity

import android.support.v4.app.Fragment
import com.smart.cities.commons.SingleFragmentActivity
import com.smart.cities.ui.fragment.AboutFragment
import groovy.transform.CompileStatic

@CompileStatic
class AboutActivity extends SingleFragmentActivity {

    @Override
    Fragment createFragment() {
        new AboutFragment()
    }
}