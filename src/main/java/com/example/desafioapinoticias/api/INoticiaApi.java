package com.example.desafioapinoticias.api;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface INoticiaApi {
    @GET("api/")
    Call<NoticiasApiResponse> getNoticias(@Query("q") String tema, @Query("date")String date);
}