package com.btg.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ExternalAPI {
    @GET("endpoint/here")
    Call<String> callExternalAPI();
}
