package com.example.collageapp.ui.faculty;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.collageapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class faculty_fragment extends Fragment {


    private RecyclerView computerDepartment, mathematicsDepartment, physicsDepartment, chemistryDepartment, englishDepartment;
    private LinearLayout englishNoData, physicsNoData, chemistryNoData, computerNoData, mathematicsNoData;
    private List<teacherData> list1, list2, list3, list4, list5;
    private TeacherAdapter adapter;

    private DatabaseReference dbRef, reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faculty_fragment, container, false);
        chemistryDepartment = view.findViewById(R.id.chemistryDepartment);
        chemistryNoData = view.findViewById(R.id.chemistryNoData);
        physicsDepartment = view.findViewById(R.id.physicsDepartment);
        physicsNoData = view.findViewById(R.id.physicsNoData);
        mathematicsDepartment = view.findViewById(R.id.mathematicsDepartment);
        mathematicsNoData = view.findViewById(R.id.mathsNoData);
        englishDepartment = view.findViewById(R.id.englishDepartment);
        englishNoData = view.findViewById(R.id.englishNoData);
        computerDepartment = view.findViewById(R.id.computerDepartment);
        computerNoData = view.findViewById(R.id.computerNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("Teacher");
        computerD();
        physicsD();
        mathematicsD();
        chemistryD();
        englishD();
        return view;
    }

    private void englishD() {
        dbRef = reference.child("English");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list5 = new ArrayList<>();
                if (!snapshot.exists()) {
                    englishNoData.setVisibility(View.VISIBLE);
                    englishDepartment.setVisibility(View.GONE);
                } else {
                    englishNoData.setVisibility(View.GONE);
                    englishDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        teacherData data = dataSnapshot.getValue(teacherData.class);
                        list5.add(data);
                    }
                    englishDepartment.setHasFixedSize(true);
                    englishDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list5, getContext());
                    englishDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void chemistryD() {
        dbRef = reference.child("Chemistry");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4 = new ArrayList<>();
                if (!snapshot.exists()) {
                    chemistryNoData.setVisibility(View.VISIBLE);
                    chemistryDepartment.setVisibility(View.GONE);
                } else {
                    chemistryNoData.setVisibility(View.GONE);
                    chemistryDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        teacherData data = dataSnapshot.getValue(teacherData.class);
                        list4.add(data);
                    }
                    chemistryDepartment.setHasFixedSize(true);
                    chemistryDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list4, getContext());
                    chemistryDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void mathematicsD() {
        dbRef = reference.child("Mathematics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3 = new ArrayList<>();
                if (!snapshot.exists()) {
                    mathematicsNoData.setVisibility(View.VISIBLE);
                    mathematicsDepartment.setVisibility(View.GONE);
                } else {
                    mathematicsNoData.setVisibility(View.GONE);
                    mathematicsDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        teacherData data = dataSnapshot.getValue(teacherData.class);
                        list3.add(data);
                    }
                    mathematicsDepartment.setHasFixedSize(true);
                    mathematicsDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list3, getContext());
                    mathematicsDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void physicsD() {
        dbRef = reference.child("Physics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2 = new ArrayList<>();
                if (!snapshot.exists()) {
                    physicsNoData.setVisibility(View.VISIBLE);
                    physicsDepartment.setVisibility(View.GONE);
                } else {
                    physicsNoData.setVisibility(View.GONE);
                    physicsDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        teacherData data = dataSnapshot.getValue(teacherData.class);
                        list2.add(data);
                    }
                    physicsDepartment.setHasFixedSize(true);
                    physicsDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list2, getContext());
                    physicsDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void computerD() {
        dbRef = reference.child("Computer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1 = new ArrayList<>();
                if (!snapshot.exists()) {
                    computerNoData.setVisibility(View.VISIBLE);
                    computerDepartment.setVisibility(View.GONE);
                } else {
                    computerNoData.setVisibility(View.GONE);
                    computerDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        teacherData data = dataSnapshot.getValue(teacherData.class);
                        list1.add(data);
                    }
                    computerDepartment.setHasFixedSize(true);
                    computerDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list1, getContext());
                    computerDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}