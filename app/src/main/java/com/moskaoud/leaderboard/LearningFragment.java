package com.moskaoud.leaderboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.moskaoud.leaderboard.services.DataService;
import com.moskaoud.leaderboard.services.ServiceBuilder;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LearningFragment extends Fragment {
    private static final String URL = "https://gadsapi.herokuapp.com/api/hours";

    public LearningFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView mRecyclerView;
        final DataAdapter mAdapter;
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_learning, container, false);
        mRecyclerView = view.findViewById(R.id.recyclerview);

        DataService dataService = ServiceBuilder.buildService(DataService.class);
        Call<ArrayList<Data>> call = dataService.getHours(URL);
        call.enqueue(new Callback<ArrayList<Data>>() {
            @Override
            public void onResponse(Call<ArrayList<Data>> call, Response<ArrayList<Data>> response) {
                if (response.isSuccessful()) {
                    mRecyclerView.setAdapter(new DataAdapter(view.getContext(), response.body()));
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
                } else if (response.code() == 401) {
                    Toast.makeText(getContext(), "Session Expired", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Failed to retrieve items", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ArrayList<Data>> call, Throwable t) {
                if (t instanceof IOException) {
                    Toast.makeText(getActivity(), "Connection error ", Toast.LENGTH_LONG).show();
                } else
                    Toast.makeText(getActivity(), "Failed", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}