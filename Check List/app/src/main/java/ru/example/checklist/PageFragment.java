package ru.example.checklist;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class PageFragment extends ListFragment {

    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";
    static final String TAG = "myLogs";
		private boolean[] specialItem;

    int pageNumber;
    int backColor;
    private ArrayList<CheckItem> checkListFrag;
    private MyListAdapter myListAdapter;

    static PageFragment newInstance(int page) {
        PageFragment pageFragment = new PageFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);
        ArrayList<CheckItem> checkListFrag = DataBase.getCheckList(pageNumber);   // data.getCheckList(pageNumber) ;
        this.checkListFrag = checkListFrag;
				specialItem = new boolean[checkListFrag.size()];
        myListAdapter = new MyListAdapter(getActivity(),
                R.layout.fragment_row, checkListFrag, this);
        setListAdapter(myListAdapter);

        Random rnd = new Random();
        backColor = Color.argb(40, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.listfragment, null);
        LinearLayout iflayout = (LinearLayout) view.findViewById(R.id.lflayout);
        iflayout.setBackgroundColor(backColor);


        return view;


    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if (isSpecialItem(position)) {
            removeSpecialItem(position);
        } else {
            addSpecialItem(position);
        }
        Toast.makeText(getActivity(),
                getListView().getItemAtPosition(position).toString(),
                Toast.LENGTH_LONG).show();
        //     System.out.println(myListAdapter.isSpecialItem(position));
        //    Log.d(TAG, "boolean position = " + myListAdapter.isSpecialItem(position));
        myListAdapter.notifyDataSetChanged();
    }

    public boolean[] getSpecialArray() {
        return specialItem;
    }
		public void addSpecialItem(final int position) {
        specialItem[position] = true;
    }

    public void removeSpecialItem(final int position) {
        specialItem[position] = false;
    }

    public boolean isSpecialItem(final int position) {
        return specialItem[position];
    }

}


