package com.example.android.recyclerviewgridlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> dataList;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.practiceRecyclerView);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, 1));
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));

        dataList = populateList(500);
    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerAdapter = new RecyclerViewAdapter(dataList);
        recyclerView.setAdapter(recyclerAdapter);
    }

    private ArrayList<String> populateList(int count) {

        ArrayList<String> returnList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            returnList.add(getString(R.string.lorem_ipsum));
        }

        return returnList;
    }
}
