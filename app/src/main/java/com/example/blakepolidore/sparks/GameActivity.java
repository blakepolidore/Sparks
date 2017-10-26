package com.example.blakepolidore.sparks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.blakepolidore.sparks.models.Options;
import com.example.blakepolidore.sparks.models.Profile;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity implements GameContract.View, GameContract.AdapterListener {

    private ImageView profile1Image, profile2Image;
    private RecyclerView recyclerView;

    private GameContract.Presenter presenter;
    private OptionsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        setViews();

        adapter = new OptionsAdapter(this, this);
        recyclerView.setAdapter(adapter);

        presenter = new GamePresenter(this, GameApplication.getInstance().getGameManager());
        presenter.start();
    }

    private void setViews() {
        profile1Image = (ImageView) findViewById(R.id.profile1_image);
        profile2Image = (ImageView) findViewById(R.id.profile2_image);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void showOptions(ArrayList<Options> options) {
        adapter.setOptionsList(options);
    }

    @Override
    public void showProfiles(ArrayList<Profile> profiles) {
        if (profiles.size() > 1) {
            setProfiles(profiles.get(0).getImageUrl(), profile1Image);
            setProfiles(profiles.get(1).getImageUrl(), profile2Image);
        } else {
            setProfiles(profiles.get(0).getImageUrl(), profile1Image);
            profile2Image.setVisibility(View.GONE);
        }
    }

    private void setProfiles(String url, ImageView imageView) {
        Picasso.with(this).load(url).into(imageView);
    }

    @Override
    public void showNoData() {

    }

    @Override
    public void onOptionChosen(String id) {
        presenter.optionChosen(id);
    }

    @Override
    public void showVoteSuccessful() {

    }

    @Override
    public void showVoteFailure() {

    }
}
