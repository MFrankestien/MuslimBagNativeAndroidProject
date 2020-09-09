package com.example.muslimbag.Quraan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muslimbag.R;

import java.util.ArrayList;

public class OpenSurasAdapter extends RecyclerView.Adapter<OpenSurasAdapter.ViewHolder> {

    OpenSuras openSuras= new OpenSuras();


    ArrayList<String> items=new ArrayList<>();




    public OpenSurasAdapter(ArrayList<String> items){
        this.items = items;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sora_rv_design, parent, false);


        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.TV_suras.setText(items.get(position));

    }






    @Override
    public int getItemCount() {
        return items.size();
    }








    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView TV_suras;
        View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            TV_suras=itemView.findViewById(R.id.TV_suras);

        }
    }
}
