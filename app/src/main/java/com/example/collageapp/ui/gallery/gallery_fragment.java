package com.example.collageapp.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.RecoverySystem;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.collageapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class gallery_fragment extends Fragment {

    RecyclerView convorecyler,otherrecycler;
    galleryAdapter adapter;

    DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery_fragment, container, false);

        convorecyler = view.findViewById(R.id.convorecyler);
        otherrecycler = view.findViewById(R.id.otherrecycler);

        reference = FirebaseDatabase.getInstance().getReference().child("gallery");

        getConvoImage();
        getOtherImage();

        return view;
    }

    private void getOtherImage() {
        reference.child("Other Events").addValueEventListener(new ValueEventListener() {
            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1:snapshot.getChildren()){
                    String data = snapshot1.getValue().toString();
                    imageList.add(data);
                }

                adapter = new galleryAdapter(getContext(),imageList);
                otherrecycler.setLayoutManager(new GridLayoutManager(getContext(),2));
                otherrecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getConvoImage() {
        reference.child("Convocation").addValueEventListener(new ValueEventListener() {
            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1:snapshot.getChildren()){
                    String data = snapshot1.getValue().toString();
                    imageList.add(data);
                }

                adapter = new galleryAdapter(getContext(),imageList);
                convorecyler.setLayoutManager(new GridLayoutManager(getContext(),2));
                convorecyler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}