package com.example.android.materialme;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView mTitleText;
    private TextView mInfoText;
    private ImageView mSportsImage;
    private ArrayList<Sport> mSportsData;
    private Context mContext;

    ViewHolder(View itemView) {
        super(itemView);
        mTitleText = itemView.findViewById(R.id.title);
        mInfoText = itemView.findViewById(R.id.subTitle);
        mSportsImage = itemView.findViewById(R.id.sportsImage);
        itemView.setOnClickListener(this);
    }

    void bindTo(Sport currentSport){
        mTitleText.setText(currentSport.getTitle());
        mInfoText.setText(currentSport.getInfo());

        Glide.with(mContext).load(
                currentSport.getImageResource()).into(mSportsImage);
    }

    @Override
    public void onClick(View view) {
        Sport currentSport = mSportsData.get(getAdapterPosition());
        Intent detailIntent = new Intent(mContext, DetailActivity.class);
        detailIntent.putExtra("title", currentSport.getTitle());
        detailIntent.putExtra("image_resource",
                currentSport.getImageResource());
        mContext.startActivity(detailIntent);
    }
}
