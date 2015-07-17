package com.team.view;

import com.teamwork.onekey.R;
import com.teamwork.onekey.R.layout;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PersonInfoFragment extends Fragment{
    @Override
  public View onCreateView(LayoutInflater inflater,ViewGroup parent,Bundle savedInstanceState){
      View view = inflater.inflate(R.layout.person_info_fragment, parent,false);
      return view;
  }
}
