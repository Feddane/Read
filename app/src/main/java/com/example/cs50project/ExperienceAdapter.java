package com.example.cs50project;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ExperienceAdapter extends RecyclerView.Adapter<ExperienceAdapter.ViewHolder> {

    private static final String TAG = "ExperienceAdapter";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImageUrls = new ArrayList<Integer>();
    private Context mContext;

    public ExperienceAdapter(Context mContext, ArrayList<String> mNames, ArrayList<Integer> mImageUrls) {
        this.mNames = mNames;
        this.mImageUrls = mImageUrls;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.reactions,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(mImageUrls.get(holder.getAdapterPosition()))
                .into(holder.im);

        holder.name.setText(mNames.get(holder.getAdapterPosition()));

        holder.im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on an image: " + mNames.get(holder.getAdapterPosition()));
                Toast.makeText(mContext, mNames.get(holder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{

        ImageView im;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            im = itemView.findViewById(R.id.im);
            name = itemView.findViewById(R.id.name);
        }
    }
}
