package com.example.hepatitismapping.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PencegahanJsonApi {
    @GET("info-hepas/3")
    Call<Api> getInfoHepas();
}
