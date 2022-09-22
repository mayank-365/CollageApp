package com.example.collageapp.ui.about;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.collageapp.R;

import java.util.List;

public class branchAdapter extends PagerAdapter {
    private Context context;
    private List<branchModel> list;

    public branchAdapter(Context context, List<branchModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.branch_item_layout,container,false);
        ImageView branchicon;
        TextView branchtitle,branchdescription;
        branchicon = view.findViewById(R.id.branchicon);
        branchtitle = view.findViewById(R.id.branchtitle);
        branchdescription = view.findViewById(R.id.branchdiscription);

        branchicon.setImageResource(list.get(position).getImg());

        branchtitle.setText(list.get(position).getTitle());
        branchdescription.setText(list.get(position).getDescription());

        container.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
