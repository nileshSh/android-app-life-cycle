package com.thinkersoft.activitylifecycledemo.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.thinkersoft.activitylifecycledemo.R;

public class MySongService extends Service {

    MediaPlayer myPlayer;
    public MySongService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        myPlayer = MediaPlayer.create(this, R.raw.raabta);
        myPlayer.start();
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {

        myPlayer.stop();
        myPlayer.release();
        super.onDestroy();
    }
}
