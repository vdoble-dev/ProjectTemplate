package com.btg.api;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import com.btg.BuildConfig;
import me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    private Application application;

    public ApiModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    ExternalAPI getExternalAPI(Retrofit retroFit) {
        return retroFit.create(ExternalAPI.class);
    }

    @Provides
    Retrofit getRetrofit(OkHttpClient okHttpClient, Gson gson) {

        return new Retrofit.Builder()
                .baseUrl(BuildConfig.RS_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
    }

    @Provides
    Gson getGson() {
        return new GsonBuilder()
//                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

    @Provides
    OkHttpClient getOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        OkHttpClient.Builder OkHttpClientBuilder = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor);
        return RetrofitUrlManager.getInstance().with(OkHttpClientBuilder)
                .build();
    }

    @Provides
    HttpLoggingInterceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }
}
