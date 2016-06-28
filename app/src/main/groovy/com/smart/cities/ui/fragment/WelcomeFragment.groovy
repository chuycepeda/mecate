package com.smart.cities.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.smart.cities.R
import com.smart.cities.ui.activity.AboutActivity
import com.smart.cities.ui.activity.LoginActivity
import com.smart.cities.ui.activity.RegisterActivity
import groovy.transform.CompileStatic

import java.util.zip.Inflater

@CompileStatic
class WelcomeFragment extends Fragment {

    WelcomeFragment() {}

    private static final String TAG = "WelcomeFragment"
    private TextView messageToRegister
    private TextView messageToLogin
    private TextView messageToAbout

    @Override
    void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        //Podemos inicializar valores, eventos y preguntar cosas para actuar
    }


    View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View root = inflater.inflate(R.layout.fragment_welcome,container,false)
        messageToRegister = (TextView) root.findViewById(R.id.welcome_message_register)
        messageToRegister.onClickListener = {
            Intent intent = RegisterActivity.newIntentWithContext(getContext())
            startActivity(intent)
        }
        messageToLogin = (TextView) root.findViewById(R.id.welcome_message_login)
        messageToLogin.onClickListener = {
            Intent intent = LoginActivity.newIntentWithContext(getContext())
            startActivity(intent)
        }
        messageToAbout = (TextView) root.findViewById(R.id.welcome_message_about)
        messageToAbout.onClickListener = {
            Intent intent = AboutActivity.newIntentWithContext(getContext())
            startActivity(intent)
        }
        root
    }


}