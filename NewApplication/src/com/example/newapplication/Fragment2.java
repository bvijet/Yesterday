package com.example.newapplication;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment2 extends Fragment {
	private static final String TAG="Fragment2";
	TextView tv2;
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
		 View view = inflater.inflate(R.layout.activity_fragment2, container, false);
	        tv2 = (TextView) view.findViewById(R.id.tv2);
    	return view;
         
    }

	@Override
	public void onResume() {
		super.onResume();
		Log.d(TAG,"----------------onResume---------------------");
	}
	
    @Override
	public void onDestroy() {
		super.onDestroy();
		Log.d(TAG,"----------------onDestroy---------------------");
	}

	

}
