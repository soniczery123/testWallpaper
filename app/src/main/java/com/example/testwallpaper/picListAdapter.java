package com.example.testwallpaper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by MSI-GL62 on 9/12/2560.
 */

public class picListAdapter extends ArrayAdapter<PictureItem> {
    private Context mContext;
    private int mLayoutResId;
    private ArrayList<PictureItem> mPicList;

    public picListAdapter(Context mContext, int mLayoutResId, ArrayList<PictureItem> mPicList) {
        super(mContext,mLayoutResId,mPicList);
        this.mContext = mContext;
        this.mLayoutResId = mLayoutResId;
        this.mPicList = mPicList;
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemLayout = inflater.inflate(mLayoutResId, null);
        PictureItem item = mPicList.get(position);
        ImageView picImageView = itemLayout.findViewById(R.id.imageView);
        picImageView.setImageResource(item.picture);
        return itemLayout;
    }
}
