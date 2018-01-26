package com.thinkersoft.activitylifecycledemo;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class BActivity extends AppCompatActivity {
    private String TAG="B Activity :- ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Log.i("lifeCycle",TAG + "onCreate");
      //  String data=getIntent().getStringExtra("ABC");
      /*  if(savedInstanceState==null) {

            Log.i("lifeCycle",TAG + "onCreate == null ");
        }else {
            Log.i("lifeCycle", TAG + "onCreate != null");
        }*/
       // Log.i("lifeCycle",data);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent=new Intent(BActivity.this ,CActivity.class);

                startActivity(intent);
            }
        });
    }
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
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.i("lifeCycle",TAG + "onSaveInstanceState");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("lifeCycle",TAG + "onSaveInstanceState");
    }

    @Override
    public void onStateNotSaved() {
        super.onStateNotSaved();
        Log.i("lifeCycle",TAG + "onStateNotSaved");
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
