package com.dreamer.practice.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.dreamer.practice.R;
import com.dreamer.practice.adapter.SimpleCelebrityListAdapter;
import com.dreamer.practice.bean.Movie;
import com.dreamer.practice.task.MovieTask;
import com.ms.square.android.expandabletextview.ExpandableTextView;
import com.squareup.picasso.Picasso;

import java.util.Arrays;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by dreamer on 2015/5/25.
 */
public class MovieDetailActivity extends BaseActivity {
    private final String TAG = "MovieDetail";
    /**
     * 电影海报
     */
    private ImageView iv_poster;
    /**
     * 电影星级
     */
    private RatingBar rb_rate;
    /**
     * 评分
     */
    private TextView tv_rate;
    /**
     * 上映时间/时长
     */
    private TextView tv_time;
    /**
     * 国家
     */
    private TextView tv_country;
    /**
     * 电影类型
     */
    private TextView tv_genres;
    /**
     * 想看人数
     */
    //private TextView tv_want;
    /**
     * 已看人数
     */
    private TextView tv_see;
    /**
     * 简介
     */
    private ExpandableTextView expandableTextView;

    CardView row1,row2,row3;

    private RecyclerView rv_Celebrity;
    private LinearLayoutManager layoutManager;

    private SimpleCelebrityListAdapter simpleCelebrityListAdapter;

    private Movie movie;
    private String movieID;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        ShareSDK.initSDK(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.movie_detail);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MovieDetailActivity.this.onBackPressed();
            }
        });

        initView();

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        movieID = bundle.getString("movieID");
        MovieTask movieTask = new MovieTask(MovieDetailActivity.this);
        movieTask.setGetDateFinishedListener(new MovieTask.GetDateFinishedListener() {
            @Override
            public void onGetDateFinished(Object data) {
                movie = (Movie)data;
                Picasso.with(MovieDetailActivity.this).load(movie.getImages().getLarge()).placeholder(R.drawable.load).error(R.drawable.load_error).into(iv_poster);
                rb_rate.setRating(movie.getRating().getStars());
                tv_rate.setText("评分："+movie.getRating().getAverage() + "分");
                tv_time.setText(movie.getTitle() + " / " + movie.getYear() + "年");
                tv_country.setText("国籍：" + getString(movie.getCountries()));
                tv_genres.setText("类型："+getString(movie.getGenres()));
                //tv_want.setText(movie.getCollectCount()+"人想看");
                tv_see.setText(movie.getCollectCount()+"人看过");
                //Picasso.with(MovieDetail.this).load(movie.get).into(iv_poster);
                expandableTextView.setText(movie.getSummary());
                if (movie.getDirectors().length>0) {
                    simpleCelebrityListAdapter.addSimpleCelebrities(Arrays.asList(movie.getDirectors()), 1);
                }
                if (movie.getCasts().length>0) {
                    simpleCelebrityListAdapter.addSimpleCelebrities(Arrays.asList(movie.getCasts()), 2);
                }
                rv_Celebrity.setAdapter(simpleCelebrityListAdapter);

                row1.setVisibility(View.VISIBLE);
                row2.setVisibility(View.VISIBLE);
                row3.setVisibility(View.VISIBLE);
                ObjectAnimator animator = ObjectAnimator.ofFloat(row1, "alpha", 0f, 1f);
                animator.setDuration(1000);
                animator.start();

                animator = ObjectAnimator.ofFloat(row2, "alpha", 0f, 1f);
                animator.setDuration(1000);
                animator.start();

                animator = ObjectAnimator.ofFloat(row3, "alpha", 0f, 1f);
                animator.setDuration(1000);
                animator.start();
            }
        });
        movieTask.execute(movieID);
    }

    private void initView(){
        iv_poster = (ImageView) findViewById(R.id.iv_poster);
        rb_rate = (RatingBar) findViewById(R.id.rb_rate);
        tv_rate = (TextView) findViewById(R.id.tv_rate);
        tv_time = (TextView) findViewById(R.id.tv_time);
        tv_country = (TextView) findViewById(R.id.tv_country);
        tv_genres = (TextView) findViewById(R.id.tv_genres);
        //tv_want = (TextView) findViewById(R.id.tv_want);
        tv_see = (TextView) findViewById(R.id.tv_see);
        expandableTextView = (ExpandableTextView) findViewById(R.id.expand_text_view);
        row1 = (CardView) findViewById(R.id.row1);
        row2 = (CardView) findViewById(R.id.row2);
        row3 = (CardView) findViewById(R.id.row3);

        layoutManager = new LinearLayoutManager(MovieDetailActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_Celebrity = (RecyclerView) findViewById(R.id.celebrity);
        rv_Celebrity.setLayoutManager(layoutManager);

        simpleCelebrityListAdapter = new SimpleCelebrityListAdapter(MovieDetailActivity.this);
    }


    private String getString(String[] array){
        String str = "";
        for (int i=0;i<array.length;i++) {
            str += array[i];
            if (i != array.length-1){
                str += "|";
            }
        }
        return str;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            showShare();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle(getString(R.string.share));
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

        // 启动分享GUI
        oks.show(this);
    }
}
