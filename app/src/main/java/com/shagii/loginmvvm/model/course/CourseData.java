
package com.shagii.loginmvvm.model.course;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class CourseData  {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("getCourse")
    @Expose
    private List<Course> courseList = new ArrayList<Course>();
    public final static Parcelable.Creator<CourseData> CREATOR = new Parcelable.Creator<CourseData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public CourseData createFromParcel(android.os.Parcel in) {
            return new CourseData(in);
        }

        public CourseData[] newArray(int size) {
            return (new CourseData[size]);
        }

    };

    protected CourseData(android.os.Parcel in) {
        this.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.courseList, (com.shagii.loginmvvm.model.course.Course.class.getClassLoader()));
    }


    public CourseData() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseListCourseList(List<Course> course) {
        this.courseList = courseList;
    }
    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(count);
        dest.writeList(courseList);
    }

    public int describeContents() {
        return  0;
    }


}
