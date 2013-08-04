package com.vijet.trackyou.fragments;

import com.vijet.trackyou.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentMap extends Fragment {
	
	private static View view;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	    
		/*View view = inflater.inflate(R.layout.layout_fragment_map, container, false);
		return view;*/
		
		if (view != null) {
	        ViewGroup parent = (ViewGroup) view.getParent();
	        if (parent != null)
	            parent.removeView(view);
	    }
	    try {
	        view = inflater.inflate(R.layout.layout_fragment_map, container, false);
	    } catch (InflateException e) {
	        /* map is already there, just return view as it is */
	    }
	    return view;
	     
	}
}
