package com.example.progressbar;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.renderscript.Sampler;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressBar2 extends AppCompatActivity {
    private ProgressBar pgsBar;
    private int i = 0;
    TextView txtView , txtView1;
    Handler hdlr = new Handler();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar2);
        pgsBar = (ProgressBar) findViewById(R.id.pg);
        txtView1 = (TextView) findViewById(R.id.txt1);
        txtView = (TextView) findViewById(R.id.txt);
        i = pgsBar.getProgress();

        Intent i1 = getIntent();
        int  getcount = (Integer) i1.getSerializableExtra("Value");
        if (getcount == 1) {

            new Thread(new Runnable() {
                public void run() {
                    while (i < 100) {
                        i += 1;
                        hdlr.post(new Runnable() {
                            public void run() {

                                pgsBar.setProgress(i);
                                txtView.setText(i + "/" + pgsBar.getMax());
                                txtView1.setText(i+"%");
                            }
                        });
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

    }
}