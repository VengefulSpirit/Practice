package com.dreamer.practice.fragment.music;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dreamer.practice.R;
import com.dreamer.practice.widget.PagerSlidingTabStrip;


public class MusicFragment extends Fragment {
	
	private PagerSlidingTabStrip pagerSlidingTabStrip;
    private ViewPager viewPager;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_music, null);
		pagerSlidingTabStrip = (PagerSlidingTabStrip) view.findViewById(R.id.tab_strip);
		viewPager = (ViewPager) view.findViewById(R.id.view_pager);
		MusicPagerAdapter adapter = new MusicPagerAdapter(getChildFragmentManager());
		viewPager.setAdapter(adapter);
		pagerSlidingTabStrip.setViewPager(viewPager);
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
	
	public class MusicPagerAdapter extends FragmentPagerAdapter {

        private final String[] TITLES = {"豆瓣TOP500", "新歌TOP100"};

        public MusicPagerAdapter(FragmentManager fm) {
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
        		return new MusicNewFragment();
        	}else{
        		return new MusicRankFragment();
        	}
            
        }
    }

}