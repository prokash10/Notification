package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManagerCompat;
    private Button btn1;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        notificationManagerCompat=NotificationManagerCompat.from(this);
        Channel channel=new Channel(this);
        channel.createChannel();

        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DiisplayNotification1();
                DiisplayNotification1w();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DiisplayNotification2();

            }
        });
    }



    private void DiisplayNotification1() {
        Notification notification=new NotificationCompat.Builder(this, Channel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_not2)
                .setContentTitle("First MEssage")
                .setContentText("First message Body")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(1, notification);
    }

    private void DiisplayNotification2() {
        Notification notification=new NotificationCompat.Builder(this, Channel.CHANNEL_2)
                .setSmallIcon(R.drawable.ic_not1)

                .setContentTitle("Second message")
                .setContentText("Second message Body")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(2, notification);
    }


}
