package com.apaza.munidenuncias.Interfaces;

import com.apaza.munidenuncias.Clases.Denuncia;
import com.apaza.munidenuncias.Clases.ResponseMessage;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by Julio Cesar on 16/11/2017.
 */

public interface ApiService {

    String API_BASE_URL = "https://munidenuncias-synms.cs50.io";

    @GET("api/v1/denuncias")
    Call<List<Denuncia>> getDenuncias();


    @FormUrlEncoded
    @POST("/api/v1/usuarios")
    Call<ResponseMessage> createUsuario(@Field("username") String username,
                                        @Field("password") String password);


    @FormUrlEncoded
    @POST("/api/v1/denuncias")
    Call<ResponseMessage> createDenuncia(@Field("titulo") String titulo,
                                         @Field("comentario") String comentario,
                                        @Field("usuarios_id") Integer usuarios_id
    );
    @Multipart
    @POST("/api/v1/denuncias")
    Call<ResponseMessage> createDenunciaWithImage(
            @Part("titulo") RequestBody titulo,
            @Part("comentario") RequestBody comentario,
            @Part("usuarios_id") RequestBody usuarios_id,
            @Part MultipartBody.Part imagen
    );

    @FormUrlEncoded
    @POST("/api/v1/login")
    Call<ResponseMessage> createAuth(@Field("username") String username,
                                     @Field("password") String password);





}
