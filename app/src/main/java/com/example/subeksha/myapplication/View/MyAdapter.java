package com.example.subeksha.myapplication.View;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.subeksha.myapplication.R;
import com.example.subeksha.myapplication.model.Brand;
import com.example.subeksha.myapplication.presenter.TrekPresenter;

import java.util.ArrayList;

/**
 * Created by Subeksha on 2/27/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.RecyclerViewHolder> {
    ArrayList<Brand> arrayList = new ArrayList<Brand>();

    Context ctx;



    public MyAdapter(ArrayList<Brand> arrayList, Context ctx)
    {
        this.arrayList = arrayList;
        this.ctx= ctx;

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);

        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view, ctx, arrayList);

        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        Brand Brand = arrayList.get(position);

        holder.imageView.setImageResource(Brand.getB_image());
        holder.b_name.setText(Brand.getB_name());
    }

    @Override
    public int getItemCount() {

        return arrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView imageView;
        TextView b_name;
        TextView textView;
        ArrayList<Brand> arrayList = new ArrayList<Brand>();
        Context ctx;



        public RecyclerViewHolder(View view,  Context ctx, ArrayList<Brand> arrayList) {
            super(view);
            this.arrayList = arrayList;
            this.ctx = ctx;
            view.setOnClickListener(this);
            imageView = (ImageView) view.findViewById(R.id.img);
            b_name = (TextView) view.findViewById(R.id.b_name);
            textView = (TextView) view.findViewById(R.id.s_name);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Brand arrayList = this.arrayList.get(position);
            Intent intent = new Intent (this.ctx, TrekPresenter.class);
            intent.putExtra("img_id", arrayList.getImage_id());
            intent.putExtra("trial", arrayList.getTextView());
            intent.putExtra("try", arrayList.getB_name()
            );
            this.ctx.startActivity(intent);


        }
    }

    public void setFilter(ArrayList<Brand> newList)
    {
        arrayList = new ArrayList<>();
        arrayList.addAll(newList);
        notifyDataSetChanged();

    }

}



