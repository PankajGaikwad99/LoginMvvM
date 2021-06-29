package com.shagii.loginmvvm.remote;

import com.shagii.loginmvvm.model.LoginRequestModel;
import com.shagii.loginmvvm.model.LoginResponceModel;
import com.shagii.loginmvvm.model.course.CourseResponseModel;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @Headers("Content-Type: application/json")
    @POST("api/User/login")
    Observable<LoginResponceModel> setLogin(@Body LoginRequestModel requestModel);

    @Headers("Content-Type: application/json")
    @GET("api/Course/GetAll")
    Observable<CourseResponseModel> getAllCourses(@Query("Pagesize") int pgSize, @Query("Pageno") int pgNo, @Header("Authorization") String token);


}
