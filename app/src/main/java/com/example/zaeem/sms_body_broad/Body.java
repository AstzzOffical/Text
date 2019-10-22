package com.example.zaeem.sms_body_broad;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class Body extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle=intent.getExtras();
        ///null na ho
        if (bundle!=null) {
            Object[] pdu = (Object[]) bundle.get("pdus");
            String number = null;
            for (int i = 0; i < pdu.length; ++i) {

                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdu[i]);

                number = null;

                number = smsMessage.getDisplayOriginatingAddress();
                String msg = smsMessage.getDisplayMessageBody();


               // Toast.makeText(context, "num=" + number + "message=" + msg, Toast.LENGTH_LONG).show();
            Database database=new Database(context);
                ContentValues contentValues=new ContentValues();
                contentValues.put("Message",msg);
                contentValues.put("Phone",number);
              boolean ok=  database.Insert("Student",contentValues);


              if (ok)
              {
                  Toast.makeText(context, "store", Toast.LENGTH_SHORT).show();
              }
              else
              {
                  Toast.makeText(context, "not store", Toast.LENGTH_SHORT).show();
              }

            }
            //SmsManager smsManager = SmsManager.getDefault();
            //smsManager.sendTextMessage(number, null,"",null,null  );



//            Intent obj=new Intent(context,MainActivity.class);
  //          obj.putExtra("zaeem",number);
    //        context.startActivities(new Intent[]{obj});

        }



    }
}
