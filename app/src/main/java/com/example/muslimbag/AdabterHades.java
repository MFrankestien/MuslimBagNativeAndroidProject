package com.example.muslimbag;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class AdabterHades extends RecyclerView.Adapter<AdabterHades.ViewHolder> {

    String[] arr = {"الأول","الثانى","الثالث", "الرابع", "الخامس","السادس","السابع","الثامن","التاسع","العاشر"
            ,"الحادى عشر","الثانى عشر","الثالث عشر", "الرابع عشر", "الخامس عشر","السادس عشر","السابع عشر","الثامن عشر","التاسع عشر",
            "العشرون"," الحادى وعشرون" ,"الثانى وعشرون","الثالث وعشرون", "الرابع وعشرون", "الخامس وعشرون","السادس وعشرون","السابع وعشرون","الثامن وعشرون","التاسع وعشرون",
            "الثلاثون","الحادى والثلاثون","الثانى والثلاثون","الثالث والثلاثون", "الرابع والثلاثون", "الخامس والثلاثون","السادس والثلاثون","السابع والثلاثون","الثامن والثلاثون","التاسع والثلاثون","الأربعون" ,"h"};    Context context;
    View view;
    public AdabterHades(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.hades_list_rv,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.textView.setText("الحديث "+arr[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,ThirdActivity2.class);
                intent.putExtra("hades_num",position+1);
                intent.putExtra("hades_name",arr[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arr.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.icon_content);
        }
    }
}
