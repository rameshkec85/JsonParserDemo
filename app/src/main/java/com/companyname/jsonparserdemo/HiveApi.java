package com.companyname.jsonparserdemo;

import com.companyname.jsonparserdemo.model.HiveResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Ramesh on 09/02/19.
 */

public class HiveApi {
    private static final String BASE_URL_HIVE = "https://api.androidhive.info/";

    public HiveService getHiveService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL_HIVE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(HiveService.class);
    }

    public interface HiveService {
        // https://api.androidhive.info/contacts/
        @GET("contacts/")
        Call<ResponseBody> getContacts();

        @GET("contacts/")
        Call<HiveResponse> getContactsParser();

        //Parameterized Annotations: @Query,@Path,@Body

    }
}
