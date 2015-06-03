package com.dreamer.practice.fragment.city;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dreamer.practice.R;
import com.dreamer.practice.adapter.TopMovieListAdapter;
import com.dreamer.practice.bean.Movie;
import com.dreamer.practice.task.TopMovieListTask;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.ScaleInLeftAnimator;

public class CityFragment extends Fragment {

	private RecyclerView recyclerView;
	private RecyclerView.LayoutManager layoutManager;
	private SwipeRefreshLayout swipeRefreshLayout;
	private TopMovieListAdapter topMovieListAdapter;
	private List<Movie> movieList;

	private View view;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (view==null){
			view = inflater.inflate(R.layout.fragment_city, null);
			initView();
			TopMovieListTask topMovieListTask = new TopMovieListTask(getActivity());
			topMovieListTask.setGetDateFinishedListener(new TopMovieListTask.GetDateFinishedListener() {
				@Override
				public void onGetDateFinished(Object data) {
					movieList = (ArrayList<Movie>) data;
					topMovieListAdapter.addMovies(movieList);
					recyclerView.setAdapter(topMovieListAdapter);
					swipeRefreshLayout.setRefreshing(false);
				}
			});
			topMovieListTask.execute();
		}

		ViewGroup parent = (ViewGroup) view.getParent();
		if (parent!=null){
			parent.removeView(view);
		}
		return view;
	}
	private void initView(){
		swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_container);
		topMovieListAdapter = new TopMovieListAdapter(getActivity());
		recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
		layoutManager = new LinearLayoutManager(getActivity());
		recyclerView.setLayoutManager(layoutManager);
		recyclerView.setItemAnimator(new ScaleInLeftAnimator());
		swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.accent));

		swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				TopMovieListTask topMovieListTask = new TopMovieListTask(getActivity());
				topMovieListTask.setGetDateFinishedListener(new TopMovieListTask.GetDateFinishedListener() {
					@Override
					public void onGetDateFinished(Object data) {
						movieList = (ArrayList<Movie>) data;
						topMovieListAdapter.addMovies(movieList);
						recyclerView.setAdapter(topMovieListAdapter);
						swipeRefreshLayout.setRefreshing(false);
					}
				});
				topMovieListTask.execute();
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
