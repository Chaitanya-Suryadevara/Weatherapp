package com.soccer.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.soccer.R;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class SearchWeather extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.search_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        Button button = (Button) view.findViewById(R.id.searchBtn);
        TextInputEditText editText=(TextInputEditText)view.findViewById(R.id.editTxtCityName) ;
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(Objects.requireNonNull(editText.getText()).toString().trim().length()==0){
                    Toast.makeText(getActivity(), R.string.city_name,Toast.LENGTH_LONG).show();
                    return;
                }
                // do something
                Bundle b= new Bundle();
                b.putString("cityName",editText.getText().toString());

                Navigation.findNavController(view).navigate(R.id.action_FirstFragment_to_cityWeather,b);
            }
        });
    }



}
