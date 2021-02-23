package com.soccer.views.fragments;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.soccer.R;
import com.soccer.models.WeatherList;
import com.soccer.views.fragments.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<WeatherList> mValues;

    public MyItemRecyclerViewAdapter(List<WeatherList> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_city_weather, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.weatherType.setText(mValues.get(position).getWeather().get(0).getMain());
        holder.temp.setText("Temp: "+mValues.get(position).getMain().getTemp());
        holder.mView.setTag(holder.mItem);
        holder.mView.setOnClickListener(this.onClickListener);
    }


    public View.OnClickListener onClickListener= new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            WeatherList item= (WeatherList) view.getTag();
            Bundle b= new Bundle();
            b.putString("Temp", String.valueOf(item.getMain().getTemp()));
            b.putString("feellike", String.valueOf(item.getMain().getFeelsLike()));
            b.putString("TempType",item.getWeather().get(0).getMain());
            b.putString("desc",item.getWeather().get(0).getDescription());
            Navigation.findNavController(view).navigate(R.id.action_cityWeather_to_weatherDetails,b);
        }
    };


    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView weatherType;
        public final TextView temp;
        public WeatherList mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            weatherType = (TextView) view.findViewById(R.id.cityWeather);
            temp = (TextView) view.findViewById(R.id.temp);
        }


    }
}