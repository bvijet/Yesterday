package com.vijet.trackyou;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class TrackYouMainActivity extends FragmentActivity {

	private ViewPager pager;
	private FragmentsAdapter mFragmentAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_track_you_main);
		init();
	}

	private void init(){
		pager = (ViewPager) findViewById(R.id.pager);
		mFragmentAdapter = new FragmentsAdapter(getSupportFragmentManager());
		pager.setAdapter(mFragmentAdapter);
	
	}
	
}
