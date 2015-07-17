package com.team.view;

import com.teamwork.onekey.R;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.TextView;

public class LookForFirstAidFragment extends Fragment {
	private TextView countdownTextView;
	private int duration;
	private Handler uiHandler;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.look_for_first_aid_fragment,
				parent, false);
		
		duration = 3;
		countdownTextView = (TextView) view
				.findViewById(R.id.countdownTextView);
		countdownTextView.setText(duration);
		
		uiHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				if (msg.what > 0){
					countdownTextView.setText(duration);
					countdownTextView.invalidate();
				}
			}

		};
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(--duration > 0){
					Message msg = new Message();
					msg.what = duration;
					uiHandler.sendMessage(msg);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
		return view;
	}
	
	
}
