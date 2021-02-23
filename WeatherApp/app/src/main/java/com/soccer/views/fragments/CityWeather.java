package com.soccer.views.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.soccer.R;
import com.soccer.data.view_model.WeatherViewModel;
import com.soccer.models.WeatherList;
import com.soccer.views.MainActivity;
import com.soccer.views.fragments.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class CityWeather extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    private static final String CITY = "cityName";
    // TODO: Customize parameters
    private int mColumnCount = 2;
    private  String cityName;
    private WeatherViewModel weatherViewModel;
    private List<WeatherList> list =new ArrayList<>();
    private ProgressDialog dialog;
    private MyItemRecyclerViewAdapter myItemRecyclerViewAdapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CityWeather() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static CityWeather newInstance(int columnCount) {
        CityWeather fragment = new CityWeather();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    private void showDialog(){
        dialog = new ProgressDialog(getActivity()); // this = YourActivity
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setTitle("Loading");
        dialog.setMessage("Loading. Please wait...");
        dialog.setIndeterminate(true);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    private void dismissDialog(){
        if(dialog!=null) {
            dialog.dismiss();
        }
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
            cityName=getArguments().getString(CITY);
        }

        ((MainActivity) getActivity()).setTitle(cityName+"'s Temperature");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_city_weather_list, container, false);

        // Set the adapter
       initView(view);
        return view;
    }

    private void initView(View view) {
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            myItemRecyclerViewAdapter=new MyItemRecyclerViewAdapter(list);
            recyclerView.setAdapter(myItemRecyclerViewAdapter);
        }
        showDialog();
        weatherViewModel = ViewModelProviders.of(this).get(WeatherViewModel.class);
        weatherViewModel.getWeatherByCityName(cityName).observe(getViewLifecycleOwner(), response -> {
            dismissDialog();
           //Log.d("List size", String.valueOf(response.getList().size()));
           if(response.getList().size()>0) {
               list.addAll(response.getList());
               myItemRecyclerViewAdapter.notifyDataSetChanged();
           }else {
               Toast.makeText(getContext(),"No Data Found",Toast.LENGTH_LONG).show();
           }

        });
    }
}