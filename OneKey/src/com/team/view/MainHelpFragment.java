package com.team.view;


import com.teamwork.onekey.R;
import com.teamwork.onekey.R.layout;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainHelpFragment extends Fragment{
	private Button button1;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup parent,Bundle savedInstanceState){
        View view =inflater.inflate(R.layout.main_help_fragment,parent,false);
        button1 = (Button) view.findViewById(R.id.Button1);
        button1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
        	
        });
        return view;
        
       
    }

}
