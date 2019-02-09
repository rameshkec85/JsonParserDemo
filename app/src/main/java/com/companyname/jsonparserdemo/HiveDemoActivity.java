package com.companyname.jsonparserdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.companyname.jsonparserdemo.model.Contacts;
import com.companyname.jsonparserdemo.model.HiveResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ramesh on 09/02/19.
 */

public class HiveDemoActivity extends AppCompatActivity {
    ListView listView;
    DemoContactAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_demo);
        listView = findViewById(R.id.lv_contacts);
        //Json ->GSON
        loadContactsGson();
    }

    private void loadContactsGson() {
        new HiveApi().getHiveService().getContactsParser().enqueue(new Callback<HiveResponse>() {
            @Override
            public void onResponse(Call<HiveResponse> call, Response<HiveResponse> response) {
                if (response.isSuccessful()) {
                    HiveResponse hiveResponse = response.body();
                    updateData(hiveResponse.getContacts());
                }
            }

            @Override
            public void onFailure(Call<HiveResponse> call, Throwable t) {

            }
        });
    }


    private void updateData(List<Contacts> list) {
        adapter = new DemoContactAdapter(this, list);
        listView.setAdapter(adapter);
    }

    //Adapter declaration
    class DemoContactAdapter extends BaseAdapter {
        List<Contacts> list;
        Context context;

        public DemoContactAdapter(Context context, List<Contacts> list) {
            this.list = list;
            this.context = context;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Contacts getItem(int position) {
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
            ImageView image = view.findViewById(R.id.iv_profile);
            TextView phone = view.findViewById(R.id.txt_phone);
            //set data
            Contacts bean = getItem(position);//list.get(position);
            name.setText(bean.getName());
            phone.setText(bean.getPhone().getMobile());
            //add it to its container/

            Glide.with(context)
                    .load("http://goo.gl/gEgYUd")
                    .into(image);
//            GlideApp.with(this).load("http://goo.gl/gEgYUd").into(image);
            return view;
        }
    }


}


