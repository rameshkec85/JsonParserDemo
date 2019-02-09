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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        //
        btn_json_parser = findViewById(R.id.btn_json_parser);
        btn_scroll_list = findViewById(R.id.btn_scroll_list);
        //
        btn_json_parser.setOnClickListener(this);
        btn_scroll_list.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_json_parser) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_scroll_list) {
            Intent intent = new Intent(this, ScrollviewActivity.class);
            startActivity(intent);
        }
    }
}
