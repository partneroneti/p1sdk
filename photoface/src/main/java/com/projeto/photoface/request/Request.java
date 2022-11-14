package com.projeto.photoface.request;


import com.projeto.photoface.entity.body.AuthenticationBody;
import com.projeto.photoface.entity.body.Cpf;
import com.projeto.photoface.entity.body.DocumentBody;
import com.projeto.photoface.entity.body.LivenessTBody;
import com.projeto.photoface.entity.response.AuthObj;
import com.projeto.photoface.entity.response.AuthenticationResponse;
import com.projeto.photoface.entity.response.CpfObj;
import com.projeto.photoface.entity.response.LivenessResponse;
import com.projeto.photoface.entity.response.LivenessStatusResponse;
import com.projeto.photoface.entity.response.SessionLiveResponse;
import com.projeto.photoface.entity.response.StatusObj;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Request {

    @POST("authentication")
    Call<AuthObj> authentication(@Body AuthenticationBody user);

    @POST("transaction")
    Call<CpfObj> cpfStatus(@Body Cpf cpf, @Header("Authorization") String auth);

    @GET("transaction/{transactionId}")
    Call<StatusObj> checkStatus(@Path("transactionId") String transactionId, @Header("Authorization") String auth);

    @POST("document")
    Call<DocumentBody> sendDocument(@Body DocumentBody documentBody,@Header("Authorization") String auth);

    @GET("session")
    Call<SessionLiveResponse> sessionLive(@Header("Authorization") String auth);

    @POST("liveness")
    Call<LivenessResponse> liveness(@Body LivenessTBody documentBody, @Header("Authorization") String auth);
}
