package com.team.view;

import com.teamwork.onekey.R;
import com.teamwork.onekey.R.layout;

import controller.UserListAdapter;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FriendListFragment extends ListFragment{
    
    private UserListAdapter friendListManager;
    @Override
  public View onCreateView(LayoutInflater inflater,ViewGroup parent,Bundle savedInstanceState){
      View view = inflater.inflate(R.layout.friend_list_fragment, parent,false);
      return view;
  }
}
