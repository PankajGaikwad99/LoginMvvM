package com.shagii.loginmvvm.viewmodel;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.shagii.loginmvvm.R;
import com.shagii.loginmvvm.model.LoginRequestModel;
import com.shagii.loginmvvm.model.LoginResponceModel;
import com.shagii.loginmvvm.repository.RemoteRepository;
import com.shagii.loginmvvm.utility.Utils;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginViewModel extends AndroidViewModel {

    RemoteRepository mremoteRepository = new RemoteRepository();
    private Context context;
    //public ObservableInt progressBar;
    public MutableLiveData<String> username = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public Observable<LoginResponceModel> mLoginObservable;
    public MutableLiveData<LoginResponceModel> mLoginMutableLiveData = new MutableLiveData<>();

    public LoginViewModel(@androidx.annotation.NonNull Application application) {
        super(application);
    }



    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                if (Utils.isNetworkConnected(view.getContext())) {
                    if(isValidUserDetail()) {
                        onLogin();
                    }
                }else {
                    showToast("Check Mobile No and Password");
                }
        }
        }
        private void onLogin() {
           // progressBar.set(View.GONE);
            mLoginObservable = Observable.defer(new Callable<ObservableSource<? extends LoginResponceModel>>() {
                @Override
                public ObservableSource<? extends LoginResponceModel> call() throws Exception {
                    LoginRequestModel requestModel = new LoginRequestModel();
                    requestModel.setMobile(username.getValue());
                    requestModel.setPassword(password.getValue());
                    return mremoteRepository.getLogin(requestModel);
                }
            });

            mLoginObservable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(loginObserver);
        }

        Observer<LoginResponceModel> loginObserver = new Observer<LoginResponceModel>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d("error", "subscribe");

            }

            @Override
            public void onNext(@NonNull LoginResponceModel loginResponceModel) {
               // progressBar.set(View.VISIBLE);
                mLoginMutableLiveData.setValue(loginResponceModel);

            }

            @Override
            public void onError(@NonNull Throwable e) {
               // progressBar.set(View.GONE);
                Log.d("error", e.getMessage());
            }

            @Override
            public void onComplete() {
                //progressBar.set(View.GONE);
                Log.d("error", "completed");

            }
        };

    private boolean isValidUserDetail() {

        if (username.getValue() == null || username.getValue().trim().equals("")) {
            //toastMessage.setValue(R.string.enter_valid_mobileno);
            return false;
        } else /*if (!Validations.isMobileValid(username.getValue().trim())) {
            toastMessage.setValue(R.string.enter_valid_mobileno);
            return false;
        }
        else*/ if (password.getValue() == null || password.getValue().equals("")) {
            /*CLICK_ACTION.setValue(Constants.Action.ERROR);
            toastMessage.setValue(R.string.enter_password);*/
            return false;
        }
        /*else if (!Validations.isPasswordValid(password.getValue().trim())) {
            toastMessage.setValue(R.string.enter_password_invalid_message);
            return false;
        }*/

        return true;
    }

        public MutableLiveData<LoginResponceModel> getLoginResponce() {
            return mLoginMutableLiveData;
        }

        public void showToast (String msg){
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
        }
    }
