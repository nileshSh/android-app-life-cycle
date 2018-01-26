package com.thinkersoft.activitylifecycledemo;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class CActivity extends AppCompatActivity {
    private String TAG="C Activity :-";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        Log.i("lifeCycle",TAG + "onCreate");
      /*  if(savedInstanceState==null) {

            Log.i("lifeCycle",TAG + "onCreate == null ");
        }else {
            Log.i("lifeCycle", TAG + "onCreate != null");
        }*/
            findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent=new Intent(CActivity.this ,BActivity.class);

                startActivity(intent);
            }
        });                                                         }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("lifeCycle",TAG + "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("lifeCycle",TAG + "onResume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i("lifeCycle",TAG + "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("lifeCycle",TAG + "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("lifeCycle",TAG + "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("lifeCycle",TAG + "onRestart");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i("lifeCycle",TAG + "onConfigurationChanged");
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return super.onRetainCustomNonConfigurationInstance();

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        Log.i("lifeCycle",TAG + "onRestoreInstanceState");
    }

}
