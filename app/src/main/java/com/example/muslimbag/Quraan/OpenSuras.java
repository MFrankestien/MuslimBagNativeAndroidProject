package com.example.muslimbag.Quraan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.muslimbag.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class OpenSuras extends AppCompatActivity {
    public   String j;
    ArrayList<String> items=new ArrayList<>();
    RecyclerView recyclerView ;
    OpenSurasAdapter openSurasAdapter;
    int position ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_suras);
        Intent intent=getIntent();
         position = intent.getIntExtra("sura", 0);





        String text = "";


        try{

            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open((position)+".txt")));

            String line ="";
            while ((line=reader.readLine())!=null){
                items.add(line);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        recyclerView= findViewById(R.id.RV_suras);
         openSurasAdapter = new OpenSurasAdapter(items);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(openSurasAdapter);


    }
}
