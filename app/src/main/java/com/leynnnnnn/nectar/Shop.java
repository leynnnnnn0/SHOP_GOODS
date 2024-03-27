package com.leynnnnnn.nectar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bdtopcoder.smart_slider.SliderAdapter;
import com.bdtopcoder.smart_slider.SliderItem;

import java.util.ArrayList;
import java.util.List;

public class Shop extends Fragment {
    ViewPager2 viewPager2;
    List<SliderItem> sliderItems;
    RecyclerView exlusiveOffersRecyclerView, bestSellingRecyclerView;
    ItemsAdapter adapter, bAdapter;
    ItemInfo[] items;
    ItemInfo[] bestSelling;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_shop, container, false);

        // Initialize ViewPager2 and sliderItems
        viewPager2 = rootView.findViewById(R.id.smartSlider);
        sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.banner, "image 1"));
        sliderItems.add(new SliderItem(R.drawable.banner, "Image 2"));
        sliderItems.add(new SliderItem(R.drawable.banner, "Image 3"));

        // Set up ViewPager2 with SliderAdapter
        viewPager2.setAdapter(new SliderAdapter(sliderItems, viewPager2, 5000));

        items = new ItemInfo[] {
              new ItemInfo(R.drawable.apple, "Red Apple", 1, 4.99),
                new ItemInfo(R.drawable.dunno, "Bawang", 1, 2.54),
                new ItemInfo(R.drawable.chicken, "Chicken", 1, 12.34),
        };

        exlusiveOffersRecyclerView = rootView.findViewById(R.id.exclusiveOfferRecyclerView);
        adapter = new ItemsAdapter(rootView.getContext(), items);
        exlusiveOffersRecyclerView.setHasFixedSize(true);
        exlusiveOffersRecyclerView.setAdapter(adapter);
        exlusiveOffersRecyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.HORIZONTAL, false));

        bestSelling = new ItemInfo[] {
               new ItemInfo(R.drawable.coke, "Coke", 1, 12.43),
                new ItemInfo(R.drawable.mayo, "Mayonnaise", 1, 34.42),
                new ItemInfo(R.drawable.noodle, "Nudes", 1, 12.32)

        };
        bAdapter = new ItemsAdapter(rootView.getContext(), bestSelling);
        bestSellingRecyclerView = rootView.findViewById(R.id.bestSellingRecyclerView);
        bestSellingRecyclerView.setAdapter(bAdapter);
        bestSellingRecyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        bestSellingRecyclerView.setHasFixedSize(true);


        return rootView;
    }
}