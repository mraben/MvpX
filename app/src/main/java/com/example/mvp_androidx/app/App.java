package com.example.mvp_androidx.app;

import android.app.Application;
import android.content.Context;

/**
 * Description:
 */

public class App extends Application {

    public static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
    }
}
