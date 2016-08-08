package com.example.montoya.intentserviceexample.Services;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by montoya on 08.08.2016.
 */
public class MiService extends IntentService {

    private static final String LOG_TAG = MiService.class.getSimpleName();
    public static final String TRIGGER_METHOD = "TRIGGER";


    private String mMethod="NotDefined";






    public MiService() {
        super("MiService");

    }

    @Override
    protected void onHandleIntent(Intent intent) {

        //This is what the service does


        for(int i=0; i<100; i++){
            Log.i (LOG_TAG,"TRIGGER METHOD: "+mMethod+" - Service Running ..."+i+" ... ");

        }



    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mMethod=intent.getStringExtra(TRIGGER_METHOD);
        Log.i (LOG_TAG,"TRIGGER METHOD: "+mMethod+" - Service Started ...");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i (LOG_TAG,"Service Stopped ...");
    }


    public static class AlarmReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {

            Intent sendIntent=new Intent (context, MiService.class);
            sendIntent.putExtra("METHOD","AlarmReceiver");
            context.startService(sendIntent);

        }
    }
}
