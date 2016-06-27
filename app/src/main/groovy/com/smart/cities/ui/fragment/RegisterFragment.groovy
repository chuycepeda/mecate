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
import android.widget.Toast
import com.google.gson.Gson
import com.smart.cities.R
import com.smart.cities.model.User
import com.smart.cities.model.commands.RegisterCommand
import com.smart.cities.service.SessionManager
import com.smart.cities.service.SessionManagerImpl
import com.smart.cities.service.UserManager
import com.smart.cities.service.UserManagerImpl
import com.smart.cities.ui.activity.PrincipalActivity
import groovy.transform.CompileStatic
import retrofit2.Call
import retrofit2.Response

@CompileStatic
class RegisterFragment extends Fragment{

    private static final String TAG = "RegistrationFragment"
    private EditText mPasswordEditText
    private EditText mNameEditText
    private EditText mEmailEditText
    private Button mButtonRegistration

    UserManager mUserManager = UserManagerImpl.instance
    SessionManager mSessionManager = SessionManagerImpl.instance


    View onCreateView(LayoutInflater inflater,
                      @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View root = inflater.inflate(R.layout.fragment_registration, container, false)
        mPasswordEditText = (EditText) root.findViewById(R.id.password)
        mNameEditText = (EditText) root.findViewById(R.id.nameForm)
        mButtonRegistration = (Button) root.findViewById(R.id.btnRegistration)
        mEmailEditText = (EditText) root.findViewById(R.id.email)
        mButtonRegistration.onClickListener = {
            getElementsFormValues()
        }
        root
    }

    private void getElementsFormValues() {
        String email = mEmailEditText.text
        String name = mNameEditText.text
        String password = mPasswordEditText
        RegisterCommand registerCommand = new RegisterCommand(email: email,name: name,password: password)
        validatedRegister(registerCommand)
    }

    private validatedRegister(RegisterCommand registerCommand) {
        if(registerCommand.validateCommand())
            createNewUser(registerCommand)
        else
            cleanForm()
    }

    private void createNewUser(RegisterCommand registerCommand) {
        mUserManager.save(registerCommand,onSuccess(),OnError())
    }

    private void cleanForm(){
        Toast.makeText(getContext(), R.string.toastRegistrationFail, Toast.LENGTH_SHORT).show()
        mPasswordEditText.text = ""
    }

    private Closure OnError() {
        { Call<User> call, Throwable t -> Log.d("ERRORZ", "el error") }
    }

    private Closure onSuccess() {
        { Call<User> call, Response<User> response ->
            Log.d(TAG,response.body().dump())
            if(response.isSuccessful()){
                mSessionManager.setUserSession(response.body(),getContext())
                Intent intent = PrincipalActivity.newIntentWithContext(getContext())
                startActivity(intent)
                getActivity().finish()
            }else {
                Map<String, List<String>> errorMessages = new Gson().fromJson(response.errorBody().string(), Map)
                List message = errorMessages.collect{k,v ->
                    " El ${k} ${v[0]}"
                }
                Toast.makeText(getContext(),message.join(","), Toast.LENGTH_LONG).show()
            }

        }
    }

}