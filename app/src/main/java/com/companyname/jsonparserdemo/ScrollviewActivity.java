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
    String jsonStr = "[{\"name\":\"Ramesh\",\"age\":25,\"marks\":94.3,\"phone\":96894944994,\"image\":\"https://avatars1.githubusercontent.com/u/1030165?s=460&v=4\",\"address\":{\"city\":\"Hyd\",\"state\":\"TL\"},\"latlng\":[23.000,72.000]},{\"name\":\"Siva\",\"age\":23,\"marks\":85.3,\"phone\":96894944994,\"image\":\"https://avatars1.githubusercontent.com/u/1030165?s=460&v=4\",\"address\":{\"city\":\"Vzm\",\"state\":\"AP\"}}]";

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
            list = parseJson();
            populateCells(list);
        } catch (JSONException e) {
            e.printStackTrace();
        }



    }

    class ContactBean {
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        private String phone;
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
    //

    List<ContactBean> parseJson() throws JSONException {
        JSONArray jsonArray = new JSONArray(jsonStr);
        List<ContactBean> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            ContactBean bean = new ContactBean();
            JSONObject mainObject = jsonArray.getJSONObject(i);
            String name = mainObject.getString("name");
            double phone = mainObject.getDouble("phone");
            bean.setName("Student Name: " + name);
            bean.setPhone("Phone:" + phone);
            //
            list.add(bean);
        }
        return list;


    }
}
