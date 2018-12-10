package com.liangxl.money;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "OWEN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                run();
            }
        });
    }


    public static void run() {
        new Thread() {
            @Override
            public void run() {
                boolean isRoot = ShellUtils.checkRootPermission();
                if (isRoot) {
                    Log.d(TAG, "run:   " + isRoot);
                    while (true) {
                        SystemClock.sleep(1000);
                        ShellUtils.execCommand("input tap 100 500\n", isRoot);
                        Log.d(TAG, "run:   " + "execCommand");

                    }
                }
            }
        }.start();

    }

}
