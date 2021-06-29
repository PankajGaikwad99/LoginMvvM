package com.shagii.loginmvvm.repository;

import com.shagii.loginmvvm.model.LoginRequestModel;
import com.shagii.loginmvvm.model.LoginResponceModel;
import com.shagii.loginmvvm.model.course.CourseResponseModel;
import com.shagii.loginmvvm.remote.ApiClient;
import com.shagii.loginmvvm.remote.ApiInterface;

import io.reactivex.Observable;
public class RemoteRepository {

    public ApiInterface mApiService = ApiClient.getClient().create(ApiInterface.class);

    public Observable<LoginResponceModel> getLogin(LoginRequestModel requestModel) {
        return mApiService.setLogin(requestModel);
    }

    public Observable<CourseResponseModel> getAllCourses(int pgSize, int pgNo, String token){
        return mApiService.getAllCourses(pgSize, pgNo, token);
    }
}
