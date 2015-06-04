package com.dreamer.practice.task;

import android.content.Context;
import android.os.AsyncTask;

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
    private boolean isSuccess = true;

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
            isSuccess = false;
            return null;
        }
        return usBoxMovieList;
    }

    @Override
    protected void onPostExecute(USBoxMovieList usBoxMovieList) {
        super.onPostExecute(usBoxMovieList);
        if(usBoxMovieList !=null){
            if (getDateFinishedListener!=null){
                getDateFinishedListener.onGetDateFinished(isSuccess,usBoxMovieList.getSubjects());
            }
        }else{
            if (getDateFinishedListener!=null){
                getDateFinishedListener.onGetDateFinished(isSuccess,null);
            }
        }
    }

    public void setGetDateFinishedListener(GetDateFinishedListener getDateFinishedListener) {
        this.getDateFinishedListener = getDateFinishedListener;
    }

    public static interface GetDateFinishedListener {
        void onGetDateFinished(boolean success, Object data);
    }
}
