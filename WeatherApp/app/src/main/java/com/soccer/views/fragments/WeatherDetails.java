package com.soccer.views.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.soccer.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WeatherDetails#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeatherDetails extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String temp;
    private String feellike;
    private String weather;
    private String description;
    private  Double a;

    public WeatherDetails() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WeatherDetails.
     */
    // TODO: Rename and change types and number of parameters
    public static WeatherDetails newInstance(String param1, String param2) {
        WeatherDetails fragment = new WeatherDetails();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            temp = getArguments().getString("Temp");
            feellike = getArguments().getString("feellike");
            weather = getArguments().getString("TempType");
            description = getArguments().getString("desc");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialization(view);
    }

    private void initialization(View view) {
        ((TextView)view.findViewById(R.id.temperature)).setText(temp);
        ((TextView)view.findViewById(R.id.feelLike)).setText("Feels Like: "+feellike);
        ((TextView)view.findViewById(R.id.weatherT)).setText(weather);
        ((TextView)view.findViewById(R.id.description)).setText(description);
    }
}