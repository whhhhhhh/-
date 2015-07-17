package com.team.view;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teamwork.onekey.R;

import controller.MsgListAdapter;
import controller.UserListAdapter;

public class AllMsgListFragment extends ListFragment{
    private MsgListAdapter msgListManager;
    @Override
  public View onCreateView(LayoutInflater inflater,ViewGroup parent,Bundle savedInstanceState){
      View view = inflater.inflate(R.layout.all_msg_list_fragment, parent,false);
      return view;
  }
}
