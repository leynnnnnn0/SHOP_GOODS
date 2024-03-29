package com.leynnnnnn.nectar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

public class Cart extends Fragment implements CartInterface {

    CartDbHelper db;
    RecyclerView recyclerView;
    List<ItemInfo> items;
    ItemInfo[] cartItems;
    CartAdapter adapter;
    ImageView removeIcon;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this
        View rootView = inflater.inflate(R.layout.fragment_cart, container, false);
         db = new CartDbHelper(requireContext());
        items = db.getAllItems();
        cartItems = items.toArray(new ItemInfo[0]);
        recyclerView = rootView.findViewById(R.id.cartRecyclerView);
        adapter = new CartAdapter(getContext(), cartItems, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        // Inflate the main layout that includes cart_box
        View mainLayout = inflater.inflate(R.layout.cart_box, container, false);

        // Find testButton within cart_box
        removeIcon = mainLayout.findViewById(R.id.removeIconButton);
        removeIcon.setOnClickListener(v -> {
            Log.d("message", "working");
        });


        removeIcon.setOnClickListener(v -> {
            // Determine the position of the item associated with the clicked remove icon
//            int position = recyclerView.getChildLayoutPosition((View) v.getParent().getParent());
//            Toast.makeText(getContext(), "test " + position, Toast.LENGTH_SHORT).show();
            Toast.makeText(getContext(), "this", Toast.LENGTH_SHORT).show();
//            // Remove the item from the database
//            ItemInfo removedItem = cartItems[position];
//            db.removeFromCart(removedItem.getName()); // Assuming removeFromCart method exists in CartDbHelper
//
//            // Update the dataset by removing the item from the list
//            items.remove(position);
//            cartItems = items.toArray(new ItemInfo[0]);
//
//            // Notify the adapter about the change
//            adapter.notifyDataSetChanged();
        });



        return rootView;
    }

    @Override
    public void onItemClick(int pos) {


    }
}