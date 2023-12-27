package com.example.ecommerceapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.ecommerceapp.Adapter.BestDealAdapter;
import com.example.ecommerceapp.Adapter.CategoryAdapter;
import com.example.ecommerceapp.Domain.CategoryDomain;
import com.example.ecommerceapp.Domain.itemsDomain;
import com.example.ecommerceapp.R;

import java.util.ArrayList;

public class main_activity extends AppCompatActivity {
    Button ShopBtn ;

    private RecyclerView.Adapter catAdapter, bestDealAdapter;
    private RecyclerView recyclerViewCat, recyclerViewBestDeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ShopBtn = findViewById(R.id.ShopNowBtn);
        ShopBtn.setOnClickListener(V -> startActivity(new Intent(main_activity.this, DetailsActivity.class)));
        initrecyclerViewCat();
        initLocation();
        initrecyclerViewBestDeal();

    }

    private void initLocation() {

String[] items = new String[]{"LosAngles","USA","New york"};
final Spinner locationSpin = findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpin.setAdapter(adapter);
    }

    private void initrecyclerViewCat() {
        ArrayList<CategoryDomain> items = new ArrayList<>();
        items.add(new CategoryDomain("cat1", "Vegetable"));
        items.add(new CategoryDomain("cat2", "Fruits"));
        items.add(new CategoryDomain("cat3", "Dairy"));
        items.add(new CategoryDomain("cat4", "Drinks"));
        items.add(new CategoryDomain("cat5", "Grain"));

        recyclerViewCat = findViewById(R.id.catView);
        recyclerViewCat.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        catAdapter = new CategoryAdapter(items, this);
        recyclerViewCat.setAdapter(catAdapter);
    }
    public void initrecyclerViewBestDeal(){
        recyclerViewBestDeal = findViewById(R.id.best_deals);
        recyclerViewCat.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        bestDealAdapter = new BestDealAdapter(getData());
        recyclerViewBestDeal.setAdapter(bestDealAdapter);
    }
    public static ArrayList<itemsDomain> getData(){
        ArrayList<itemsDomain> items = new ArrayList<>();
        items.add(new itemsDomain("orange","Fresh orange",6.2,"An orange is a round citrus fruit with a bright orange peel and juicy " +
                "sweet flesh. It's known for its refreshing flavor and high vitamin C content,making it a " +
                "popular snack and ingredient in many dishes.",4.2));
        items.add(new itemsDomain("orange","Fresh orange",6.2,"An orange is a round citrus fruit with a bright orange peel and juicy " +
                "sweet flesh. It's known for its refreshing flavor and high vitamin C content,making it a " +
                "popular snack and ingredient in many dishes.",4.2));
        items.add(new itemsDomain("orange","Fresh orange",6.2,"An orange is a round citrus fruit with a bright orange peel and juicy " +
                "sweet flesh. It's known for its refreshing flavor and high vitamin C content,making it a " +
                "popular snack and ingredient in many dishes.",4.2));
        items.add(new itemsDomain("orange","Fresh orange",6.2,"An orange is a round citrus fruit with a bright orange peel and juicy " +
                "sweet flesh. It's known for its refreshing flavor and high vitamin C content,making it a " +
                "popular snack and ingredient in many dishes.",4.2));
        items.add(new itemsDomain("orange","Fresh orange",6.2,"An orange is a round citrus fruit with a bright orange peel and juicy " +
                "sweet flesh. It's known for its refreshing flavor and high vitamin C content,making it a " +
                "popular snack and ingredient in many dishes.",4.2));

return items;
    }
}

