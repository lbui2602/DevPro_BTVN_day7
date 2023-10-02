package com.example.devpro_btvn_day7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    TextView tvPhanTram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=findViewById(R.id.progressBar);
        tvPhanTram=findViewById(R.id.tvPhanTram);
        new ProgressBarAsyncTask(progressBar,tvPhanTram).execute();
    }
}