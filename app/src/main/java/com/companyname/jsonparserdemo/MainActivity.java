package com.companyname.jsonparserdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    String jsonStr = "[{\"name\":\"Ramesh\",\"age\":25,\"marks\":94.3,\"phone\":96894944994,\"image\":\"https://avatars1.githubusercontent.com/u/1030165?s=460&v=4\",\"address\":{\"city\":\"Hyd\",\"state\":\"TL\"},\"latlng\":[23.000,72.000]},{\"name\":\"Siva\",\"age\":23,\"marks\":85.3,\"phone\":96894944994,\"image\":\"https://avatars1.githubusercontent.com/u/1030165?s=460&v=4\",\"address\":{\"city\":\"Vzm\",\"state\":\"AP\"}}]";

    TextView textView;
    ListView listView;
    List<String> resultList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.txt_data);
        listView = findViewById(R.id.listView);
        try {
            parseJson();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //
        //3.  Call API
//        callGithubApi();

        callHiveApi();

    }

    private void callHiveApi() {
        new RestApi().getHiveService().getContacts().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {

                    try {
                        String jsonStr = response.body().string();
                        try {
                            JSONObject jsonObject = new JSONObject(jsonStr);
                            //
                            JSONArray contacts = jsonObject.getJSONArray("contacts");
                            //
                            for (int i = 0; i < contacts.length(); i++) {
                                JSONObject contact = contacts.getJSONObject(i);
                                String name = contact.getString("name");
                                String email = contact.getString("email");
                                Log.e("Ramesh", "Name: " + name + "; Email:" + email);
                                //
                                resultList.add("Name: " + name);
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_list_item_1,
                            android.R.id.text1,
                            resultList);
                    listView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void callGithubApi() {
        new RestApi().getService().getRepos()
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            //
                            try {
                                String jsonStr = response.body().string();
//                                Log.e("Ramesh", jsonStr);
                                //
                                try {
                                    JSONArray array = new JSONArray(jsonStr);
                                    for (int i = 0; i < array.length(); i++) {
                                        JSONObject jsonObject = array.getJSONObject(i);
                                        String name = jsonObject.getString("name");
                                        Log.e("Ramesh", "Name:" + name);
                                        resultList.add("Name: " + name);
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }


                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                                    android.R.layout.simple_list_item_1,
                                    android.R.id.text1,
                                    resultList);
                            listView.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
    }

    void parseJson() throws JSONException {
        StringBuilder builder = new StringBuilder();
        JSONArray jsonArray = new JSONArray(jsonStr);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject mainObject = jsonArray.getJSONObject(i);
            String name = mainObject.getString("name");
            builder.append("Student Name: ");
            builder.append(name);
            builder.append("; Age: ");
            builder.append(mainObject.getInt("age"));
            //
            builder.append("; Marks: ");
            builder.append(mainObject.getDouble("marks"));
            //
            JSONObject address = mainObject.getJSONObject("address");
            builder.append("; City: ");
            builder.append(address.getString("city"));
            //
            builder.append("; State: ");
            builder.append(address.getString("state"));
            //
            if (mainObject.has("latlng")) {
                JSONArray latlngArray = mainObject.getJSONArray("latlng");
                double latitude = latlngArray.getDouble(0);
                double longitude = latlngArray.getDouble(1);
                builder.append("; Location: ");
                builder.append(latitude + "," + longitude);
            }
            //
            builder.append("\n");
        }
        textView.setText(builder.toString());


    }


}
