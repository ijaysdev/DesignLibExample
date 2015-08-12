package com.swust.jays.smooth.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.List;

/**
 * Created by jays on 15-8-5.
 */
public abstract class AutoRVAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    public List<?> mList;
    private Context mContext;

    private AdapterView.OnItemClickListener listener;

    public abstract int onCreateViewLayoutID(int viewType);

    public abstract void onBindViewHolder(ViewHolder holder, int position);

    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        this.listener = listener;
    }

    public AutoRVAdapter(Context context, List<?> list) {
        this.mContext = context;
        this.mList = list;
    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(onCreateViewLayoutID(viewType), parent,false);


        return new RecyclerViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {

        onBindViewHolder(holder.getViewHolder(), position);
        if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(null, v, position, holder.getItemId());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
