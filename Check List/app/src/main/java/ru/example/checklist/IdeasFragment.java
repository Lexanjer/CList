package ru.example.checklist;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;

public class IdeasFragment extends AbstractTabFragment {
    private static final int LAYOUT = R.layout.fragment_history;

    private ArrayList<CheckItem> checkList;
    private FragmentListAdapter adapter;

    public static IdeasFragment getInstance(Context context) {
        Bundle args = new Bundle();
        IdeasFragment fragment = new IdeasFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_history));

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        ArrayList<CheckItem> checkList = DataBase.getCheckList(1);   // data.getCheckList(pageNumber) ;
        this.checkList = checkList;

        RecyclerView rv = (RecyclerView) view.findViewById(R.id.recycleView);
        rv.setLayoutManager(new LinearLayoutManager(context));

        adapter = new FragmentListAdapter(checkList);

        rv.setAdapter(adapter);


        return view;
    }



    public void setContext(Context context) {
        this.context = context;
    }


}
