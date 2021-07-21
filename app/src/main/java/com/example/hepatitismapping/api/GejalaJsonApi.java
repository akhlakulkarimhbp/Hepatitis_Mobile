package com.example.hepatitismapping.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GejalaJsonApi {
    @GET("info-hepas/2")
    Call<Api> getInfoHepas();
}
