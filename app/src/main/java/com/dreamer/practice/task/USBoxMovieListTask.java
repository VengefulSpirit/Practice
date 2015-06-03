package com.dreamer.practice.task;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.dreamer.practice.Application;
import com.dreamer.practice.bean.USBoxMovieList;
import com.dreamer.practice.utils.Constant;
import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by dreamer on 2015/5/30.
 */
public class USBoxMovieListTask extends AsyncTask<Void, Void, USBoxMovieList> {
    private final String TAG = "USBoxMovieListTask";
    private Context context;
    private Application application;
    private GetDateFinishedListener getDateFinishedListener;
    private USBoxMovieList usBoxMovieList;

    public USBoxMovieListTask(Context context) {
        this.context = context;
        application = (Application)context.getApplicationContext();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected USBoxMovieList doInBackground(Void... params) {
        Request request = new Request.Builder().url(Constant.US_BOX).build();
        try {
            Response response = application.getOkHttpClient().newCall(request).execute();
            if (response.isSuccessful()) {
                Gson gson = new Gson();
                usBoxMovieList = gson.fromJson(response.body().string(), USBoxMovieList.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usBoxMovieList;
    }

    @Override
    protected void onPostExecute(USBoxMovieList usBoxMovieList) {
        super.onPostExecute(usBoxMovieList);
        if(usBoxMovieList !=null){
            if (getDateFinishedListener!=null){
                getDateFinishedListener.onGetDateFinished(usBoxMovieList.getSubjects());
            }
        }else{
            Toast.makeText(context,"网络异常",Toast.LENGTH_SHORT).show();
        }
    }

    public void setGetDateFinishedListener(GetDateFinishedListener getDateFinishedListener) {
        this.getDateFinishedListener = getDateFinishedListener;
    }

    public static interface GetDateFinishedListener {
        void onGetDateFinished(Object data);
    }
}
