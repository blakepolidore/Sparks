package com.example.blakepolidore.sparks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.blakepolidore.sparks.models.Options;
import com.example.blakepolidore.sparks.models.Profile;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity implements GameContract.View, GameContract.AdapterListener {

    public static final String IMAGEURL_KEY = "imageKey";
    public static final String DESCRIPTION_KEY = "descriptionKey";

    private ImageView profile1Image, profile2Image;
    private RecyclerView recyclerView;
    private LinearLayout profileImageContainer;

    private GameContract.Presenter presenter;
    private OptionsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        setViews();

        adapter = new OptionsAdapter(this, this);
        recyclerView.setAdapter(adapter);

        presenter = new GamePresenter(this, new GameManager(this));
        presenter.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.stop();
    }

    private void setViews() {
        profile1Image = (ImageView) findViewById(R.id.profile1_image);
        profile2Image = (ImageView) findViewById(R.id.profile2_image);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        profileImageContainer = (LinearLayout) findViewById(R.id.profile_image_container);
    }

    @Override
    public void showOptions(ArrayList<Options> options) {
        adapter.setOptionsList(options);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onProfileClicked(String imageUrl, String description) {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra(IMAGEURL_KEY, imageUrl);
        intent.putExtra(DESCRIPTION_KEY, description);
        startActivity(intent);
    }

    @Override
    public void showProfiles(ArrayList<Profile> profiles) {
        setProfiles(profiles.get(0).getImageUrl(), profile1Image);
        setProfiles(profiles.get(1).getImageUrl(), profile2Image);
        profileImageContainer.setVisibility(View.VISIBLE);
    }

    private void setProfiles(String url, ImageView imageView) {
        Picasso.with(this).load(url).into(imageView);
    }

    @Override
    public void showNoData() {
        showErrorToast("Error receiving data. Please reload.");
    }

    @Override
    public void onOptionChosen(String answerId) {
        presenter.optionChosen(answerId);
    }

    @Override
    public void showVoteSuccessful() {

    }

    @Override
    public void showVoteFailure() {
        showErrorToast("Error receiving vote. Please try again.");
    }

    private void showErrorToast(String errorText) {
        Toast.makeText(this, errorText, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearData() {
        profileImageContainer.setVisibility(View.GONE);
    }

    @Override
    public void showTimeRemaining(long msRemaining) {

    }
}
