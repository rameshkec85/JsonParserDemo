package com.companyname.jsonparserdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ramesh on 09/02/19.
 */

public class ScrollviewActivity extends AppCompatActivity {
    LinearLayout ll_container;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollview);
        //
        ll_container = findViewById(R.id.ll_container);
        //
//        List<ContactBean> list = createList();
        List<ContactBean> list = null;
        try {
//            list = createList();
            list = Helper.parseJson();
            populateCells(list);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private List<ContactBean> createList() {
        List<ContactBean> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ContactBean bean = new ContactBean();
            bean.setName("Name: " + i);
            bean.setPhone("+91 9123456789" + i);
            list.add(bean);
        }
        return list;
    }

    private void populateCells(List<ContactBean> list) {
        for (int i = 0; i < list.size(); i++) {
            //Inflate template
            View view = LayoutInflater.from(this).inflate(R.layout.row_profile, null);
            //Get views
            TextView name = view.findViewById(R.id.txt_name);
            view.findViewById(R.id.iv_profile);
            TextView phone = view.findViewById(R.id.txt_phone);
            //set data
            ContactBean bean = list.get(i);
            name.setText(bean.getName());
            phone.setText(bean.getPhone());
            //add it to its container/
            ll_container.addView(view);
        }
    }

}
