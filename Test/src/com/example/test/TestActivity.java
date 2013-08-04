package com.example.test;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.test.Fragment1.OnArticleSelectedListener;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;

public class TestActivity extends FragmentActivity implements GooglePlayServicesClient.ConnectionCallbacks,GooglePlayServicesClient.OnConnectionFailedListener, LocationListener
{
	Fragment f1,f2;
	Fragment1 f11;
	ViewPager mPager;
    MyAdapter adapter;
    /*private static int NUM_ITEMS = 2;
    LocationClient mLocationClient;
    Location location;
    
 // Milliseconds per second
    public static final int MILLISECONDS_PER_SECOND = 1000;

    // The update interval
    public static final int UPDATE_INTERVAL_IN_SECONDS = 5;

    // A fast interval ceiling
    public static final int FAST_CEILING_IN_SECONDS = 1;

    // Update interval in milliseconds
    public static final long UPDATE_INTERVAL_IN_MILLISECONDS =
            MILLISECONDS_PER_SECOND * UPDATE_INTERVAL_IN_SECONDS;

    // A fast ceiling of update intervals, used when the app is visible
    public static final long FAST_INTERVAL_CEILING_IN_MILLISECONDS =
            MILLISECONDS_PER_SECOND * FAST_CEILING_IN_SECONDS;
    
    private LocationRequest mLocationRequest;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        FragmentManager fm = getSupportFragmentManager();
        /*f11 = (Fragment1) fm.findFragmentById(R.id.f1);
       // f11 = (Fragment1) f1;
        f2 = (Fragment) fm.findFragmentById(R.id.f2);*/
        
        adapter = new MyAdapter(getSupportFragmentManager());

        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(adapter);

        mLocationClient = new LocationClient(this, this, this);

        mLocationRequest = LocationRequest.create();

        /*
         * Set the update interval
         */
        mLocationRequest.setInterval(UPDATE_INTERVAL_IN_MILLISECONDS);

        // Use high accuracy
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        // Set the interval ceiling to one minute
        mLocationRequest.setFastestInterval(FAST_INTERVAL_CEILING_IN_MILLISECONDS);
      
    }

    @Override
    protected void onStart() {
    	super.onStart();
    	mLocationClient.connect();
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	 
    	
    	
    }
    
    public void b1Click(View view){
    	onArticleSelected("hghgj");
    }
    
    public void b2Click(View view){
    	
    }

	public void b3Click(View view){
	
	}
    @Override
    protected void onDestroy() {
    	
    	super.onDestroy();
    	mLocationClient.removeLocationUpdates(this);
    }
	@Override
	public void onConnected(Bundle arg0) {
		Log.d("TAG", "indide oncceonnected");
		Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();

		location = mLocationClient.getLastLocation();
   	 mLocationClient.requestLocationUpdates(mLocationRequest, this);
   	pringLocation(location);
		
	}

	@Override
	public void onDisconnected() {
		Log.d("TAG", "indide disconnected");
		Toast.makeText(this, "disConnected", Toast.LENGTH_SHORT).show();

		
	}

	@Override
	public void onConnectionFailed(ConnectionResult connectionResult) {
		Toast.makeText(this, "Connection Failed", Toast.LENGTH_SHORT).show();
		
	}
    
    void pringLocation(Location loc){
    	Log.d("TAG", "LATITUDE"+ loc.getLatitude() + "LONGITUDE" + loc.getLongitude());
    }

    
	@Override
	public void onLocationChanged(Location location) {
		Toast.makeText(this, "Lat:"+location.getLatitude()+"LOng"+location.getLongitude(), Toast.LENGTH_SHORT).show();
	}

	

	
}
