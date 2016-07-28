package com.example.jenong.cafeapp.View;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jenong.cafeapp.Model.Datum;
import com.example.jenong.cafeapp.R;
import com.example.jenong.cafeapp.Model.Datum;
//import com.example.jenong.cafeapp.View.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.RootObjectViewHolder> {

    private List<Datum> ResultList;
    public OnClickItem itemClick;
    public final static String KEY_MEMBER = "keymember";
    Context c;

    public MyAdapter(OnClickItem itemClick) {
        this.itemClick = itemClick;
        ResultList = new ArrayList<>();
    }

    public interface OnClickItem {
        public void OnClick(Datum result);
    }

    public MyAdapter() {
        ResultList = new ArrayList<>();
    }
//    private void add(RootObject item) {
//        ResultList.add(item);
//        notifyItemInserted(ResultList.size() - 1);
//    }

    public void addAll(List<Datum> r) {
        //  ResultList.removeAll(r);
        ResultList.addAll(r);
    }

    public void removeAll(List<Datum> r) {
        ResultList.clear();
//        ResultList.removeAll(r);
    }

    public Datum getItem(int position) {
        return ResultList.get(position);
    }

    @Override
    public RootObjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview, parent, false);
        RootObjectViewHolder rootObjectViewHolder = new RootObjectViewHolder(view);
        c = parent.getContext();
        return rootObjectViewHolder;
    }

    @Override
    public void onBindViewHolder(RootObjectViewHolder holder, int position) {
        final Datum object = ResultList.get(position);
        Picasso.with(c).load(object.getUrl_foto()).into(holder.ResultImage);
        holder.namaCafe.setText(object.getNama());
        holder.alamatCafe.setText(object.getAlamat());
        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                itemClick.OnClick(RootObject);
                Intent pindah = new Intent(c, DetailActivity.class);
                pindah.putExtra(DetailActivity.KEY_MEMBER,object);
                c.startActivity(pindah);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ResultList.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    static class RootObjectViewHolder extends RecyclerView.ViewHolder {

        ImageView ResultImage;
        TextView namaCafe;
        TextView alamatCafe;
        View v;

        public RootObjectViewHolder(View itemView) {
            super(itemView);
            v = itemView;
            ResultImage = (ImageView) itemView.findViewById(R.id.imageDepan);
            namaCafe = (TextView) itemView.findViewById(R.id.text_card_name);
            alamatCafe = (TextView) itemView.findViewById(R.id.text_card_address);
//        }
        }
    }
}