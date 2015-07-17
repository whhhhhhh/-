package com.team.view;

import com.teamwork.onekey.R;
import com.teamwork.onekey.R.id;
import com.teamwork.onekey.R.layout;
import com.teamwork.onekey.R.menu;

import controller.MainService;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
    
    private class MsgReceiverForMainActivity extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub
            
        }
        
    }
    
    private MsgReceiverForMainActivity MsgReceiver = new MsgReceiverForMainActivity();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getFragmentManager().beginTransaction().add(R.id.maincontent, new MainFragment()).commit();
        IntentFilter filter = new IntentFilter();
        filter.addAction("MainActivity");
        registerReceiver(MsgReceiver,filter);
        //Intent intent = new Intent(MainActivity.this,MainService.class);
       // startService(intent);
    }
    
    @Override
    public void onDestroy(){
        super.onDestroy();
        unregisterReceiver(MsgReceiver);
        Intent intent = new Intent(MainActivity.this,MainService.class);
        stopService(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
