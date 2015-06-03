package com.dreamer.practice.fragment.movie;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dreamer.practice.R;
import com.dreamer.practice.widget.PagerSlidingTabStrip;

public class FilmFragment extends Fragment {
	private final String TAG = "FilmFragment";
	private PagerSlidingTabStrip pagerSlidingTabStrip;
    private ViewPager viewPager;
	FilmPagerAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_film, null);
		pagerSlidingTabStrip = (PagerSlidingTabStrip) view.findViewById(R.id.tab_strip);
		viewPager = (ViewPager) view.findViewById(R.id.view_pager);
		adapter = new FilmPagerAdapter(getChildFragmentManager());
		viewPager.setAdapter(adapter);
		pagerSlidingTabStrip.setViewPager(viewPager);
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
	}
	
	public class FilmPagerAdapter extends FragmentStatePagerAdapter {

        private final String[] TITLES = {"TOP250", "北美票房榜"};

        public FilmPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public Fragment getItem(int position) {
        	if(position==0){
        		return new FilmTopFragment();
        	}else{
        		return new FilmUSBoxOfficeFragment();
        	}
            
        }
    }
	
}