package com.dreamer.practice.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.dreamer.practice.Application;
import com.dreamer.practice.bean.Movie;
import com.dreamer.practice.utils.Constant;
import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by dreamer on 2015/5/26.
 */
public class MovieTask extends AsyncTask<String,Void,Movie> {
    private final String TAG = "SimpleCelebrityListTask";
    private ProgressDialog progressDialog;
    private Context context;
    private Application application;
    private GetDateFinishedListener getDateFinishedListener;

    private Movie movie;
    public MovieTask(Context context){
        this.context = context;
        application = (Application)context.getApplicationContext();
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context, "提示", "数据加载中...", false, false);
    }

    @Override
    protected Movie doInBackground(String... params) {
        Request request = new Request.Builder().url(Constant.SUBJECT+params[0]).build();
        try {
            Response response = application.getOkHttpClient().newCall(request).execute();
            if (response.isSuccessful()) {
                Gson gson = new Gson();
                movie = gson.fromJson(response.body().string(), Movie.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movie;
    }

    @Override
    protected void onPostExecute(Movie movie) {
        super.onPostExecute(movie);
        if(movie!=null){
            //Log.e(TAG,movie.toString());
            if (getDateFinishedListener!=null){
                getDateFinishedListener.onGetDateFinished(movie);
            }
        }else{
            Toast.makeText(context,"网络异常",Toast.LENGTH_SHORT).show();
        }
        progressDialog.dismiss();
    }

    public void setGetDateFinishedListener(GetDateFinishedListener getDateFinishedListener) {
        this.getDateFinishedListener = getDateFinishedListener;
    }

    public static interface GetDateFinishedListener {
        void onGetDateFinished(Object data);
    }
}
