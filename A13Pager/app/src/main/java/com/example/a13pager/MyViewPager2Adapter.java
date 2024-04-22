package com.example.a13pager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewPager2Adapter extends RecyclerView.Adapter<MyViewPager2Adapter.MyViewHolder>  {
    private String[] layouts;
    private int[] colorArray = new int[]{android.R.color.holo_orange_light, android.R.color.holo_green_light,
            android.R.color.holo_blue_light};

    // Constructor of our ViewPager2Adapter class
    MyViewPager2Adapter(String[] layouts) {
        this.layouts = layouts;
    }

    // This method returns our layout
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single, parent, false);
        return new MyViewHolder(view);
    }

    // This method binds the screen with the view
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //// HERE
        holder.textview.setText(layouts[position]);
        holder.constraintlayout.setBackgroundResource(colorArray[position]);
    }

    @Override
    public int getItemViewType(int position) {
        return colorArray[position];
    }

    // This Method returns the size of the Array
    @Override
    public int getItemCount() {
        return layouts.length;
    }

    // The ViewHolder class holds the view
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textview;
        Button button;
        ConstraintLayout constraintlayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textview = itemView.findViewById(R.id.textview);
            button = itemView.findViewById(R.id.button);
            constraintlayout = itemView.findViewById(R.id.constraintlayout);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textview.setTextSize(textview.getTextSize() + 0.1f);
                }
            });
        }
    }
}
