package com.dreamer.practice.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dreamer.practice.R;
import com.dreamer.practice.fragment.book.BookFragment;
import com.dreamer.practice.fragment.city.CityFragment;
import com.dreamer.practice.fragment.movie.FilmFragment;
import com.dreamer.practice.fragment.music.MusicFragment;


public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private FragmentTabHost mTabHost;
    private View indicator = null;
    private static final String TAB_1_TAG = "movie";
    private static final String TAB_2_TAG = "book";
    private static final String TAB_3_TAG = "music";
    private static final String TAB_4_TAG = "city";
    private ActionBarDrawerToggle actionBarDrawerToggle = null;
    private DrawerLayout drawerLayout = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        actionBarDrawerToggle.syncState();
        drawerLayout.setDrawerListener(actionBarDrawerToggle);



        //new TestTask(MainActivity.this).execute();
        initView();

    }

    private void initView() {
        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(MainActivity.this, getSupportFragmentManager(), R.id.realtabcontent);

        indicator = getIndicatorView("电影",R.drawable.tab_icon_film, R.layout.tab_item);
        mTabHost.addTab(mTabHost.newTabSpec(TAB_1_TAG).setIndicator(indicator), FilmFragment.class, null);

        indicator = getIndicatorView("图书",R.drawable.tab_icon_book, R.layout.tab_item);
        mTabHost.addTab(mTabHost.newTabSpec(TAB_2_TAG).setIndicator(indicator), BookFragment.class, null);

        indicator = getIndicatorView("音乐",R.drawable.tab_icon_music, R.layout.tab_item);
        mTabHost.addTab(mTabHost.newTabSpec(TAB_3_TAG).setIndicator(indicator), MusicFragment.class, null);

        indicator = getIndicatorView("同城",R.drawable.tab_icon_city, R.layout.tab_item);
        mTabHost.addTab(mTabHost.newTabSpec(TAB_4_TAG).setIndicator(indicator), CityFragment.class, null);

        mTabHost.getTabWidget().setDividerDrawable(null);
    }

    private View getIndicatorView(String name,int resID, int layoutId) {
        View v = getLayoutInflater().inflate(layoutId, null);
        ImageView iv = (ImageView) v.findViewById(R.id.tab_iv);
        iv.setImageResource(resID);
        TextView tv = (TextView) v.findViewById(R.id.tab_tv);
        tv.setText(name);
        return v;
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
