package com.swust.jays.smooth.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by jays on 15-8-5.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    private ViewHolder mViewHolder;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        mViewHolder = ViewHolder.getViewHolder(itemView);
    }

    public ViewHolder getViewHolder() {
        return mViewHolder;
    }

}
