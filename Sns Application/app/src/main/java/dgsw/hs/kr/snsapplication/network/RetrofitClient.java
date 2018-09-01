package dgsw.hs.kr.snsapplication.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//레트로핏 객체 생성 클래스
public class RetrofitClient {
    private static Retrofit retrofit = null;
    public static final String BASE_URL="http://10.0.2.2:8080";

    public static Retrofit getClient(String baseUrl){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

    public static RetroBaseApi getApiService(){
        return RetrofitClient.getClient(BASE_URL).create(RetroBaseApi.class);
    }
}
