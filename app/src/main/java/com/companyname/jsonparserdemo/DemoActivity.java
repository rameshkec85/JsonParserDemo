package com.companyname.jsonparserdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Ramesh on 09/02/19.
 */

public class DemoActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_json_parser;
    Button btn_scroll_list;
    Button btn_listview;
    Button btn_retrofit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        //
        btn_json_parser = findViewById(R.id.btn_json_parser);
        btn_scroll_list = findViewById(R.id.btn_scroll_list);
        btn_listview = findViewById(R.id.btn_listview);
        btn_retrofit = findViewById(R.id.btn_retrofit);
        //
        btn_json_parser.setOnClickListener(this);
        btn_scroll_list.setOnClickListener(this);
        btn_listview.setOnClickListener(this);
        btn_retrofit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_json_parser) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_scroll_list) {
            Intent intent = new Intent(this, ScrollviewActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_listview) {
            Intent intent = new Intent(this, ListViewDemoActivity.class);
            startActivity(intent);
        }else if (v.getId() == R.id.btn_retrofit) {
            Intent intent = new Intent(this, HiveDemoActivity.class);
            startActivity(intent);
        }
    }
}
