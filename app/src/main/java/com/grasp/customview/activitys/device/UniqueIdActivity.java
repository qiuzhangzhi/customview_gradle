package com.grasp.customview.activitys.device;

import java.lang.reflect.Method;

import com.grasp.customview.R;
import com.grasp.customview.R.layout;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class UniqueIdActivity extends Activity {

	TextView textView ;
	
	String imei;
	
	String serialNum;
	
	String androidId;
	
	String macAddress;
	
	TelephonyManager telephonyManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_unique_id);
		textView = (TextView)findViewById(R.id.unique_id);
		
		telephonyManager = (TelephonyManager) getSystemService( Context.TELEPHONY_SERVICE );
		imei = telephonyManager.getDeviceId();
		
		try {
			Class<?> c = Class.forName("android.os.SystemProperties");        	 
			Method get = c.getMethod("get", String.class, String.class );                     
			serialNum = (String)( get.invoke(c, "ro.serialno", "unknown" )  );
		} catch (Exception e) {
		}
		
		
		androidId = Settings.Secure.getString(getContentResolver(),Settings.Secure.ANDROID_ID);
		
		WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE); 
		WifiInfo wifiInfo = wifiManager.getConnectionInfo();  
		    if (wifiInfo.getMacAddress() != null) {  
		    	macAddress = wifiInfo.getMacAddress();// MACµÿ÷∑  
		    } else {  
		    	macAddress = "null";  
		    } 
		    
		  textView.setText("imei:"+imei+"\nserialNum:"+serialNum +"\nandroidId:"+androidId+"\nmacAddress:"+macAddress);
	}
}
