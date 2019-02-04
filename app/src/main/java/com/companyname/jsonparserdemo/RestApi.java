package com.companyname.jsonparserdemo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;

/**
 * Created by Ramesh on 04/02/19.
 */

public class RestApi {


    private static final String BASE_URL = "https://api.github.com/";
    //https://api.androidhive.info/contacts/
    private static final String BASE_URL_HIVE = "https://api.androidhive.info/";

    //Define Base URL
    //1. Create Retrofit Builder
    //2. Define Interface
    //3. Call API

    public GithubService getService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .build();
        return retrofit.create(GithubService.class);
    }

    public HiveService getHiveService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL_HIVE)
                .build();
        return retrofit.create(HiveService.class);
    }


    public interface GithubService {
        //GET,POST,PUT,DELETE  ==>Annotations

        //https://api.github.com/users/rameshkec85/repos
        //ResponseBody => Raw Response
        @GET("users/rameshkec85/repos")
        Call<ResponseBody> getRepos();

    }


    public interface HiveService {
        // https://api.androidhive.info/contacts/
        @GET("contacts/")
        Call<ResponseBody> getContacts();

    }
}
