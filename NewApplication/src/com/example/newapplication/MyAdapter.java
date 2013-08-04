package com.example.newapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MyAdapter extends FragmentStatePagerAdapter {
    

    public MyAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int position) {
    	Fragment fragment = null;
    	
    	switch(position)
    	{
    		case 0 :
    				fragment = new Fragment1();
    				break;
    		case 1:
    				fragment = new Fragment2();
    				break;
    	}
    	
    	return fragment;
    	 
    }
    
    @Override
    public CharSequence getPageTitle(int position) {
        return "OBJECT " + (position + 1);
    }
    
    
}