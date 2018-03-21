package com.gapcoder.api.FG;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
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
 * Created by suxiaohui on 2018/3/20.
 */

public class F1Adapter extends RecyclerView.Adapter<F1Adapter.SnapViewHolder>{

    private List<F1Model.SubjectsBean> data;

    private Context context;

    public F1Adapter(List<F1Model.SubjectsBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public SnapViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.f1item, parent, false);
        final SnapViewHolder h = new SnapViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int p=h.getAdapterPosition();
                F1Model.SubjectsBean m=data.get(p);
                Intent i=new Intent(context,Movie.class);
                i.putExtra("id",m.getId());
                context.startActivity(i);
            }
        });
        return h;
    }

    @Override
    public void onBindViewHolder(SnapViewHolder h, int position) {
        F1Model.SubjectsBean m=data.get(position);
        h.title.setText(m.getTitle());
        h.score.setText("评分："+String.valueOf(m.getRating().getAverage()));
        Glide.with(context).load(m.getImages().getMedium()).placeholder(R.drawable.holder).into(h.iv);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class SnapViewHolder extends RecyclerView.ViewHolder {

        ImageView iv;
        TextView title;
        TextView score;
        public SnapViewHolder(View v) {
            super(v);
            iv=v.findViewById(R.id.iv);
            title=v.findViewById(R.id.title);
            score=v.findViewById(R.id.score);
        }
    }
}
