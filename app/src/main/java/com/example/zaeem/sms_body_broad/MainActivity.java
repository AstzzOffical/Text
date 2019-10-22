package com.example.zaeem.sms_body_broad;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView textView,textView2;
EditText editText;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_SMS,Manifest.permission.RECEIVE_SMS,Manifest.permission.SEND_SMS},22);


    textView=(TextView)findViewById(R.id.text);
    textView2=(TextView)findViewById(R.id.text2);
    editText=(EditText)findViewById(R.id.edit);
    button=(Button)findViewById(R.id.button);

    Database database=new Database(this);
    String name="";
    String num="";
        Cursor cursor=database.getData("Student");
        while (cursor.moveToNext())
        {

            name+=cursor.getString(cursor.getColumnIndex("Message"))+"\n";
            num+=cursor.getString(cursor.getColumnIndex("Phone"))+"\n";

        }

textView.append(name);
textView2.append(num);






    }
}
