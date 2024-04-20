package com.example.myapplication;

import android.app.Application;

import io.realm.Realm;

public class AppLaundryKu extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
