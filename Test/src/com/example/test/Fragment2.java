package com.example.test;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

public class Fragment2 extends Fragment {
	private static final String TAG="Fragment2";

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         
    	return inflater.inflate(R.layout.activity_fragment2, container, false);
         
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
