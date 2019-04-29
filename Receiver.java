package com.example.dawan.tugasahir2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by Dawan on 2019-04-27.
 */

public class Receiver extends BroadcastReceiver {

    public Receiver(){

    }
    @Override
    public void onReceive(Context context, Intent intent){
        Toast.makeText(context, "Action :" + intent.getAction(), Toast.LENGTH_SHORT).show();
    }
}
