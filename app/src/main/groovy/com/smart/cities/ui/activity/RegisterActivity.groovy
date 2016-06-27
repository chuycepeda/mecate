package com.smart.cities.ui.activity

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.smart.cities.commons.SingleFragmentActivity
import com.smart.cities.ui.fragment.RegisterFragment

class RegisterActivity extends SingleFragmentActivity {

    static Intent newIntentWithContext(Context context){
        Intent intent = new Intent(context, RegisterActivity)
        intent
    }

    @Override
    Fragment createFragment() {
        new RegisterFragment()
    }
}