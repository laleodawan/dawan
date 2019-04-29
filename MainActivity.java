package com.example.dawan.tugasahir2;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.GenericArrayType;

public class MainActivity extends AppCompatActivity {

    public static final int NOTIFICATION_ID = 1;
    //deklarasi variabel reseiver
    private final String BROADCAST_ACCES = "hehehe.php";
    private Button TampilNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //broadcase reseiver
        TampilNotification = findViewById(R.id.button);

        //membuat service
        //   Button btnStart = (Button) findViewById(R.id.btnStart);
        Button btnStop = (Button) findViewById(R.id.btnStop);

        // btnStart.setOnClickListener(new View.OnClickListener() {
        //   @Override
        //   public void onClick(View v) {
        //     startService(new Intent(MainActivity.this, AndroidService.class));
        //    }
        // });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(MainActivity.this, AndroidService.class));
            }
        });

    }

    private String coba;
    //menampilkan Notification
    public void tampilNotification(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("txtStatus"));
        //logika

        //reseiver
        //mengirim broadcase dengan filter yang dituju
        Intent receiverIntent = new Intent(MainActivity.this, Receiver.class);
        receiverIntent.putExtra("inputExtra",0);
        Intent SendBC = new Intent();
        SendBC.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
                .setAction(BROADCAST_ACCES)
                .putExtra("myBroadcase", "Broadcase diterima");
        sendBroadcast(SendBC);

        // membuat komponen pending intent

        //tambahan service
        Intent serviceIntent = new Intent(MainActivity.this, AndroidService.class);
        serviceIntent.putExtra("inputExtra", 0);
        Intent notificationInten = new Intent(this, Main2Activity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationInten, 0);
        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Peringatan")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                // .setStyle()
                .setContentText("Pemberitahuan");


        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, builder.build());

        startService(new Intent(MainActivity.this, Main2Activity.class));
        Intent intentt = new Intent(MainActivity.this, Main2Activity.class);

        ContextCompat.startForegroundService(MainActivity.this, serviceIntent);

        startActivity(intentt);

    }


}
