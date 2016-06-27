package com.smart.cities.ui.fragment

import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.smart.cities.R
import groovy.transform.CompileStatic

import java.util.zip.Inflater

@CompileStatic
class AboutFragment extends Fragment {

    AboutFragment() {}

    @Override
    void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        //Podemos inicializar valores, eventos y preguntar cosas para actuar
    }


    View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View root = inflater.inflate(R.layout.fragment_about,container,false)
        root
    }


}