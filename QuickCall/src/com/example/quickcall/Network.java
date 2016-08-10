package com.example.quickcall;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Network extends Activity{
	String s2=null;
	
	public void onCreate(Bundle b)
	{
		super.onCreate(b);
		setContentView(R.layout.network);
		TextView tv=(TextView)findViewById(R.id.TextView01);
		Bundle extras=getIntent().getExtras();
		
		s2=extras.getString("phone");
		
		
       
		try {
			InputStream is =getResources().openRawResource(R.raw.indiamobilesdata);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
	        String s;
	        int linecount=0;
	        String line;
	        int i2=0;
	        while ((s=br.readLine())!=null)
	     				  {
	     				  linecount++;
	     				  int indexfound=s.indexOf(s2);
	     				  if(indexfound>-1)
	     							  {
	     					  			i2=i2+1;
	     								 line=s;
	     								  String s5[]=line.split("=");
	     								  String s10[]=s5[1].split("~");
	     								  tv.append("Mobile Series:"+s2+"\n");
	     								  for(int i=1;i<s10.length;i++)
	     								  {
	     									  
	     									  
	     									  tv.append(s10[i]+"\n");
	     									  
	     									  
	     									  
	     								  }
	     								  String s7[]=s10[3].split(":");
	     								  String s6[]=s7[1].split(". ");
	     								 
	     								  if(s6[0].equals(" Airtel"))
	     								  {
	     									 
	     									 ImageView image = (ImageView) findViewById(R.id.ImageView01);
	     							        Bitmap bMap = BitmapFactory.decodeResource(getResources(), R.drawable.airtel);
	     							        image.setImageBitmap(bMap);
	     								  }
	     								 if(s6[0].equals(" Uninor"))
	     								  {
	     									
	     									ImageView image = (ImageView) findViewById(R.id.ImageView01);
	     							        Bitmap bMap = BitmapFactory.decodeResource(getResources(), R.drawable.uninor);
	     							        image.setImageBitmap(bMap);
	     								  }
	     								if(s6[0].equals(" Vodafone"))
	     								  {
	     									
	     									ImageView image = (ImageView) findViewById(R.id.ImageView01);
	     							        Bitmap bMap = BitmapFactory.decodeResource(getResources(), R.drawable.vodafone);
	     							        image.setImageBitmap(bMap);
	     								  }
	     								  
	     							  }
	     							 
	     				  }
	        if (i2==0)
			  {
				  tv.setText("Sorry Not Found !");
			  }

	        is.close();
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}
