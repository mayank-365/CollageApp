package com.example.collageapp.ebook;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collageapp.R;

import java.util.List;

public class ebookAdapter extends RecyclerView.Adapter<ebookAdapter.ebookViewHolder> {

    public ebookAdapter(Context context, List<ebookData> list) {
        this.context = context;
        this.list = list;
    }

    private Context context;
    private List<ebookData> list;

    @NonNull
    @Override
    public ebookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ebook_item_layout,parent,false);
        return new ebookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ebookViewHolder holder,int position) {
        holder.ebookname.setText(list.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(list.get(position).getPdfUrl()));
                context.startActivity(intent);
            }
        });

        holder.ebookdownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Download", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ebookViewHolder extends RecyclerView.ViewHolder {

        private TextView ebookname;
        private ImageView ebookdownload;

        public ebookViewHolder(@NonNull View itemView) {
            super(itemView);
            ebookname = itemView.findViewById(R.id.ebookname);
            ebookdownload = itemView.findViewById(R.id.ebookdownload);
        }
    }
}
