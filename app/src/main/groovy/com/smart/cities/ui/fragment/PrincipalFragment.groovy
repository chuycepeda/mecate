package com.smart.cities.ui.fragment

import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.smart.cities.R
import groovy.transform.CompileStatic

@CompileStatic
class PrincipalFragment extends Fragment{

    View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View root = inflater.inflate(R.layout.fragment_principal, container, false)
        root
    }
}