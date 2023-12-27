package com.example.ecommerceapp.Adapter;


import android.content.Context;
import android.content.Intent;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecommerceapp.Activity.DetailsActivity;
import com.example.ecommerceapp.Domain.itemsDomain;
import com.example.ecommerceapp.R;

import java.util.ArrayList;

public class BestDealAdapter extends RecyclerView.Adapter<BestDealAdapter.viewholder> {
    ArrayList<itemsDomain> items;
    Context context ;

    public BestDealAdapter(ArrayList<itemsDomain>items){
        this.items = items ;
    }
    @NonNull
    @Override
    public BestDealAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_best_deal,parent,false);
        return new BestDealAdapter.viewholder(inflate);

    }

    @Override
    public void onBindViewHolder(@NonNull BestDealAdapter.viewholder holder, int position) {
        holder.titleT.setText(items.get(position).getTitle());
        holder.priceTxt.setText(items.get(position).getPrice()+"$/Kg");
        int drawableRessourceId = holder.itemView.getResources()
                .getIdentifier(items.get(position).getImgPath(),"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(context)
         .load(drawableRessourceId)
         .into(holder.pic);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("object", items.get(position));
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
TextView titleT , priceTxt ;
ImageView pic ;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            titleT = itemView.findViewById(R.id.Titletxt);
            pic = itemView.findViewById(R.id.price);


        }
    }
}
