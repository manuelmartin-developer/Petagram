package manuelmartin.petagram.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class PageAdapter extends FragmentPagerAdapter {

    // Declaración de variables y objetos
    private ArrayList<Fragment> fragments;

    public PageAdapter(@NonNull FragmentManager fm,ArrayList<Fragment> fragments, int behavior) {
        super(fm, behavior);
        this.fragments=fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
