package com.qoobico.remindme.fragment;

import android.content.*;
import android.os.*;
import android.support.annotation.*;
import android.support.v7.widget.*;
import android.view.*;
import com.qoobico.remindme.*;
import com.qoobico.remindme.adapter.*;
import com.qoobico.remindme.dto.*;
import java.util.*;

public class HistoryFragment extends AbstractTabFragment {
    private static final int LAYOUT = R.layout.fragment_history;

    private List<RemindDTO> data;

    private RemindListAdapter adapter;

    public static HistoryFragment getInstance(Context context, List<RemindDTO> data) {
        Bundle args = new Bundle();
        HistoryFragment fragment = new HistoryFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setData(data);
        fragment.setTitle(context.getString(R.string.tab_item_history));

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);

        RecyclerView rv = (RecyclerView) view.findViewById(R.id.recycleView);
        rv.setLayoutManager(new LinearLayoutManager(context));

        adapter = new RemindListAdapter(createListData());
        rv.setAdapter(adapter);

        return view;
    }
		
		private List<RemindDTO> createListData() {

        List<RemindDTO> dataList = new ArrayList<>();
        dataList.add(new RemindDTO("DATASOFT"));
        dataList.add(new RemindDTO("world"));
        dataList.add(new RemindDTO("hello"));
        dataList.add(new RemindDTO("hello"));
        dataList.add(new RemindDTO("hello"));
        dataList.add(new RemindDTO("hello"));
        dataList.add(new RemindDTO("hello"));
        dataList.add(new RemindDTO("hello"));
        dataList.add(new RemindDTO("DATASOFT"));

        return dataList;
    }
		

    public void refreshList(List<RemindDTO> data) {
        adapter.setData(data);
        adapter.notifyDataSetChanged();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setData(List<RemindDTO> data) {
        this.data = data;
    }
}
