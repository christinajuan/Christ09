package com.example.user.christ09;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private SimpleAdapter adapter;
    private LinkedList<HashMap<String,Object>> data;         // 資料集
    private String[] from = {"title", "content", "img"};
    private int[] to = {R.id.item_tv, R.id.item_content, R.id.item_img};
    private int[] imgs = {R.drawable.star0,R.drawable.star1,R.drawable.star2};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listview);
        initListView();
    }
    private void initListView(){
        data = new LinkedList<>();

        for (int i=0; i<20; i++) {
            HashMap<String,Object> row = new HashMap<>();   // 一筆資料
            row.put(from[0], "PPAP:" + i);
            row.put(from[1], "apple:" + i);
            row.put(from[2],imgs[(int)(Math.random()*3)]);
            data.add(row);
        }

        adapter = new SimpleAdapter(this,data,R.layout.layout_item,from,to);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Log.v("brad","click"+i);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Log.v("brad","long"+i);
                delItem(i);
                return true;
            }
        });
    }
    private void delItem(int pos){
        Log.v("brad","del ok");
        data.remove(pos);
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Delete OK", Toast.LENGTH_SHORT).show();
    }

}
