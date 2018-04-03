package com.kangzayd.spreadsheetretrofit.networking;

import com.kangzayd.spreadsheetretrofit.model.Response;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by KangZayd on 22/03/2018.
 */

public interface ApiInterface {
    @GET("exec?id=13aU-_NuiH7OJ0F2HCoQPdYwX0I728uIL1lTplkXIMyk&sheet=user")
    Call<Response> ambilData();
}
