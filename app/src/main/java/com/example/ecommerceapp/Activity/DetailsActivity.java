package com.example.ecommerceapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle ;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ecommerceapp.Adapter.BestDealAdapter;
import com.example.ecommerceapp.Adapter.SimilarAdapter;
import com.example.ecommerceapp.Domain.itemsDomain;
import com.example.ecommerceapp.R ;

public class DetailsActivity extends AppCompatActivity{
private itemsDomain object ;
private ImageView backBtn , itemImg ;
private TextView pricingTxt , titleTxt , descriptionTxt , ratingTxt ;
private RatingBar ratingBar ;
private TextView weightTxt , plusBtn , minusBtn , totalTxt ;
private int weight = 1;
private RecyclerView.Adapter similarAdapter ;
private RecyclerView recyclerViewSimilar;

@Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_details);
    getBundels();
    initView();
    setVariable();
    initSimilar();
}

    private void initSimilar() {
        recyclerViewSimilar = findViewById(R.id.best_deals);
        recyclerViewSimilar.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Assuming you have a method in main_activity to get data
        similarAdapter = new SimilarAdapter((main_activity.getData()), this);
        recyclerViewSimilar.setAdapter(similarAdapter);
    }

    private void setVariable() {
    backBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    });
        int drawableResourceId = getResources().getIdentifier(object.getImgPath(), "drawable", getPackageName());
        Glide.with(DetailsActivity.this)
                .load(drawableResourceId)
                .into(itemImg);
        pricingTxt.setText(object.getPrice()+"$/kg");
        totalTxt.setText(object.getDescription());
        ratingTxt.setText("("+object.getRate()+")");
        ratingBar.setRating((float) object.getRate());
        totalTxt.setText((weight*object.getPrice())+"$");
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight = weight +1 ;
                weightTxt.setText(weight+"kg");
                totalTxt.setText(weight*object.getPrice()+"$");

            }
        });
plusBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(weight>1){
            weight=weight+1;
            weightTxt.setText(weight+"kg");
            totalTxt.setText((weight*object.getPrice()+"$"));
        }
    }
});
       minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(weight>1){
                    weight=weight-1;
                    weightTxt.setText(weight+"kg");
                    totalTxt.setText((weight*object.getPrice()+"$"));
                }
            }
        });


    }

    private void initView() {
    backBtn = findViewById(R.id.Backbtn);
    itemImg = findViewById(R.id.img);
    pricingTxt=findViewById(R.id.priceKg);
    titleTxt = findViewById(R.id.Titletxt);
    descriptionTxt = findViewById(R.id.Desciption);
    ratingBar = findViewById(R.id.ratingBar);
    ratingTxt = findViewById(R.id.ratinttxt);
    weightTxt = findViewById(R.id.weightText);
    plusBtn = findViewById(R.id.PlusButton);
    minusBtn = findViewById(R.id.moinsButton);
    totalTxt = findViewById(R.id.Total);



    }

    private void getBundels() {
    object = (itemsDomain) getIntent().getSerializableExtra("object");

    }
}
