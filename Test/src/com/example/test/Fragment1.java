package com.example.test;

import java.io.BufferedInputStream;
import java.io.InputStream;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageButton;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment1 extends Fragment {

	private static final String TAG="Fragment1";
	private static final int CONTACT_PICKER_RESULT = 1001;  
	private ImageButton mImageButton_pickContact;
	private QuickContactBadge contactbadge;
	 private OnItemSelectedListener listener;	
	public TextView lati,longi;
	public Fragment1() {
		// TODO Auto-generated constructor stub
	}
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
		View view = inflater.inflate(R.layout.activity_fragment1, container, false);
		lati = (TextView)view.findViewById(R.id.lat);
		longi = (TextView)view.findViewById(R.id.longi);
		mImageButton_pickContact = (ImageButton) view.findViewById(R.id.pickContachButton);
		mImageButton_pickContact.setOnClickListener(pickContactButtonClickListner);
		contactbadge = (QuickContactBadge)view.findViewById(R.id.connected_bage_icon);
    	return view;
         
    }

	public void updateUI(String str){
		Log.d("TAG", "000000000000000000000000000000000");
		lati.setText(str);
	}
	
	@Override
    public void onAttach(Activity activity) {
      super.onAttach(activity);
    
    }
	
	private OnClickListener pickContactButtonClickListner = new OnClickListener(){

		@Override
		public void onClick(View view) {
			Intent contactPickerIntent = new Intent(Intent.ACTION_PICK,Contacts.CONTENT_URI);  
		    startActivityForResult(contactPickerIntent, CONTACT_PICKER_RESULT);
		}
		
	};
	
    @Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {  
        if (resultCode == Activity.RESULT_OK) {  
            switch (requestCode) {  
            case CONTACT_PICKER_RESULT:  
            	Uri contact = data.getData();
                ContentResolver cr = getActivity().getContentResolver();

              Cursor c = getActivity().managedQuery(contact, null, null, null, null);
              //      c.moveToFirst();


              while(c.moveToNext()){
                  String id = c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));

                  String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                  if (Integer.parseInt(c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
                      Cursor pCur = cr.query(Phone.CONTENT_URI,null,Phone.CONTACT_ID +" = ?", new String[]{id}, null);

                      while(pCur.moveToNext()){
                          String phone = pCur.getString(pCur.getColumnIndex(Phone.NUMBER));
                          //tv.setText(name+" Added " + phone);
                          //contactbadge.assignContactUri(contact);
                          //contactbadge.setMode(ContactsContract.QuickContact.MODE_LARGE);
                          
                          
                          
                          InputStream input = ContactsContract.Contacts.openContactPhotoInputStream(cr,
                                  ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, new Long(id)));
                                
                                 BufferedInputStream buf =new BufferedInputStream(input);
                                 Bitmap my_btmp = BitmapFactory.decodeStream(buf);
                                 
                                 if(my_btmp != null)
                                	 contactbadge.setImageBitmap(my_btmp);
                                 else
                                	 contactbadge.setImageResource(R.drawable.ic_launcher); 
                                 
                          Toast.makeText(getActivity().getApplicationContext(), name + ": " + phone, Toast.LENGTH_LONG).show();
                      }
                  }

              }
            }  
        } else {  
            Log.w(TAG, "Warning: activity result not ok");  
        }  
    }  
    
    public void showSelectedNumber(int type, String number) {
        Toast.makeText(getActivity().getApplicationContext(), type + ": " + number, Toast.LENGTH_LONG).show();      
    }
    
	@Override
	public void onResume() {
		super.onResume();
		Log.d(TAG,"----------------onResume---------------------");
	}
	
	@Override
	public void onPause() {
		super.onPause();
		Log.d(TAG,"----------------onPause---------------------");
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d(TAG,"----------------onDestroy---------------------");
	}
	
	


	// May also be triggered from the Activity
	  public void updateDetails(String lat, String longi) {
	    
		  
		 
	  }
}
