package com.thinkful.segmenttest;

import android.app.Application;

import com.segment.analytics.Analytics;

/**
 * Created by macbook on 2/2/16.
 */
public class MyApplication extends Application{
    private static MyApplication singleton;

    public MyApplication getInstance(){
        return singleton;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
        // Create an analytics client with the given context and Segment write key.
        Analytics analytics = new Analytics.Builder(getApplicationContext(), "N2z0TANdreYB5sfpK81jIAGHkpPrzmnM").logLevel(Analytics.LogLevel.VERBOSE).build();

// Set the initialized instance as a globally accessible instance.
        Analytics.setSingletonInstance(analytics);
        // Safely call Analytics.with(context) from anywhere within your app!
        Analytics.with(getApplicationContext()).track("Application Started");
    }
}
