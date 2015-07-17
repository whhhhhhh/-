package com.team.view;

import com.teamwork.onekey.R;
import com.teamwork.onekey.R.id;
import com.teamwork.onekey.R.layout;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.Toast;

public class MainFragment extends Fragment{
    private TabHost myTabHost;
    FragmentManager fragmentManager; 
    FragmentTransaction ft;
     MainHelpFragment mainHelpFragment = new MainHelpFragment();
    FriendListFragment friendListFragment = new FriendListFragment();
    PersonInfoFragment hostInfoFragment = new PersonInfoFragment();
    Handler handler;
    
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup parent,Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.main_fragment, parent,false);
        
        handler = new Handler(){};
        myTabHost = (TabHost)view.findViewById(R.id.mytabhost);
        myTabHost.setup();
        myTabHost.addTab(myTabHost.newTabSpec("tab1").setIndicator("tab1").setContent(R.id.tab1));
        myTabHost.addTab(myTabHost.newTabSpec("messagelist").setIndicator("信息").setContent(R.id.messagelist));
        myTabHost.addTab(myTabHost.newTabSpec("mainhelp").setIndicator("三求").setContent(R.id.mainhelp));
        myTabHost.addTab(myTabHost.newTabSpec("friendlist").setIndicator("好友").setContent(R.id.friendlist));
        myTabHost.addTab(myTabHost.newTabSpec("individual").setIndicator("个人信息").setContent(R.id.individual));
        fragmentManager = getFragmentManager();
        ft = fragmentManager.beginTransaction();
        ft.add(R.id.mainhelp,mainHelpFragment);
        ft.add(R.id.individual, hostInfoFragment);
        ft.add(R.id.friendlist, friendListFragment);
        ft.commit();


        return view;
    }

}
