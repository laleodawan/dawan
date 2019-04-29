package com.example.dawan.tugasahir2.client;

import com.example.dawan.tugasahir2.tes;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Dawan on 2019-04-24.
 */

public interface APIInterface {
    //@GET("http://dawan1234.000webhostapp.com/hehehe.php/")

    @GET("hehehe.php")
    Call<tes> getStatus();
}
