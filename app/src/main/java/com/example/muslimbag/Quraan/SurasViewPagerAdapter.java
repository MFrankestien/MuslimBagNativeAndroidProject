package com.example.muslimbag.Quraan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.muslimbag.Quraan.OpenSuras;
import com.example.muslimbag.R;

public class SurasViewPagerAdapter extends PagerAdapter {
    private Context context;
    private String []ArSuras;

    public SurasViewPagerAdapter(String[] arSuras, Context context) {
        ArSuras = arSuras;
        this.context = context;
    }


    int[] textViews = {R.id.sura1, R.id.sura2, R.id.sura3, R.id.sura4, R.id.sura5, R.id.sura6,
            R.id.sura7, R.id.sura8, R.id.sura9};

    @Override
    public int getCount() {
        return 13;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        LayoutInflater inflater = LayoutInflater.from(context);
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.list_item, container, false);
        TextView tv = view.findViewById(textViews[0]);


        if(position<12) {
            for (int j = 0; j < 9; j++) {
                tv = view.findViewById(textViews[j]);
                tv.setText(ArSuras[(position * 9) + j]);


                final int finalJ = j;


                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, OpenSuras.class );
                        intent.putExtra("sura",(position*9)+finalJ+1);

                        context.startActivity(intent);
                    }
                });

            }
        }
        else if (position==12) {
            for(int j=108;j<114;j++){

                tv = view.findViewById(textViews[j - 108]);
                tv.setText(ArSuras[j]);

                final int finalJ = j;
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, OpenSuras.class);
                        intent.putExtra("sura",finalJ);
                        context.startActivity(intent);
                    }
                });
            }
            for (int i=114;i<117;i++){
                ImageView im1=view.findViewById(R.id.circle7);
                ImageView im2=view.findViewById(R.id.circle8);
                ImageView im3=view.findViewById(R.id.circle9);
                im1.setVisibility(view.INVISIBLE);
                im2.setVisibility(view.INVISIBLE);
                im3.setVisibility(view.INVISIBLE);
            }
        }


        container.addView(view);
        return view;
    }

    }



