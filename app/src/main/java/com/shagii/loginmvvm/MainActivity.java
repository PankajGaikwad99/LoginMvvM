package com.shagii.loginmvvm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.shagii.loginmvvm.databinding.ActivityMainBinding;
import com.shagii.loginmvvm.model.LoginResponceModel;
import com.shagii.loginmvvm.utility.AppPreferences;
import com.shagii.loginmvvm.viewmodel.LoginViewModel;

public class MainActivity extends AppCompatActivity {
    //private ActivityMainBinding activityMainBinding;
    private LoginViewModel loginViewModel;
    public static final String BEARER = "bearer";
    private ActivityMainBinding activityMainBinding;
    int SUCCESS = 200;
    public String mToken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        //loginViewModel = new LoginViewModel(this);
        activityMainBinding.setLogin(loginViewModel);

        setObserver();

    }

    private void setObserver()
    {

        loginViewModel.getLoginResponce().observe(this, new Observer<LoginResponceModel>() {
            @Override
            public void onChanged(LoginResponceModel loginResponceModel) {
                if(loginResponceModel.getStatus() == SUCCESS ){
                    if(loginResponceModel.getData() != null){

                        Toast.makeText(MainActivity.this, loginResponceModel.getStatusMessage(), Toast.LENGTH_LONG).show();
                        AppPreferences.setUserId(MainActivity.this, loginResponceModel.getData().getUserId());
                        AppPreferences.setFullName(MainActivity.this, loginResponceModel.getData().getFullName());
                        AppPreferences.setEmailId(MainActivity.this, loginResponceModel.getData().getEmail());
                        AppPreferences.setMobileNo(MainActivity.this, loginResponceModel.getData().getMobileNo());
                        AppPreferences.setRoleID(MainActivity.this, loginResponceModel.getData().getRoleId());
                        AppPreferences.setToken(MainActivity.this, BEARER + " " + loginResponceModel.getData().getToken());
                        String mToken = AppPreferences.getToken(MainActivity.this);
                        startActivity(new Intent(MainActivity.this,CourseActivity.class));
                        finish();
                    }
                }else{
                    Toast.makeText(MainActivity.this, loginResponceModel.getStatusMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}