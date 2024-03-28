package com.leynnnnnn.nectar;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class AboutItem extends AppCompatActivity {
    ImageView image;
    TextView name, quantity, price;
    Button addToBasket;
    CartDbHelper db = new CartDbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_about_item);

        image = findViewById(R.id.itemImageInfo);
        name = findViewById(R.id.itemNameInfo);
        quantity = findViewById(R.id.itemQuantityInfo);
        price = findViewById(R.id.itemPriceInfo);
        addToBasket = findViewById(R.id.addToBasket);



        ItemInfo itemInfo = getIntent().getParcelableExtra("itemInfo");

        assert itemInfo != null;
        addToBasket.setOnClickListener(v -> {
            boolean isExisting = db.getCartItems(itemInfo.getItemName());
            if(!isExisting) {
                boolean res = addCartItem(itemInfo);
                if(res) {
                    Toast.makeText(AboutItem.this, "Added.", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(AboutItem.this, "Not added.", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(AboutItem.this, "Quantity Updated.", Toast.LENGTH_SHORT).show();
        });

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

    public boolean addCartItem(ItemInfo itemInfo) {
        return db.addItem(itemInfo.getItemImage(), itemInfo.getItemName(), itemInfo.getItemPieces(), itemInfo.getItemPrice());
    }



}