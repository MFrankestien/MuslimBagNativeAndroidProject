package com.example.muslimbag;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.muslimbag.Quraan.BlankFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView ;


    Fragment selected;
    Fragment selected1;
    Fragment selected2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       bottomNavigationView = findViewById(R.id.NB_menue);

         selected  = new BlankFragment();
         selected1  = new HadethFragment2();
         selected2 = new AzkarFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.content, selected );
        transaction.commit();
       bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

               switch(menuItem.getItemId())
               {
                   case R.id.quran:
                       selected  = new BlankFragment();
                       FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                       transaction.replace(R.id.content, selected );
                       transaction.commit();
                       return true;

                   case R.id.Ahadeth:

                       FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                       transaction1.replace(R.id.content, selected1 );
                       transaction1.commit();
                       return true;

                   case R.id.azkar:

                       FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                       transaction2.replace(R.id.content, selected2 );
                       transaction2.commit();
                       return true;

                   }


                 return false;
           }

       });










    }
}
