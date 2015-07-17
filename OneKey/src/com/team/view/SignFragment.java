package com.team.view;

import com.teamwork.onekey.R;
import com.teamwork.onekey.R.layout;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SignFragment extends Fragment{
    
    TextView nameHint;
    TextView passwordHint;
    TextView passwordAgainHint;
    EditText nameInput;
    EditText passwordInput;
    EditText passwordAgain;
    boolean isNameOK = false;
    boolean isPasswordOK = false;
    boolean isPasswordAgainOK = false;
    public static SignFragment instance;
    private Handler signFragmentHandler;
    

  
  public View onCreateView(LayoutInflater inflater,ViewGroup parent,Bundle savedInstanceState){
      View view = inflater.inflate(R.layout.sign_fragment, parent,false);
      final LinearLayout ll  = (LinearLayout)view.findViewById(R.id.ll);
      nameHint = (TextView)view.findViewById(R.id.name_input_check);
      passwordHint = (TextView)view.findViewById(R.id.password_input_check);
      passwordAgainHint = (TextView)view.findViewById(R.id.password_again_check);
      
      Log.d("signfragment", "create view");
      /*signFragmentHandler = new Handler(){
          @Override
          public void handleMessage(Message msg){
              if(msg.what==HandlerMessageType.USERNAME_OK){
                  nameHint.setText("OK");
                  nameHint.setTextColor(Color.GREEN);
                  isNameOK = true;
              } else if(msg.what==HandlerMessageType.USERNAME_EXIST){
                  nameHint.setText("用户名已存在");
                  nameHint.setTextColor(Color.RED);
              }
          }
      };
      ((MainActivity)getActivity()).setSignFragmentHandler(signFragmentHandler);*/
      
      ll.setOnTouchListener(new OnTouchListener(){

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            ll.setFocusable(true);
            ll.setFocusableInTouchMode(true);
            ll.requestFocus();
            InputMethodManager in = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            in.hideSoftInputFromWindow(v.getWindowToken(), 0);
            return true;
        }});
      
      
      Button submit  = (Button)view.findViewById(R.id.submit);
      submit.setOnClickListener(new OnClickListener(){
          public void onClick(View v){
              if(isNameOK&&isPasswordOK&&isPasswordAgainOK){
                  /*Intent intent = new Intent("Service");
                  intent.putExtra("requestType", RequestType.SIGN);
                  intent.putExtra("name", nameInput.getText().toString());
                  intent.putExtra("password", passwordInput.getText().toString());
                  getActivity().sendBroadcast(intent);*/
              }
          }
      });
      
      Button back = (Button)view.findViewById(R.id.back);
      back.setOnClickListener(new OnClickListener(){
          public void onClick(View v){
              getFragmentManager().popBackStack();
          }
      });
      
      nameInput = (EditText)view.findViewById(R.id.name_input);
      nameInput.setOnFocusChangeListener(new OnFocusChangeListener(){

        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            isNameOK = false;
            if(!hasFocus){
                if(nameInput.getText().length()<4){
                    nameHint.setText("用户名不可少于4个字符");
                    nameHint.setTextColor(Color.RED);
                    return;
                } else {
                    /*Intent intent = new Intent("Service");
                    intent.putExtra("requestType",RequestType.CHECK_USERNAME);
                    intent.putExtra("name", nameInput.getText().toString());
                    getActivity().sendBroadcast(intent);*/
                } 
            }
        }
          
      });
      
      passwordInput = (EditText)view.findViewById(R.id.password_input);
      passwordInput.setOnFocusChangeListener(new OnFocusChangeListener(){

        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if(!hasFocus){
               if(passwordInput.getText().length()<4){
                   passwordHint.setText("密码不可少于4个字符");
                   passwordHint.setTextColor(Color.RED);
                   isPasswordOK = false;
               } else {
                   passwordHint.setText("OK");
                   passwordHint.setTextColor(Color.GREEN);
                   isPasswordOK = true;
               }
            }
        }});
      
      passwordAgain = (EditText)view.findViewById(R.id.password_again);
      passwordAgain.setOnFocusChangeListener(new OnFocusChangeListener(){

        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if(!hasFocus){
                if(passwordAgain.getText().toString().equals(passwordInput.getText().toString())){
                    passwordAgainHint.setText("OK");
                    passwordAgainHint.setTextColor(Color.GREEN);
                    isPasswordAgainOK = true;
                } else {
                    passwordAgainHint.setText("密码不匹配");
                    passwordAgainHint.setTextColor(Color.RED);
                    isPasswordAgainOK = false;
                }
            } 
        }});
      return view;
  }
  


public static SignFragment newInstance(){
    if(instance==null){
        instance = new SignFragment();
    }
    return instance;
}
}

