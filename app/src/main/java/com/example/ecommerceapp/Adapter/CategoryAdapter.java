package com.example.ecommerceapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecommerceapp.Activity.main_activity;
import com.example.ecommerceapp.Domain.CategoryDomain;
import com.example.ecommerceapp.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.viewholder> {
    ArrayList<CategoryDomain> items;
    Context context ;

    public CategoryAdapter(ArrayList<CategoryDomain> items, main_activity mainActivity) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_category,parent,false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.viewholder holder, int position) {
        holder.titleT.setText(items.get(position).getTitle());
        int drawableRessourceId = holder.itemView.getResources()
                .getIdentifier(items.get(position).getImParg(),"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(context)
                .load(drawableRessourceId)
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {

        return items.size();
    }

    public class viewholder extends  RecyclerView.ViewHolder{
        TextView titleT ;
        ImageView pic ;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            titleT = itemView.findViewById(R.id.Titletxt);
            pic = itemView.findViewById(R.id.img);


        }
    }
}
