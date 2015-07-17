package controller;

import java.util.ArrayList;

import model.MyMessage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class MsgListAdapter extends BaseAdapter{
    
    Context context;
    ArrayList<MyMessage> msglist;
    
    public MsgListAdapter(Context context,ArrayList<MyMessage> msglist){
        this.context = context;
        this.msglist = msglist;
    }
    
    @Override
    public int getCount() {
        return msglist.size();
    }

    @Override
    public Object getItem(int position) {

        return msglist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout ll = new LinearLayout(context);
        TextView patient  = new TextView(context);
        patient.setText(msglist.get(position).getSender().getName());
        LayoutParams pl = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        patient.setLayoutParams(pl);
        
        TextView content = new TextView(context);
        content.setText(msglist.get(position).getContent());
        LayoutParams cl = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        patient.setLayoutParams(cl);
        ll.addView(patient);
        
        
        return ll;
    }
    
    public void addItem(MyMessage msg){
        msglist.add(msg);
        notifyDataSetChanged();
    }

}
