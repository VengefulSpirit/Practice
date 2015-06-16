package com.dreamer.practice.fragment.movie;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dreamer.practice.R;
import com.dreamer.practice.adapter.USBoxMovieListAdapter;
import com.dreamer.practice.bean.USBoxMovie;
import com.dreamer.practice.task.USBoxMovieListTask;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.ScaleInLeftAnimator;

public class FilmUSBoxOfficeFragment extends Fragment {
    private final String TAG = "FilmUSBoxOfficeFragment";
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private SwipeRefreshLayout swipeRefreshLayout;
    private USBoxMovieListAdapter uSBoxMovieListAdapter;

    private List<USBoxMovie> uSBoxMovieList;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_film_us_box, null);
            initView();
            USBoxMovieListTask uSBoxMovieListTask = new USBoxMovieListTask(getActivity());
            uSBoxMovieListTask.setGetDateFinishedListener(new USBoxMovieListTask.GetDateFinishedListener() {
                @Override
                public void onGetDateFinished(boolean success, Object data) {
                    if (success) {
                        uSBoxMovieList = (ArrayList<USBoxMovie>) data;
                        uSBoxMovieListAdapter.clearUSBoxMovies();
                        uSBoxMovieListAdapter.addUSBoxMovies(uSBoxMovieList);
                    }else{
                        Toast.makeText(getActivity(), "网络异常", Toast.LENGTH_SHORT).show();
                    }
                    swipeRefreshLayout.setRefreshing(false);
                }
            });
            uSBoxMovieListTask.execute();
        }

        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }
        return view;
    }

    private void initView() {
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_container);
        uSBoxMovieListAdapter = new USBoxMovieListAdapter(getActivity());
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new ScaleInLeftAnimator());
        recyclerView.setAdapter(uSBoxMovieListAdapter);
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.accent));

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                USBoxMovieListTask uSBoxMovieListTask = new USBoxMovieListTask(getActivity());
                uSBoxMovieListTask.setGetDateFinishedListener(new USBoxMovieListTask.GetDateFinishedListener() {
                    @Override
                    public void onGetDateFinished(boolean success, Object data) {
                        if (success) {
                            uSBoxMovieList = (ArrayList<USBoxMovie>) data;
                            uSBoxMovieListAdapter.clearUSBoxMovies();
                            uSBoxMovieListAdapter.addUSBoxMovies(uSBoxMovieList);
                        }else{
                            Toast.makeText(getActivity(), "网络异常", Toast.LENGTH_SHORT).show();
                        }
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
                uSBoxMovieListTask.execute();
            }
        });
        swipeRefreshLayout.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
