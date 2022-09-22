package com.example.collageapp.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.collageapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class about_fragment extends Fragment {

    private ViewPager viewPager;
    private branchAdapter adapter;
    private List<branchModel> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about_fragment, container, false);

        list = new ArrayList<>();
        list.add(new branchModel(R.drawable.ic_computer,"Computer Science",getString(R.string.aboutcomputerscience)));
        list.add(new branchModel(R.drawable.ic_mechanical,"Mechanical",getString(R.string.aboutmechanical)));

        adapter = new branchAdapter(getContext(),list);

        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        ImageView imageView = view.findViewById(R.id.collage_Image);
        Picasso.get().load(getString(R.string.colgimg)).into(imageView);


        return view;
    }
}