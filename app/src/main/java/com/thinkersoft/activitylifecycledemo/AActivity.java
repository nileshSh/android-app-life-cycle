package com.thinkersoft.activitylifecycledemo;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toolbar;

import com.thinkersoft.activitylifecycledemo.services.MySongService;

public class AActivity extends AppCompatActivity {
    private String TAG="A Activity :-";
    private Button mButton;
    ListView mlist;
    // data source
    String[] values = new String[] { "Android List View",
            "Adapter implementation",
            "Simple List View In Android",
            "Create List View Android",
            "Android Example",
            "List View Source Code",
            "List View Array Adapter",
            "Android Example List View"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        ArrayAdapter adapter=new ArrayAdapter<String>(this,R.layout.a_activity_list_item,R.id.a_activity_list_item_textview,values);

        mlist= (ListView) findViewById(R.id.listview);

        mlist.setAdapter(adapter);


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
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);

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

private class downLoadTask extends AsyncTask<String,String ,String>
{

    private String Tag="A downLoadTask :- ";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.i("lifeCycle",Tag + "onPreExecute");
    }

    @Override
    protected String doInBackground(String... strings) {
        Log.i("lifeCycle",Tag + "doInBackground");
        String s="";
        for(int i=0;i<200;i++)
        {//Log.i("lifeCycle",Tag + "do"+i);
            try {
                s=i+"";
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
        return s;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        Log.i("lifeCycle",Tag + "onProgressUpdate" +values);
    }

    @Override
    protected void onCancelled() {

        super.onCancelled();
        Log.i("lifeCycle",Tag + "onCancelled");
    }

    @Override
    protected void onCancelled(String s) {
        super.onCancelled(s);
        Log.i("lifeCycle",Tag + "onCancelled(String s) ");
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        mButton.setText(""+ s);
        Log.i("lifeCycle",Tag + "onPostExecute");
    }

}

}
