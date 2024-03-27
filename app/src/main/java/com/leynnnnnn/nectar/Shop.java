package com.leynnnnnn.nectar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
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


        return rootView;
    }
}