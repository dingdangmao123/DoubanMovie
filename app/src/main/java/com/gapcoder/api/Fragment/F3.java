package com.gapcoder.api.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gapcoder.api.FG.F2Adapter;
import com.gapcoder.api.FG.F2Model;
import com.gapcoder.api.FG.F3Adapter;
import com.gapcoder.api.FG.F3Model;
import com.gapcoder.api.R;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class F3 extends Fragment{


    RecyclerView tl;
    F3Adapter adapter;
    RefreshLayout rf;
    List<F3Model.SubjectsBean> data=new LinkedList<>();



    public F3(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_f3, container, false);
        rf=(RefreshLayout) v.findViewById(R.id.refreshLayout);
        tl=(RecyclerView)v.findViewById(R.id.timeline);
        adapter = new F3Adapter(data, getActivity());
        tl.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        tl.setAdapter(adapter);
        rf.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                get();
            }
        });
        return v;
    }
    
    private void get(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        F3.Service ins=retrofit.create(F3.Service.class);
        Call<F3Model> m=ins.fetch();
        Log.i("tag",m.request().url().toString());
        m.enqueue(new Callback<F3Model>() {
            @Override
            public void onResponse(Call<F3Model> call, Response<F3Model> response) {
                F3Model m=response.body();
                rf.finishRefresh();
                if(m==null)
                    return ;
                data.clear();
                data.addAll(m.getSubjects());
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<F3Model> call, Throwable t) {
                Log.i("tag",t.toString());
                rf.finishRefresh(false);
            }
        });

    }

    public  interface Service {
        @GET("top250")
        Call<F3Model> fetch();
    }
}