package com.example.dawan.tugasahir2.client;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dawan on 2019-04-24.
 */

public class Client {
    //BASE URL DARI NAMA SITUS/DPMAIN

    private static Retrofit retrofit = null;
    public static Retrofit getClient(String baseUrl){
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
