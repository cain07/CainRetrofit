package com.cain.retrofit;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by cain on 16/5/18.
 */
public interface ApiService {

    @GET("service/getIpInfo.php")
    Call<GetIpInfoResponseVo> getIpInfo(@Query("ip")String ip);

}
