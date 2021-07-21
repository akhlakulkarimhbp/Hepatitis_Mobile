package com.example.hepatitismapping.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PengobatanJsonApi {
    @GET("info-hepas/4")
    Call<Api> getInfoHepas();
}
