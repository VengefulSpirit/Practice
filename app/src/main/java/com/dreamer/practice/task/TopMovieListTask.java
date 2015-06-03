package com.dreamer.practice.task;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.dreamer.practice.Application;
import com.dreamer.practice.bean.TopMovieList;
import com.dreamer.practice.utils.Constant;
import com.dreamer.practice.utils.ParamsUtil;
import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dreamer on 2015/5/12.
 */
public class TopMovieListTask extends AsyncTask<Void,Void,TopMovieList> {
    private final String TAG = "MovieListTask";
    private Context context;
    private Application application;
    private GetDateFinishedListener getDateFinishedListener;
    private TopMovieList topMovieList;

    public TopMovieListTask(Context context) {
        this.context = context;
        application = (Application)context.getApplicationContext();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected TopMovieList doInBackground(Void... params) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("start", "0");
        param.put("count", "50");
        Request request = new Request.Builder().url(ParamsUtil.makeUrl(Constant.TOP250, param)).build();
        try {
            Response response = application.getOkHttpClient().newCall(request).execute();
            if (response.isSuccessful()) {
                Gson gson = new Gson();
                topMovieList = gson.fromJson(response.body().string(), TopMovieList.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return topMovieList;
    }

    @Override
    protected void onPostExecute(TopMovieList topMovieList) {
        super.onPostExecute(topMovieList);
        if(topMovieList !=null){
            if (getDateFinishedListener!=null){
                getDateFinishedListener.onGetDateFinished(topMovieList.getSubjects());
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
