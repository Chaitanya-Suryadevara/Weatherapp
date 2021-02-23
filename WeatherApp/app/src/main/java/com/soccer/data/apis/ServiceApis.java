package com.soccer.data.apis;

import com.soccer.models.SoccerLeagueModel;
import com.soccer.models.WeatherModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServiceApis {
    String BASE_URL = "https://api.openweathermap.org";

    @GET("/data/2.5/forecast")
    Call<WeatherModel> getCityWeather(@Query("q") String name,@Query("appid") String key,@Query("units") String units);


}
