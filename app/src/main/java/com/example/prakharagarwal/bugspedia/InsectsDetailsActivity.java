package com.example.prakharagarwal.bugspedia;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class InsectsDetailsActivity extends AppCompatActivity {
    TextView commonName;
    TextView scientificName;
    ImageView insectImage;
    TextView classification;
    RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO: Implement layout and display insect details
        setContentView(R.layout.activity_insects_details);
        Insect insect= (Insect) getIntent().getSerializableExtra("Insect");
        commonName=(TextView)findViewById(R.id.common_name_view);
        scientificName=(TextView)findViewById(R.id.scientific_name_view);
        insectImage=(ImageView)findViewById(R.id.image_view);
        ratingBar=(RatingBar)findViewById(R.id.detail_danger_rating);
        classification=(TextView)findViewById(R.id.classification_view);

        commonName.setText(insect.getFriendlyName());
        scientificName.setText(insect.getScientificName());
        try {
            // get input stream
            InputStream ims = getAssets().open(insect.getImageAsset());
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            insectImage.setImageDrawable(d);
        }
        catch(IOException ex) {
            return;
        }
        classification.setText(insect.getClassification());
        ratingBar.setRating(insect.getDangerLevel());

    }
}
