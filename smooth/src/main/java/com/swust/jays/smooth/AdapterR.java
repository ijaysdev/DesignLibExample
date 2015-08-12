package com.swust.jays.smooth;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jays on 15-8-6.
 */
public class AdapterR extends RecyclerView.Adapter<AdapterR.MyViewHolder> {
    private Context mContext;
    private List<String> mData;
    private LayoutInflater mInflater;

    public AdapterR(Context mContext, List<String> mData) {
        this.mContext = mContext;
        this.mData = mData;
        mInflater = LayoutInflater.from(mContext);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.item_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(mData.get(position));

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.id_textview);
        }
    }

}
