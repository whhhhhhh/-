package controller;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class MainService extends Service{
    
    private class MsgReceiverForService extends BroadcastReceiver{
        @Override
        public void onReceive(Context context,Intent intent){
            
        }
    }
    
    private MsgReceiverForService MsgReceiver = new MsgReceiverForService(); 
    
    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public void onCreate(){
        IntentFilter filter = new IntentFilter();
        filter.addAction("MainService");
        registerReceiver(MsgReceiver,filter);
    }
}
