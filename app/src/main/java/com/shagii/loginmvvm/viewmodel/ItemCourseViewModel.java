package com.shagii.loginmvvm.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;

import com.shagii.loginmvvm.model.course.Course;
import com.shagii.loginmvvm.utility.AppPreferences;

public class ItemCourseViewModel extends BaseObservable {

    private Context mContext;
    Course mCourse = new Course();
    private String courseEn;
    private String discription;
    private Integer price;
    public ItemCourseViewModel(Context context, Course mCourse) {
        mContext = context;
        this.mCourse = mCourse;
        notifyChange();
    }

    public void setCourseList(Course mCourse) {
        this.mCourse = mCourse;
        notifyChange();
    }

    public String getCourseEn() {
        return String.valueOf(mCourse.getCourseEn());
    }

    public void setCourseEn(String courseEn) {
        this.courseEn = courseEn;
    }

    public String getDiscription() {
        return String.valueOf(mCourse.getDiscription());
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getTitle() {
        if (AppPreferences.getLanguageId(mContext).equals("en")) {
            return mCourse.getCourseEn();
        } else if (AppPreferences.getLanguageId(mContext).equals("hi")) {
            return mCourse.getCourseHi();
        } else if (AppPreferences.getLanguageId(mContext).equals("mr")) {
            return mCourse.getCourseMr();
        }
        return mCourse.getCourseEn();
    }

    public String getDescription() {
        if (AppPreferences.getLanguageId(mContext).equals("en")) {
            return mCourse.getDiscription();
        } else if (AppPreferences.getLanguageId(mContext).equals("hi")) {
            return mCourse.getDiscriptionHn();
        } else if (AppPreferences.getLanguageId(mContext).equals("mr")) {
            return mCourse.getDiscriptionMr();
        }
        return mCourse.getDiscription();
    }

    public String getPrice() {
        return String.valueOf(mCourse.getPrice());
    }

    public String getValidity() {
        return (mCourse.getValidityInDays() + " days");
    }

    public String getLanguage() {
        if(mCourse.getLanguage() == 1) {
            return "English";
        } else if(mCourse.getLanguage() == 2) {
            return "Hindi";
        } else {
            return "Marathi";
        }
    }

    public String getIsActive() {
        if (mCourse.getIsActive())
            return "Yes";
        else
            return "No";
    }

}
