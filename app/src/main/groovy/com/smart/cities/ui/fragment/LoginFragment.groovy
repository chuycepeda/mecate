package com.smart.cities.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.smart.cities.R
import com.smart.cities.model.User
import com.smart.cities.model.commands.LoginCommand
import com.smart.cities.service.SessionManager
import com.smart.cities.service.SessionManagerImpl
import com.smart.cities.service.UserManager
import com.smart.cities.service.UserManagerImpl
import com.smart.cities.ui.activity.PrincipalActivity
import com.smart.cities.ui.activity.RegisterActivity
import groovy.transform.CompileStatic
import retrofit2.Call
import retrofit2.Response

@CompileStatic
class LoginFragment extends Fragment{

    private static final String TAG = "LoginFragment"
    private EditText userNameEditText
    private EditText passwordEditText
    private TextView messageToRegister
    private Button mButtonLogin

    UserManager mUserManager = UserManagerImpl.instance
    SessionManager mSessionManager = SessionManagerImpl.instance



    View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View root = inflater.inflate(R.layout.fragment_login, container, false)
        userNameEditText = (EditText) root.findViewById(R.id.input_username)
        passwordEditText = (EditText) root.findViewById(R.id.input_password)
        messageToRegister = (TextView) root.findViewById(R.id.message_register)
        mButtonLogin = (Button) root.findViewById(R.id.btnLogin)
        mButtonLogin.onClickListener = { getFormLogin() }
        messageToRegister.onClickListener = {
            Intent intent = RegisterActivity.newIntentWithContext(getContext())
            startActivity(intent)
        }
        root
    }

    private void getFormLogin(){
        LoginCommand loginCommand = new LoginCommand(email: userNameEditText.text.toString(),password:passwordEditText.text.toString())
        mUserManager.login(loginCommand,onSuccess(),OnError())
    }

    private Closure onSuccess() {
        { Call<User> call, Response<User> response ->
            Log.d(TAG,response.dump())
            if(response.code() == 200){
                mSessionManager.setUserSession(response.body(),getContext())
                Intent intent = PrincipalActivity.newIntentWithContext(getContext())
                startActivity(intent)
                getActivity().finish()
            }
            else {
                cleanForm()
            }

        }
    }

    private Closure OnError() {
        { Call<User> call, Throwable t ->
            Toast.makeText(getContext(),"Username or Password incorrect!", Toast.LENGTH_SHORT).show()
        }
    }

    private void cleanForm(){
        passwordEditText.text = ""
        Toast.makeText(getContext(), R.string.toastLoginFail, Toast.LENGTH_SHORT).show()
    }

}