
package com.shagii.loginmvvm.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class LoginRequestModel {

    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("password")
    @Expose
    private String password;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
