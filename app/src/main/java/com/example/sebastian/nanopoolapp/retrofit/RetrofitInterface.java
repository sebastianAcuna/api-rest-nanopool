package com.example.sebastian.nanopoolapp.retrofit;

import com.example.sebastian.nanopoolapp.clases.Data;
import com.example.sebastian.nanopoolapp.clases.EstadoPool;
import com.example.sebastian.nanopoolapp.clases.HsPool;
import com.example.sebastian.nanopoolapp.clases.Worker;


import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    @GET("0xc303fe8b7903f73de97a1e8afdc2ca3107158385")
    Call<EstadoPool> getData();
    //@GET("0xc303fe8b7903f73de97a1e8afdc2ca3107158385")
    //Call<HsPool> getHS();

    //@GET()
    //Call<> getData();
}
