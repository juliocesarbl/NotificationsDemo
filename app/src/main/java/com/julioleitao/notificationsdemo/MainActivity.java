package com.julioleitao.notificationsdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 1,intent, 0);

        Notification notification = new Notification.Builder(getApplicationContext())
                .setContentTitle("Lunch is ready!!")
                .setContentText("It's getting could...")
                .setContentIntent(pendingIntent)
                .addAction(android.R.drawable.sym_action_chat,"Chat",pendingIntent)
                .setSmallIcon(android.R.drawable.sym_def_app_icon)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //the first parameter here, doesn't need to be the same as the pending intent
        notificationManager.notify(1,notification);

    }
}
