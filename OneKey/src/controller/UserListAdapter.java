package controller;

import java.util.ArrayList;

import model.User;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class UserListAdapter extends BaseAdapter{
   
    Context context;
    ArrayList<User> friendlist;
    
    public UserListAdapter(Context context,ArrayList<User> friendlist){
        this.context = context;
        this.friendlist = friendlist;
    }
    
    @Override
    public int getCount() {
        return friendlist.size();
    }

    @Override
    public Object getItem(int position) {
        return friendlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RelativeLayout rl = new RelativeLayout(context);
        
        ImageView avatar = new ImageView(context);
        avatar.setId(3);
        LayoutParams avatar_lp = new LayoutParams(60,60);
        avatar_lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        avatar_lp.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        avatar.setLayoutParams(avatar_lp);
        rl.addView(avatar);
        
        TextView name = new TextView(context);
        name.setText(friendlist.get(position).getName());
        name.setId(4);
        LayoutParams name_lp = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        name_lp.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        name_lp.addRule(RelativeLayout.ALIGN_RIGHT,3);
        name.setLayoutParams(name_lp);
        rl.addView(name);
        
        TextView resume = new TextView(context);
        resume.setText(friendlist.get(position).getCareer());
        resume.setId(4);
        LayoutParams resume_lp = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        resume_lp.addRule(RelativeLayout.ALIGN_BOTTOM,4);
        resume_lp.addRule(RelativeLayout.ALIGN_RIGHT,3);
        resume.setLayoutParams(resume_lp);
        rl.addView(resume);   
        
        return rl;
    }
    
    public void addItem(User user){
        friendlist.add(user);
        notifyDataSetChanged();
    }

}
