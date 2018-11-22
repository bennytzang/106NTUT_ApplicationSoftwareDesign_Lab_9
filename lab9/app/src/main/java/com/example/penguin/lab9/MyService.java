package com.example.penguin.lab9;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
    public MyService() {
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        new Thread() {
            boolean flag = true;
            int count = 0; ///計數器

            @Override
            public void run() {
                while (flag) {
                    Intent i = new Intent("MyMessage"); ///產生帶MyMessage識別字串的Intent
                    i.putExtra("background_service", count);
                    sendBroadcast(i);
                    count++;
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
