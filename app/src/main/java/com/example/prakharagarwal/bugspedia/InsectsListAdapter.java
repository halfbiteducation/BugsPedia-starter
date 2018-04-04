package com.example.prakharagarwal.bugspedia;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by prakharagarwal on 04/04/18.
 */

public class InsectsListAdapter extends ArrayAdapter<Insect> {

    Context context;

    public InsectsListAdapter(@NonNull Context context, ArrayList<Insect> insectArrayList) {
        super(context, 0,insectArrayList);
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Insect insect = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_listview2, parent, false);
        }
        // Lookup view for data population
        TextView commonName = (TextView) convertView.findViewById(R.id.list_item_common_name);
        TextView scientificName = (TextView) convertView.findViewById(R.id.list_item_scientific_name);
        // Populate the data into the template view using the data object
        commonName.setText(insect.getFriendlyName());
        scientificName.setText(insect.getScientificName());
        // Return the completed view to render on screen
        return convertView;
    }

}