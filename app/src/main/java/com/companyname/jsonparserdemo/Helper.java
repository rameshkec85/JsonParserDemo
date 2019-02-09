package com.companyname.jsonparserdemo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ramesh on 09/02/19.
 */

public class Helper {
    static String jsonStr = "[{\"name\":\"Ramesh\",\"age\":25,\"marks\":94.3,\"phone\":96894944994,\"image\":\"https://avatars1.githubusercontent.com/u/1030165?s=460&v=4\",\"address\":{\"city\":\"Hyd\",\"state\":\"TL\"},\"latlng\":[23.000,72.000]},{\"name\":\"Siva\",\"age\":23,\"marks\":85.3,\"phone\":96894944994,\"image\":\"https://avatars1.githubusercontent.com/u/1030165?s=460&v=4\",\"address\":{\"city\":\"Vzm\",\"state\":\"AP\"}}]";

    public static List<ContactBean> parseJson() throws JSONException {
        JSONArray jsonArray = new JSONArray(jsonStr);
        List<ContactBean> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            ContactBean bean = new ContactBean();
            JSONObject mainObject = jsonArray.getJSONObject(i);
            String name = mainObject.getString("name");
            double phone = mainObject.getDouble("phone");
            bean.setName("Name: " + name);
            bean.setPhone("Phone:" + phone);
            //
            list.add(bean);
        }
        return list;
    }
}
