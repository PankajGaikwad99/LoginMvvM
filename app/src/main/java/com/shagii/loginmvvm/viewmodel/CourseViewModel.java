package com.shagii.loginmvvm.viewmodel;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.shagii.loginmvvm.model.course.CourseResponseModel;
import com.shagii.loginmvvm.repository.RemoteRepository;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CourseViewModel extends AndroidViewModel {

    private Context context;

    RemoteRepository mRemote = new RemoteRepository();

    MutableLiveData<CourseResponseModel> responseModelMutableLiveData = new MutableLiveData<>();

    public CourseViewModel(@NonNull @NotNull Application application) {
        super(application);
    }


    public void onCoursesList(int size, int no, String token) {
        Observable<CourseResponseModel> mcourseResponseModelObservable = Observable.defer(new Callable<ObservableSource<? extends CourseResponseModel>>() {
            @Override
            public ObservableSource<? extends CourseResponseModel> call() throws Exception {
                 return mRemote.getAllCourses(size, no, token);
            }
        });
        mcourseResponseModelObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mCourseObserver);

    }
    Observer<CourseResponseModel> mCourseObserver = new Observer<CourseResponseModel>() {
        @Override
        public void onSubscribe(@NotNull Disposable d) {
            Log.d("onSubscribe","Subscribed");
        }

        @Override
        public void onNext(@NotNull CourseResponseModel courseResponseModel) {
            responseModelMutableLiveData.setValue(courseResponseModel);
        }

        @Override
        public void onError(@NotNull Throwable e) {
            Log.d("onError",e.getMessage());
        }

        @Override
        public void onComplete() {
            Log.d("onComplete","Completed");
        }
    };
    public MutableLiveData<CourseResponseModel> getAllCourseResponseData() {
        return responseModelMutableLiveData;
    }
}


