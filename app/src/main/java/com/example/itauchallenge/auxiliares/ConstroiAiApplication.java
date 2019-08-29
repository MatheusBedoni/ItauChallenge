package com.example.itauchallenge.auxiliares;

import android.app.Application;
import android.content.Context;

import com.firebase.client.Firebase;

/**
 * Created by matheus on 06/06/16.
 */
public class ConstroiAiApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);

    }

}