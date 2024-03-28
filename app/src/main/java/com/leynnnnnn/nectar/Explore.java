package com.leynnnnnn.nectar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
public class Explore extends Fragment {
    CategoryModel[] categories;
    CategoriesAdapter adapter;
    RecyclerView categoriesRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_explore, container, false);

        categories = new CategoryModel[] {
                new CategoryModel(R.drawable.healthy, "Fresh Fruits \n& Vegetables"),
                new CategoryModel(R.drawable.meats, "Meat \n& Fish"),
                new CategoryModel(R.drawable.beverages, "Beverages"),
        };
        adapter = new CategoriesAdapter(getContext(), categories);
        categoriesRecyclerView = rootView.findViewById(R.id.categoriesRecyclerView);

        categoriesRecyclerView.setHasFixedSize(true);
        categoriesRecyclerView.setAdapter(adapter);
        categoriesRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));





        return rootView;
    }
}