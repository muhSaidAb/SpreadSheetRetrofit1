package com.kangzayd.spreadsheetretrofit.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.kangzayd.spreadsheetretrofit.R;
import com.kangzayd.spreadsheetretrofit.adapter.NamaAdapter;
import com.kangzayd.spreadsheetretrofit.model.Response;
import com.kangzayd.spreadsheetretrofit.networking.ApiCall;
import com.kangzayd.spreadsheetretrofit.networking.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;

public class Main2Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NamaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView =(RecyclerView)findViewById(R.id.recyclerNama);
        ApiInterface apiInterface = ApiCall.getClient().create(ApiInterface.class);
        Call<Response> responseCall = apiInterface.ambilData();
        responseCall.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.body().user.size() > 0) {
                    adapter=new NamaAdapter(response.body().user);//inisialisasi adapter
                    //setlayoutmanager
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(Main2Activity.this);
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    //setadapter
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Log.i("autolog", "t: " + t.getMessage());
            }
        });
    }
}
