package com.example.newapplication;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment1 extends Fragment {
	private static final String TAG="Fragment2";
	private TextView tv1;
	//MyBroadcast broadcast;
	IntentFilter ifil = new IntentFilter("com.vijet");
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment1, container, false);
        //tv1 = (TextView) view.findViewById(R.id.tv1);
        getActivity().getApplicationContext().registerReceiver(myReceiver, ifil);
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

    
    /*public class MyBroadcast extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			
			
		}
    	
    }
    */
	private BroadcastReceiver myReceiver = new BroadcastReceiver() {
		
		@Override
		public void onReceive(Context context, Intent intent) {
			Log.d("TAG","registerReceiver");
			String vij = "VIJET";
			tv1.setText(vij+="Hello");
			
		}
	};

}
