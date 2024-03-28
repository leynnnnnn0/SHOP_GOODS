package com.leynnnnnn.nectar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class Cart extends Fragment {

    CartDbHelper db;
    RecyclerView recyclerView;
    List<ItemInfo> items;
    ItemInfo[] cartItems;
    CartAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this
        View rootView = inflater.inflate(R.layout.fragment_cart, container, false);
         db = new CartDbHelper(requireContext());
        items = db.getAllItems();
        cartItems = items.toArray(new ItemInfo[0]);
        recyclerView = rootView.findViewById(R.id.cartRecyclerView);
        adapter = new CartAdapter(getContext(), cartItems);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



        return rootView;
    }
}