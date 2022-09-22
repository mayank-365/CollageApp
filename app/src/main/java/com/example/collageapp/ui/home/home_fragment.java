package com.example.collageapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.collageapp.R;

import java.util.ArrayList;

public class home_fragment extends Fragment {

    private ImageView map;
    private ImageSlider imageSlider;
    private ArrayList<SlideModel> list = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_fragment,container,false);

        map = view.findViewById(R.id.map);
        imageSlider = view.findViewById(R.id.slider);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openmap();
            }
        });
        setSliderView();
        return view;
    }

    private void openmap() {
        Uri uri = Uri.parse("geo:0,0?q=Motilal Nehru National Institute of Technology");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    private void setSliderView() {

        list.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/mnnit-4581c.appspot.com/o/gallery%2F%5BB%40e4262edjpg?alt=media&token=90e78954-736f-4fcb-8e0b-9a9de927120c"));
        list.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/mnnit-4581c.appspot.com/o/gallery%2F%5BB%404eef89fjpg?alt=media&token=e9d07768-77ba-4575-bfb3-2c2605d0c26c"));
        list.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/mnnit-4581c.appspot.com/o/gallery%2F%5BB%40ac71303jpg?alt=media&token=75828440-dbee-4eaf-ae4c-4789cab5efd4"));
        list.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/mnnit-4581c.appspot.com/o/gallery%2F%5BB%40cf45327jpg?alt=media&token=7b87ebaf-db86-4d97-a980-9f9de5d27467"));
        list.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/mnnit-4581c.appspot.com/o/gallery%2F%5BB%406afb782jpg?alt=media&token=cf13acc4-1741-4d7e-b9e6-19a8390041aa"));
        imageSlider.setImageList(list, true);
    }
}