package com.example.dawan.tugasahir2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dawan on 2019-04-24.
 */

public class tes {
    @SerializedName("status")
    @Expose
    String status;



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
