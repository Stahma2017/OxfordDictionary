package com.example.stas.oxforddictionary.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit;
    private static String API_BASE_URL = "https://od-api.oxforddictionaries.com/";

    private static final String APP_ID = "app_id";
    private static final String APP_ID_VALUE = "53974e4d";
    private static final String APP_KEY = "app_key";
    private static final String APP_KEY_VALUE = "5b849e1ae6cc825986f969ce9ec8c198";

    public static Retrofit getRetrofit(){
        if (retrofit == null){
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY );

            OkHttpClient okClient = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                         Request request = chain.request();
                            request = request.newBuilder()
                                 .addHeader(APP_ID, APP_ID_VALUE)
                                 .addHeader(APP_KEY, APP_KEY_VALUE)
                                 .build();
                            return chain.proceed(request);
                        }
                    })
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okClient)
                    .build();
        }
        return retrofit;
    }
}
