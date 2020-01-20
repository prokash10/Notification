package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

import com.example.notification.broadcast.BroadCastReceiver;

public class BroadCastActivity extends AppCompatActivity {
    BroadCastReceiver broadCastReceiver=new BroadCastReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast);
    }
    protected void onStart(){
        super.onStart();
        IntentFilter intentFilter=new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(broadCastReceiver,intentFilter);

    }

    protected  void onStop(){
        super.onStop();
        unregisterReceiver(broadCastReceiver);
    }
}
