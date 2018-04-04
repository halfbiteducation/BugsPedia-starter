package com.example.prakharagarwal.bugspedia;

import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    private Resources mResources;
    ArrayList<Insect> insectsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//  Code for implementing a simple listview

//        String[] mobileArray = {"Black Widow","Brown Recluse","Honey Bee","Army Ants",
//                "Ladybug","Dog Flea","Head Lice","Malaria Mosquito","Wolf Spider","Brown Scorpion","Centipede","American Cockroach"
//        ,"Fruit Fly","Yellow Jacket"};
//        ArrayAdapter adapter = new ArrayAdapter<String>(this,
//                R.layout.item_listview, mobileArray);
//
//        ListView listView = (ListView) findViewById(R.id.listview);
//        listView.setAdapter(adapter);


        insectsList=new ArrayList<>();
        listview = (ListView) findViewById(R.id.listview);
        mResources = getApplicationContext().getResources();
        StringBuilder builder = new StringBuilder();
        final InputStream in = mResources.openRawResource(R.raw.insects);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

        //Parse resource into key/values
        final String rawJson = builder.toString();

        //TODO: Parse JSON data and insert into the provided database instance
        JSONObject insectJson=new JSONObject(rawJson);
        JSONArray insects=insectJson.getJSONArray("insects");
        for(int i=0;i<insects.length();i++){
            JSONObject insect= insects.optJSONObject(i);
            Insect insect1=new Insect();
            insect1.setClassification(insect.optString("classification"));
            insect1.setDangerLevel(insect.optInt("dangerLevel"));
            insect1.setFriendlyName(insect.optString("friendlyName"));
            insect1.setScientificName(insect.optString("scientificName"));
            insect1.setImageAsset(insect.optString("imageAsset"));
            insectsList.add(insect1);
        }

        } catch (Exception e) {
            e.printStackTrace();
        }
        InsectsListAdapter insectsListAdapter=new InsectsListAdapter(getApplicationContext(),insectsList);
        listview.setAdapter(insectsListAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MainActivity.this,InsectsDetailsActivity.class);
                intent.putExtra("Insect",insectsList.get(i));
                startActivity(intent);
            }
        });
    }
}
