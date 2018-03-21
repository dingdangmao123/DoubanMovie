package com.gapcoder.api;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.gapcoder.api.Model.MovieModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class Movie extends AppCompatActivity {

    private int id;
    private ImageView iv;
    private TextView title;
    private TextView summary;
    private Toolbar t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        t=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(t);
        ActionBar ab=getSupportActionBar();
        if(ab!=null){
            ab.setDisplayHomeAsUpEnabled(true);
        }
        iv=(ImageView)findViewById(R.id.iv);
        title=(TextView)findViewById(R.id.title);
        summary=(TextView)findViewById(R.id.summary);
        String sid=getIntent().getStringExtra("id");
        id=Integer.parseInt(sid);
        get();
        Log.i("tag",String.valueOf(id));
    }

    void get(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.douban.com/v2/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Movie.Service ins=retrofit.create(Movie.Service.class);
        Call<MovieModel> m=ins.fetch(id);
        Log.i("url",m.request().url().toString());
        m.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                MovieModel m=response.body();
                if(m==null)
                    return ;

                Glide.with(Movie.this).load(m.getImages().getSmall()).into(iv);
                t.setTitle(m.getTitle());
                title.setText(m.getTitle());
                summary.setText(m.getSummary());
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {
                Toast.makeText(Movie.this,t.toString(),Toast.LENGTH_LONG).show();
            }
        });

    }

    public  interface Service {
        @GET("subject/{id}")
        Call<MovieModel> fetch(@Path("id") int id);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}
