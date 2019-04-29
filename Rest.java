package com.example.dawan.tugasahir2.rest;

import com.example.dawan.tugasahir2.client.APIInterface;
import com.example.dawan.tugasahir2.client.Client;

/**
 * Created by Dawan on 2019-04-24.
 */

public class Rest {

    // @SerializedName("https://dawan1234.000webhostapp.com/hehehe.php")
    public static final String url="http://dawan1234.000webhostapp.com/";

    public static APIInterface getinterface(){
        return Client.getClient(url).create(APIInterface.class);
    }
}