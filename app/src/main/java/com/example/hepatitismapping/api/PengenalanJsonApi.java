package com.example.hepatitismapping.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PengenalanJsonApi {
    @GET("info-hepas/1")
    Call<Api> getInfoHepas();

}
