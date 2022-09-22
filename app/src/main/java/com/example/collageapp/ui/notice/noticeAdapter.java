package com.example.collageapp.ui.notice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.collageapp.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class noticeAdapter extends RecyclerView.Adapter<noticeAdapter.noticeViewAdapter> {

    private Context context;
    private ArrayList<NoticeData> list;

    public noticeAdapter(Context context, ArrayList<NoticeData> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public noticeViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.newsfeeditem, parent, false);
        return new noticeViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull noticeViewAdapter holder, int position) {
        NoticeData currentItem = list.get(position);
        holder.deleteNoticeTitle.setText(currentItem.getTitle());
        holder.date.setText(currentItem.getDate());
        holder.time.setText(currentItem.getTime());
        try {
            if (currentItem.getImage() != null)
                Picasso.get().load(currentItem.getImage()).into(holder.deleteNoticeImage);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class noticeViewAdapter extends RecyclerView.ViewHolder {

        private TextView deleteNoticeTitle, date, time;
        private ImageView deleteNoticeImage;

        public noticeViewAdapter(@NonNull View itemView) {
            super(itemView);

            deleteNoticeTitle = itemView.findViewById(R.id.deleteNoticeTitle);
            deleteNoticeImage = itemView.findViewById(R.id.deleteNoticeImage);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);

        }
    }
}
