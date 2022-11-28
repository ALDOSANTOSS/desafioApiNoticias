package com.example.desafioapinoticias.services;

import com.example.desafioapinoticias.api.INoticiaApi;
import com.example.desafioapinoticias.api.NoticiasApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@Service
public class NoticiaService {
    private final INoticiaApi apiService;

    @Autowired
    public NoticiaService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://apinoticias.tedk.com.br/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.apiService = retrofit.create(INoticiaApi.class);
    }

    public void getAll() {
        Call<NoticiasApiResponse> callResponse = this.apiService.getNoticias("bahia", "18/11/2022");
        try {
            Response<NoticiasApiResponse> apiResponse = callResponse.execute();

            System.out.println("Achei Abestado");
            NoticiasApiResponse noticias = apiResponse.body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
