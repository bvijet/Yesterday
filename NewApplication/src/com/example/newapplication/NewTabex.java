package com.example.newapplication;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;

public class NewTabex extends FragmentActivity {
	ViewPager mPager;
    MyAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_tabex);
		init();
	}

	void init(){
		 adapter = new MyAdapter(getSupportFragmentManager());
        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(adapter);
	        
	}

	public void b1Click(View view){
		Intent intent = new Intent();
        intent.setAction("com.vijet");
        
         
        sendBroadcast(intent);
	}
}
