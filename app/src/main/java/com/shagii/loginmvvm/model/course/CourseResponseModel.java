
package com.shagii.loginmvvm.model.course;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CourseResponseModel  {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("statusMessage")
    @Expose
    private String statusMessage;
    @SerializedName("data")
    @Expose
    private CourseData courseData;
    public final static Parcelable.Creator<CourseResponseModel> CREATOR = new Parcelable.Creator<CourseResponseModel>() {


        @SuppressWarnings({
                "unchecked"
        })
        public CourseResponseModel createFromParcel(android.os.Parcel in) {
            return new CourseResponseModel(in);
        }

        public CourseResponseModel[] newArray(int size) {
            return (new CourseResponseModel[size]);
        }

    };

    protected CourseResponseModel(android.os.Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.statusMessage = ((String) in.readValue((String.class.getClassLoader())));
        this.courseData = ((CourseData) in.readValue((CourseData.class.getClassLoader())));
    }


    public CourseResponseModel() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public CourseData getCourseData() {
        return courseData;
    }

    public void setData(CourseData courseData) {
        this.courseData = courseData;
    }
    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(statusMessage);
        dest.writeValue(courseData);
    }

    public int describeContents() {
        return  0;
    }

}
