package ru.example.checklist ;

import android.content.*;
import android.os.*;
import android.support.annotation.*;
import android.support.v7.widget.*;
import android.view.*;
import java.util.*;

public class IdeasFragment extends AbstractTabFragment {
    private static final int LAYOUT = R.layout.fragment_history;
		
		private ArrayList<CheckItem> checkList;
		

    private List<RemindDTO> data;

    private FragmentListAdapter adapter;

    public static IdeasFragment getInstance(Context context) {
        Bundle args = new Bundle();
        IdeasFragment fragment = new IdeasFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        //fragment.setData(data);
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

		private List<RemindDTO> createListData() {
				
				
				List<RemindDTO> dataList = new ArrayList<>();
        
				for (int i = 0;i< checkList.size();i++){
				CheckItem checkItem = checkList.get(i);
						dataList.add(new RemindDTO(checkItem.getOption()));
				
}
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


/*    public void refreshList(List<RemindDTO> data) {
        adapter.setData(data);
        adapter.notifyDataSetChanged();
    }
*/
    public void setContext(Context context) {
        this.context = context;
    }

    public void setData(List<RemindDTO> data) {
        this.data = data;
    }
}
