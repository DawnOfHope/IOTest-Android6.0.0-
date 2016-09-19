package com.example.zorahu.iotestand600;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        詢問user是否同意應用程式讀取某些資料
         */
        boolean hasPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE )
                == PackageManager.PERMISSION_GRANTED;

        if (!hasPermission){
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    1);
        }
    }
    //Handle the permissions request response
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permission,@NonNull int[] grantResult){
        super.onRequestPermissionsResult(requestCode,permission,grantResult);
        if (requestCode == 1){

            if (grantResult.length > 0
                    && grantResult[0] == PackageManager.PERMISSION_GRANTED){

                Log.d("test","OK");
            }else {
                Log.d("test","不Ok");
            }
        }
    }
}
