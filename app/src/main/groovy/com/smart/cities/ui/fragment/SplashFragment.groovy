package com.smart.cities.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.smart.cities.R
import groovy.transform.CompileStatic
import com.smart.cities.ui.activity.WelcomeActivity
import java.util.zip.Inflater


@CompileStatic
class SplashFragment extends Fragment {

    SplashFragment() {}

    @Override
    void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        //Podemos inicializar valores, eventos y preguntar cosas para actuar
        Intent intent = WelcomeActivity.newIntentWithContext(getContext())
        startActivity(intent)
    }
}