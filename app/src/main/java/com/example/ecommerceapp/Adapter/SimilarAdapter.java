package com.example.ecommerceapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecommerceapp.Domain.itemsDomain;
import com.example.ecommerceapp.R;

import java.util.ArrayList;

public class SimilarAdapter extends RecyclerView.Adapter<SimilarAdapter.viewholder> {
    ArrayList<itemsDomain>items;
    Context context ;

    public SimilarAdapter(ArrayList<itemsDomain> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public SimilarAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholdersimilar , parent, false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull SimilarAdapter.viewholder holder, int position) {
        int drawableResource = holder.itemView.getResources().getIdentifier(
                items.get(position).getImgPath(),
                "drawable",
                holder.itemView.getContext().getPackageName()
        );

        Glide.with(context)
                .load(drawableResource)
                .into(holder.pic);
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView pic;
        public viewholder(@NonNull View itemView){
            super(itemView);
            pic = itemView.findViewById(R.id.img);
        }

    }
}
