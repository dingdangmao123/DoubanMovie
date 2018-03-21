package com.gapcoder.api.FG;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gapcoder.api.Movie;
import com.gapcoder.api.R;

import java.util.List;

/**
 * Created by suxiaohui on 2018/3/21.
 */

public class F3Adapter  extends RecyclerView.Adapter<F3Adapter.SnapViewHolder>{

    private List<F3Model.SubjectsBean> data;

    private Context context;

    public F3Adapter(List<F3Model.SubjectsBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public F3Adapter.SnapViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.f3item, parent, false);
        final F3Adapter.SnapViewHolder h = new F3Adapter.SnapViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int p=h.getAdapterPosition();
                F3Model.SubjectsBean m=data.get(p);
                Intent i=new Intent(context,Movie.class);
                i.putExtra("id",m.getId());
                Log.i("tag",m.getId());
                context.startActivity(i);
            }
        });
        return h;
    }

    @Override
    public void onBindViewHolder(F3Adapter.SnapViewHolder h, int position) {
        F3Model.SubjectsBean m=data.get(position);
        h.title.setText(m.getTitle());
        h.rating.setText(String.valueOf(m.getRating().getAverage()));
        h.about.setText(String.valueOf(m.getGenres()));
        Log.i("tag",m.getTitle());
        Glide.with(context).load(m.getImages().getSmall()).placeholder(R.drawable.holder).into(h.iv);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class SnapViewHolder extends RecyclerView.ViewHolder {

        ImageView iv;
        TextView title;
        TextView rating;
        TextView about;

        public SnapViewHolder(View v) {
            super(v);
            iv=v.findViewById(R.id.iv);
            title=v.findViewById(R.id.title);
            rating=v.findViewById(R.id.rating);
            about=v.findViewById(R.id.about);
        }
    }
}

