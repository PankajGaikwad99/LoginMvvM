
package com.shagii.loginmvvm.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class LoginResponceModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("statusMessage")
    @Expose
    private String statusMessage;
    @SerializedName("data")
    @Expose
    private Data data;

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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
