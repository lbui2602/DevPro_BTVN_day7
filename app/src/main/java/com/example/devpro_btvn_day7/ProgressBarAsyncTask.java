package com.example.devpro_btvn_day7;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressBarAsyncTask extends AsyncTask<Integer,Integer,String> {

    ProgressBar progressBar;
    TextView tvPhanTram;

    public ProgressBarAsyncTask(ProgressBar progressBar, TextView tvPhanTram) {
        this.progressBar = progressBar;
        this.tvPhanTram = tvPhanTram;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        tvPhanTram.setText("Bat dau");
    }

    @Override
    protected String doInBackground(Integer... integers) {
        for(int i=0;i<1000;i++){
            try {
                Thread.sleep(1);
                publishProgress(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        double cnt=((double)values[0]/10);
        tvPhanTram.setText("Running..."+ cnt+"%");
        progressBar.setProgress(values[0]);
    }
    @Override
    protected void onPostExecute(String result) {
        progressBar.setVisibility(View.GONE);
        tvPhanTram.setText("Done");
    }
}
