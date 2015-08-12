package com.swust.jays.smooth;

import android.content.Context;

import com.swust.jays.smooth.adapter.AutoRVAdapter;
import com.swust.jays.smooth.adapter.ViewHolder;

import java.util.List;

/**
 * Created by jays on 15-8-5.
 */
public class TestAdapter extends AutoRVAdapter {

    public TestAdapter(Context context, List<?> list) {
        super(context, list);
    }

    @Override
    public int onCreateViewLayoutID(int viewType) {
        return R.layout.item_row;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String item = (String) mList.get(position);
        holder.getTextView(R.id.id_textview).setText(item);
        holder.getImageView(R.id.iv_img).setImageResource(R.mipmap.ic_launcher);
    }
}
