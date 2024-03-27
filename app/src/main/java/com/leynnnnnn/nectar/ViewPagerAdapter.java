package com.leynnnnnn.nectar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new Shop();
            case 1:
                return new Explore();
            case 2:
                return new Cart();
            default:
                return new Shop();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
