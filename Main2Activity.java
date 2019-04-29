package com.example.dawan.tugasahir2;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dawan.tugasahir2.client.APIInterface;
import com.example.dawan.tugasahir2.rest.Rest;
import com.google.common.collect.Table;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity {
    private Table db_coba;
    TextView txtStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtStatus = (TextView) findViewById(R.id.txtStatus);

        //logika
      //  if (txtStatus == txtStatus && db_coba == true){
       //     "munculkan notif "
       // }else{
         //   "tidak"
       // }


        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    //    while (!isInterrupted()) {

                    Thread.sleep(500);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            APIInterface item = null;
                            item = Rest.getinterface();
                            item.getStatus().enqueue(new Callback<tes>() {
                                @Override
                                public void onResponse(Call<tes> call, Response<tes> response) {
                                    tes dt= response.body();
                                    txtStatus.setText("Status : " + dt.status);
                                }
                                @Override
                                public void onFailure(Call<tes> call, Throwable t) {
                                    Toast.makeText(Main2Activity.this, "asf", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    });
                    //
                } catch (InterruptedException e) {

                }
            }

        };
        t.start();
    }

}
