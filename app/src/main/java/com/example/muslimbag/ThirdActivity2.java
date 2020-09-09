package com.example.muslimbag;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThirdActivity2 extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity2);


        Intent intent =getIntent();
        int s =intent.getIntExtra("hades_num",1);
        String S= String.valueOf(s);
        String snm = intent.getStringExtra("hades_name");
        textView= findViewById(R.id.txt_hades_title);
        textView2= findViewById(R.id.txt_hades_content);
        textView.setText("الحديث "+snm);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("a"+S+".txt"), "UTF-8"));

            textView2.setText(reader.readLine());
        } catch (IOException e) {
            Log.e("error","IOException");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    Log.e("error","IOException");
                }
            }
        }
    }
}
