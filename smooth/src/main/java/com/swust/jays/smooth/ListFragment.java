package com.swust.jays.smooth;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jays on 15-8-4.
 */
public class ListFragment extends Fragment {
    private List<String> mList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.rv);
        initData();
        // lv.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mList));

        rv.setLayoutManager(new GridLayoutManager(getActivity(), 1));
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,
//                StaggeredGridLayoutManager.VERTICAL));
        rv.setAdapter(new TestAdapter(getActivity(), mList));

        return view;
    }

    private void initData() {
        mList = new ArrayList<>();
        for (int i = 'A'; i <= 'Z'; i++) {
            mList.add(String.valueOf((char) i));
        }
    }
}
