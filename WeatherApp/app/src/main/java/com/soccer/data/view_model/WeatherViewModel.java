package com.soccer.data.view_model;

import android.app.Application;

import com.soccer.data.repository.WeatherRepository;
import com.soccer.models.SoccerLeagueModel;
import com.soccer.models.WeatherModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class WeatherViewModel extends AndroidViewModel {
    private WeatherRepository weatherRepository;
    private LiveData<WeatherModel> weatherViewModelLiveData;

    public WeatherViewModel(@NonNull Application application) {
        super(application);
        weatherRepository = new WeatherRepository();

    }

    public LiveData<WeatherModel> getWeatherByCityName(String city) {
        this.weatherViewModelLiveData = weatherRepository.getCityWeather(city,"65d00499677e59496ca2f318eb68c049");
        return weatherViewModelLiveData;
    }

}
