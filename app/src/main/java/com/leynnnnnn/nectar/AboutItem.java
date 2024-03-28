package com.leynnnnnn.nectar;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AboutItem extends AppCompatActivity {
    ImageView image;
    TextView name, quantity, price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_about_item);

        image = findViewById(R.id.itemImageInfo);
        name = findViewById(R.id.itemNameInfo);
        quantity = findViewById(R.id.itemQuantityInfo);
        price = findViewById(R.id.itemPriceInfo);

        ItemInfo itemInfo = getIntent().getParcelableExtra("itemInfo");
        assert itemInfo != null;
        Log.d("message", itemInfo.getItemName());
        image.setImageResource(itemInfo.getItemImage());
        name.setText(itemInfo.getItemName());
        quantity.setText(String.valueOf(itemInfo.getItemPieces()).concat(" pieces"));
        price.setText("$".concat(String.valueOf(itemInfo.getItemPrice())));


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}