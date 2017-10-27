package com.example.blakepolidore.sparks;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by blakepolidore on 10/26/17.
 */

public class ProfileActivity extends AppCompatActivity {

    private TextView description, voteButton;
    private ImageView image;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        setViews();

        String imageUrl = getIntent().getStringExtra(GameActivity.IMAGEURL_KEY);
        String descriptionText = getIntent().getStringExtra(GameActivity.DESCRIPTION_KEY);


        description.setText(descriptionText);
        Picasso.with(this).load(imageUrl).transform(new PicassoTransformationCircle()).into(image);
    }

    private void setViews() {
        description = (TextView) findViewById(R.id.profileactivity_description);
        image = (ImageView) findViewById(R.id.profileactivity_image);
        voteButton = (TextView) findViewById(R.id.vote_button);
    }
}
