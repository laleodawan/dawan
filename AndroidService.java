package com.example.dawan.tugasahir2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Dawan on 2019-04-24.
 */

public class AndroidService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    public int onStopCommand(Intent intent, int flags, int stopId) {
        Toast.makeText(this, "Stop Service", Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }
    // broadcase receiver

}
