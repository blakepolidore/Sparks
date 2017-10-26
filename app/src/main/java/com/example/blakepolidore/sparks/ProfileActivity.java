package com.example.blakepolidore.sparks;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by blakepolidore on 10/26/17.
 */

public class ProfileActivity extends AppCompatActivity {

    private TextView description;
    private ImageView image;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_profile);

        setViews();

        if (getIntent() != null) {
            String imageUrl = getIntent().getStringExtra(GameActivity.IMAGEURL_KEY);
            String descriptionText = getIntent().getStringExtra(GameActivity.DESCRIPTION_KEY);

            description.setText(descriptionText);
            Picasso.with(this).load(imageUrl).into(image);
        }
    }

    private void setViews() {
        description = (TextView) findViewById(R.id.profileactivity_description);
        image = (ImageView) findViewById(R.id.profileactivity_image);
    }
}
