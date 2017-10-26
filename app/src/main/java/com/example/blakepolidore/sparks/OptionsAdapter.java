package com.example.blakepolidore.sparks;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.blakepolidore.sparks.models.Options;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by blakepolidore on 10/26/17.
 */

public class OptionsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Options> options;
    private GameContract.AdapterListener listener;

    public OptionsAdapter(Context context, GameContract.AdapterListener listener) {
        this.context = context;
        this.listener = listener;

        options = new ArrayList<>();
    }

    public void setOptionsList(ArrayList<Options> options) {
        this.options = options;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.options_layout, parent, false);
        return new OptionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Options option = options.get(position);
        if (holder instanceof OptionsViewHolder) {
            ((OptionsViewHolder) holder).text.setText(option.getDescription());

            Picasso.with(context).load(option.getImageUrl()).into(((OptionsViewHolder) holder).imageView);
        }
    }

    @Override
    public int getItemCount() {
        return options.size();
    }

    public class OptionsViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView text;
        private LinearLayout container;

        public OptionsViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.options_image);
            text = (TextView) itemView.findViewById(R.id.options_text);

            final Options option = options.get(getAdapterPosition());

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onOptionChosen(option.getId());
                }
            });

            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onProfileClicked(option.getImageUrl(), option.getDescription());
                }
            });
        }
    }
}
