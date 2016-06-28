package com.smart.cities.ui.activity

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.smart.cities.commons.SingleFragmentActivity
import com.smart.cities.ui.fragment.AboutFragment
import groovy.transform.CompileStatic

@CompileStatic
class AboutActivity extends SingleFragmentActivity {

    static Intent newIntentWithContext(Context context){
        Intent intent = new Intent(context, AboutActivity)
        intent
    }

    @Override
    Fragment createFragment() {
        new AboutFragment()
    }
}