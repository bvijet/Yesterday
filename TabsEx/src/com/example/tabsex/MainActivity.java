package com.example.tabsex;


import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	ViewPager mPager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 mPager = (ViewPager)findViewById(R.id.pager);
		
	}

	class Myadapter extends PagerAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return false;
		}

		
		
	}

}
