package com.vijet.trackyou;

import com.vijet.trackyou.fragments.FragmentConnect;
import com.vijet.trackyou.fragments.FragmentMap;
import com.vijet.trackyou.fragments.FragmentRegistration;
import com.vijet.trackyou.fragments.FragmetMessages;
import com.vijet.trackyou.util.Constants;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class FragmentsAdapter extends FragmentStatePagerAdapter {

	public FragmentsAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		Fragment fragment = null;
		switch(position){
			case 0 : fragment = new FragmentConnect();
					 break;
			case 1 : fragment = new FragmentMap();
			 		 break;
			case 2 : fragment = new FragmetMessages();
	 		 		 break;
			case 3 : fragment = new FragmentRegistration();
	 		 		 break;
		}
		return fragment;
	}

	@Override
	public int getCount() {
		return Constants.NO_OF_FRAGMENTS;
	}
	
	@Override
	public CharSequence getPageTitle(int position) {
		
		switch(position){
			case 0 :return Constants.FIRST_FRAGMENT_NAME;
			case 1 :return Constants.SECOND_FRAGMENT_NAME;
			case 2 :return Constants.THIRD_FRAGMENT_NAME;
			case 3 :return Constants.FOURTH_FRAGMENT_NAME;
		}
		
		return super.getPageTitle(position);
	}

}
