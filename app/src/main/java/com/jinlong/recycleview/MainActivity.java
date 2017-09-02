package com.jinlong.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * ItemTouchHelper实现RecycleView拖拽
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> mList;
    private ItemTouchHelper mItemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initData() {
        mList = new ArrayList<>();
        mList.add("Java0");
        mList.add("Java1");
        mList.add("Java2");
        mList.add("Java3");
        mList.add("Java4");
        mList.add("Java5");
        mList.add("Java6");
        mList.add("Java7");
        mList.add("Java8");
        mList.add("Java9");
        mList.add("Java10");
        mList.add("Java11");
        mList.add("Java12");
        mList.add("Java13");
        mList.add("Java14");
        mList.add("Java15");
        mList.add("Java16");
        mList.add("Java17");
        mList.add("Java18");
        mList.add("Java19");
        mList.add("Java20");
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ItemAdapter itemAdapter = new ItemAdapter(this, mList);
        mRecyclerView.setAdapter(itemAdapter);

        /*设置ItemTouchHelper*/
        mItemTouchHelper = new ItemTouchHelper(new MyCallBack(itemAdapter, itemAdapter));
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
    }
}
