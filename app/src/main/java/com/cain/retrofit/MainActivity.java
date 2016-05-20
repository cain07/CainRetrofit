package com.cain.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {


    private static final String ENDPOINT = "http://ip.taobao.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTest1 = (Button) findViewById(R.id.btn_test1);
        btnTest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,"111",Toast.LENGTH_LONG).show();
                Log.e("MainActivity","----");

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(ENDPOINT)
                        .addConverterFactory(GsonConverterFactory.create()).build();

                ApiService apiService = retrofit.create(ApiService.class);

                Call<GetIpInfoResponseVo> call = apiService.getIpInfo("1.1.1.1");
                call.enqueue(new Callback<GetIpInfoResponseVo>() {
                    @Override
                    public void onResponse(Call<GetIpInfoResponseVo> call, Response<GetIpInfoResponseVo> response) {
                        Log.e("MainActivity","----"+response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<GetIpInfoResponseVo> call, Throwable t) {

                    }
                });

            }
        });
    }





}
