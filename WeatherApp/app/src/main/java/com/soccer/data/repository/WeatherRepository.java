package com.soccer.data.repository;

import android.util.Log;

import com.soccer.data.apis.RestClient;
import com.soccer.data.apis.ServiceApis;
import com.soccer.models.SoccerLeagueModel;
import com.soccer.models.WeatherModel;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepository {
        private static final String TAG = WeatherRepository.class.getSimpleName();
        private ServiceApis apiRequest;

        public WeatherRepository() {
            apiRequest = RestClient.getInstance().getMyApi();
        }



        public LiveData<WeatherModel> getCityWeather(String p1, String p2) {
            final MutableLiveData<WeatherModel> data = new MutableLiveData<>();
            apiRequest.getCityWeather(p1,p2,"imperial").enqueue(new Callback<WeatherModel>() {
                @Override
                public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                    try {

                        if (response.body() != null) {
                            data.setValue(response.body());
                        } else {
                            data.setValue(null);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }

                @Override
                public void onFailure(Call<WeatherModel> call, Throwable t) {
                    data.setValue(null);
                }
            });


            return data;
        }
}