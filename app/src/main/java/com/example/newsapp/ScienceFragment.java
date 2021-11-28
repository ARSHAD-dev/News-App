package com.example.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScienceFragment extends Fragment implements NewsListener {

    String url = "7b02fdf4cdc740bc8a1e7277d94c908f";
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    String Country = "in";
    private RecyclerView recyclerViewofscience;
    private String catagory="science";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.science_fragment,null);

        recyclerViewofscience=v.findViewById(R.id.recyclerviewscience);
        modelClassArrayList = new ArrayList<>();
        recyclerViewofscience.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), modelClassArrayList, this);
        recyclerViewofscience.setAdapter(adapter);
        FindNews();

        return v;

    }

    public void FindNews() {
        ApiUtilites.getApiInterface().getCatagoryNews(Country,catagory,100,url).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                if (response.isSuccessful()) {
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {

            }
        });


    }

    @Override
    public void onNewsClicked(String url) {
        Intent intent = new Intent(requireContext(), WebviewActivity.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }
}


