package com.gapcoder.api.Fragment;

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

public class F2 extends Fragment{

    RecyclerView tl;
    F2Adapter adapter;
    RefreshLayout rf;
    List<F2Model.SubjectsBean> data=new LinkedList<>();



    public F2(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_f2, container, false);
        rf=(RefreshLayout) v.findViewById(R.id.refreshLayout);
        tl=(RecyclerView)v.findViewById(R.id.timeline);
        adapter = new F2Adapter(data, getActivity());
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
        F2.Service ins=retrofit.create(F2.Service.class);
        Call<F2Model> m=ins.fetch();
        Log.i("tag",m.request().url().toString());
        m.enqueue(new Callback<F2Model>() {
            @Override
            public void onResponse(Call<F2Model> call, Response<F2Model> response) {
                F2Model m=response.body();
                rf.finishRefresh();
                if(m==null)
                    return ;
                data.clear();
                data.addAll(m.getSubjects());
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<F2Model> call, Throwable t) {
                Log.i("tag",t.toString());
                rf.finishRefresh(false);
            }
        });

    }

    public  interface Service {
        @GET("coming_soon")
        Call<F2Model> fetch();
    }
}
