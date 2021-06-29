
package com.shagii.loginmvvm.model.course;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Course {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("courseEn")
    @Expose
    private String courseEn;
    @SerializedName("courseMr")
    @Expose
    private String courseMr;
    @SerializedName("courseHi")
    @Expose
    private String courseHi;
    @SerializedName("discription")
    @Expose
    private String discription;
    @SerializedName("discriptionHn")
    @Expose
    private String discriptionHn;
    @SerializedName("discriptionMr")
    @Expose
    private String discriptionMr;
    @SerializedName("isActive")
    @Expose
    private Boolean isActive;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("validityInDays")
    @Expose
    private Integer validityInDays;
    @SerializedName("language")
    @Expose
    private Integer language;

    public final static Parcelable.Creator<Course> CREATOR = new Parcelable.Creator<Course>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Course createFromParcel(android.os.Parcel in) {
            return new Course(in);
        }

        public Course[] newArray(int size) {
            return (new Course[size]);
        }

    };
    protected Course(android.os.Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.courseEn = ((String) in.readValue((String.class.getClassLoader())));
        this.discription = ((String) in.readValue((String.class.getClassLoader())));
        this.price = ((Integer) in.readValue((Integer.class.getClassLoader())));

    }


    public Course() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseEn() {
        return courseEn;
    }

    public void setCourseEn(String courseEn) {
        this.courseEn = courseEn;
    }

    public String getCourseMr() {
        return courseMr;
    }

    public void setCourseMr(String courseMr) {
        this.courseMr = courseMr;
    }

    public String getCourseHi() {
        return courseHi;
    }

    public void setCourseHi(String courseHi) {
        this.courseHi = courseHi;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getDiscriptionHn() {
        return discriptionHn;
    }

    public void setDiscriptionHn(String discriptionHn) {
        this.discriptionHn = discriptionHn;
    }

    public String getDiscriptionMr() {
        return discriptionMr;
    }

    public void setDiscriptionMr(String discriptionMr) {
        this.discriptionMr = discriptionMr;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getValidityInDays() {
        return validityInDays;
    }

    public void setValidityInDays(Integer validityInDays) {
        this.validityInDays = validityInDays;
    }

    public Integer getLanguage() {
        return language;
    }

    public void setLanguage(Integer language) {
        this.language = language;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(courseEn);
        dest.writeValue(discription);
        dest.writeValue(price);

    }

    public int describeContents() {
        return  0;
    }

}
