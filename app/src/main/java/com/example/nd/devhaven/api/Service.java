package com.example.nd.devhaven.api;

import com.example.nd.devhaven.model.ItemResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by nd on 8/25/17.
 */

public interface Service {
    @GET("/search/users?q=language:java+location:lagos")
    Call<ItemResponse> getItems();
}
