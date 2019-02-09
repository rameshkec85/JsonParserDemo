package com.companyname.jsonparserdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONException;

import java.util.List;

/**
 * Created by Ramesh on 09/02/19.
 */

public class ListViewDemoActivity extends AppCompatActivity {
    ListView listView;
    DemoContactAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_demo);
        listView = findViewById(R.id.lv_contacts);
        //
        try {
            List<ContactBean> list = Helper.parseJson();
            adapter = new DemoContactAdapter(this, list);
            listView.setAdapter(adapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //Adapter declaration
    class DemoContactAdapter extends BaseAdapter {
        List<ContactBean> list;
        Context context;

        public DemoContactAdapter(Context context, List<ContactBean> list) {
            this.list = list;
            this.context = context;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public ContactBean getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //
            //Inflate template
            View view;
            if (convertView == null) {
                view = LayoutInflater.from(context).inflate(R.layout.row_profile, null);
            } else {
                view = convertView;
            }
            //Get views
            TextView name = view.findViewById(R.id.txt_name);
            view.findViewById(R.id.iv_profile);
            TextView phone = view.findViewById(R.id.txt_phone);
            //set data
            ContactBean bean = getItem(position);//list.get(position);
            name.setText(bean.getName());
            phone.setText(bean.getPhone());
            //add it to its container/
            return view;
        }
    }


}
