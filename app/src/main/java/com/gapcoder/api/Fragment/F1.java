package com.gapcoder.api.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gapcoder.api.FG.F1Adapter;
import com.gapcoder.api.FG.F1Model;
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


public class F1 extends Fragment{

    RecyclerView tl;
    F1Adapter adapter;
    RefreshLayout rf;
    List<F1Model.SubjectsBean> data=new LinkedList<>();

    public F1() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_f1, container, false);
        rf=(RefreshLayout) v.findViewById(R.id.refreshLayout);
        tl=(RecyclerView)v.findViewById(R.id.timeline);
        adapter = new F1Adapter(data, getActivity());
        tl.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        tl.setAdapter(adapter);
        rf.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                get();
            }
        });
        rf.autoRefresh();
        return v;
    }
    private void get(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Service ins=retrofit.create(Service.class);
        Call<F1Model> m=ins.fetch();
        m.enqueue(new Callback<F1Model>() {
            @Override
            public void onResponse(Call<F1Model> call, Response<F1Model> response) {
                F1Model m=response.body();
                rf.finishRefresh();
                if(m==null)
                    return ;
                data.clear();
                data.addAll(m.getSubjects());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<F1Model> call, Throwable t) {
                rf.finishRefresh(false);
            }
        });
    }
    public  interface Service {
        @GET("in_theaters")
        Call<F1Model> fetch();
    }
}
