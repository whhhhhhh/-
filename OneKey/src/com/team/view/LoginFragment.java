package com.team.view;

import com.teamwork.onekey.R;
import com.teamwork.onekey.R.layout;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class LoginFragment extends Fragment{
    public View onCreateView(final LayoutInflater inflater,ViewGroup parent,Bundle saveInstanceState){
         View view = inflater.inflate(R.layout.login_fragment, parent,false);
         
         //input fields' setting
         final EditText nameInput = (EditText)view.findViewById(R.id.name_input);
         final EditText passwordInput = (EditText)view.findViewById(R.id.password_input);
     
         Button loginButton = (Button)view.findViewById(R.id.submit);
         loginButton.setOnClickListener(new OnClickListener(){

             @Override
             public void onClick(final View v) {
                 String name = nameInput.getText().toString();
                 String password = passwordInput.getText().toString();
                 if(name.length()!=0&&password.length()!=0){
                     /*LoadingWindow = new PopupWindow(inflater.inflate(R.layout.loading_window,null,false),
                               LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT,true);
                       LoadingWindow.setAnimationStyle(R.style.PopupAnim);
                       LoadingWindow.showAsDropDown(v);
                       TimerTask temp = new TimerTask(){
                           public void run(){
                               LoadingWindow.dismiss();
                           }
                       };
                       Timer timer = new Timer(true);
                       timer.schedule(temp, 2000);*/
                       
                     Log.d("LoginFragment","submitbutton click");
                   /*Intent intent = new Intent("Service");
                   intent.putExtra("requestType",RequestType.LOGIN);
                   intent.putExtra("name", name);
                   intent.putExtra("password", password);
                   getActivity().sendBroadcast(intent);*/
                   
                 } else {
                     Toast.makeText(getActivity(), "登录信息不可为空",Toast.LENGTH_SHORT).show();
                 }
             }
         });
         Button signButton = (Button)view.findViewById(R.id.sign);
         signButton.setOnClickListener(new OnClickListener(){

             @Override
             public void onClick(View v) {
                 getFragmentManager().beginTransaction().addToBackStack(null).
                 replace(R.id.maincontent, new SignFragment()).commit();
             }});
         
         final LinearLayout ll = (LinearLayout)view.findViewById(R.id.ll);
         ll.setOnTouchListener(new OnTouchListener(){

             @Override
             public boolean onTouch(View view,MotionEvent e){
                 ll.setFocusable(true);
                 ll.setFocusableInTouchMode(true);
                 ll.requestFocus();
                 InputMethodManager in = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                 in.hideSoftInputFromWindow(view.getWindowToken(), 0);
                 return true;
             }
         });
         
         return view;
     }

 }