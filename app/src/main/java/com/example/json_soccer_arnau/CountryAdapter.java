package com.example.json_soccer_arnau;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CountryAdapter extends ArrayAdapter<Country> {

    public CountryAdapter(@NonNull Context context, ArrayList<Country> countryArrayList) {
        super(context, 0, countryArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent){
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.spinner_row, parent, false
            );
        }
        ImageView imgCountry = convertView.findViewById(R.id.imgCountry);
        TextView nameCountry = convertView.findViewById(R.id.nameCountry);
        Country currentItem = getItem(position);
        if (currentItem != null){
            imgCountry.setImageResource(currentItem.getImgCountry());
            nameCountry.setText(currentItem.getNameCountry());
        }
        return convertView;
    }
}
