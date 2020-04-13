package com.example.study;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class temp_shop_list extends AppCompatActivity implements View.OnClickListener{

    CardView card_goods1;
    CardView card_goods2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_shop_list);
        findViewById(R.id.shop_goods1).setOnClickListener(this);
        card_goods1 = findViewById(R.id.shop_goods1);
        findViewById(R.id.shop_goods2).setOnClickListener(this);
        card_goods2 = findViewById(R.id.shop_goods2);
    }

    public void onClick(View view) {
        //点击商品一卡片
        if(view.getId() == R.id.shop_goods1){
            Intent intent = new Intent(temp_shop_list.this, SingleGoods1.class);
            startActivity(intent);
        }

        //点击商品二卡片
        if(view.getId() == R.id.shop_goods2){
            Intent intent = new Intent(temp_shop_list.this, SingleGoods2.class);
            startActivity(intent);
        }
    }
}
