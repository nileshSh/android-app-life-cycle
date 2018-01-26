package com.thinkersoft.activitylifecycledemo;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class DActivity extends AppCompatActivity {
    private String TAG="D Activity :-";
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);
        imageView= (ImageView) findViewById(R.id.imageview);
        Log.i("lifeCycle",TAG + "onCreate");
      //  new DrawLogo().execute("");
        if(savedInstanceState==null) {

            Log.i("lifeCycle",TAG + "onCreate == null ");
        }else {
            Log.i("lifeCycle", TAG + "onCreate != null");
        }    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("lifeCycle",TAG + "onStart");
    }


    private class  DrawLogo extends AsyncTask<String,Bitmap,Bitmap>
    {

        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap icon = BitmapFactory.decodeResource(DActivity.this.getResources(),
                    R.mipmap.ic_launcher);
            Bitmap image = BitmapFactory.decodeResource(DActivity.this.getResources(),
                    R.drawable.nilesh);
           Bitmap result=   overlayBitmapToCenter(image,icon);

            return result;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imageView.setImageBitmap(bitmap);
        }
    }

    public static Bitmap overlayBitmapToCenter(Bitmap bitmap1, Bitmap bitmap2) {
        int bitmap1Width = bitmap1.getWidth();
        int bitmap1Height = bitmap1.getHeight();
        int bitmap2Width = bitmap2.getWidth();
        int bitmap2Height = bitmap2.getHeight();
        int leftpadding=Math.round((bitmap1Width*8)/100);
        int rightpadding=Math.round((bitmap1Height*8)/100);
        int newbitmap2Hight=Math.round((bitmap1Width*20)/100);
        int newbitmap2Width=Math.round((bitmap1Width*20)/100);

        float marginLeft = (float) (bitmap1Width - (newbitmap2Width +10));
        float marginTop = (float) (bitmap1Height - (newbitmap2Width + 10));

        Bitmap overlayBitmap = Bitmap.createBitmap(bitmap1Width, bitmap1Height, bitmap1.getConfig());
        Canvas canvas = new Canvas(overlayBitmap);
        canvas.drawBitmap(bitmap1, new Matrix(), null);
        Paint paint = new Paint(Paint.FILTER_BITMAP_FLAG);
      ///  paint.setAlpha(30);
        Bitmap resized = Bitmap.createScaledBitmap(bitmap2, newbitmap2Width, newbitmap2Hight, true);
     //   Bitmap newBitmap2 = Bitmap.createBitmap(newbitmap2Width, newbitmap2Hight, bitmap2.getConfig());

        canvas.drawBitmap(resized, marginLeft, marginTop, paint);
        return overlayBitmap;
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
