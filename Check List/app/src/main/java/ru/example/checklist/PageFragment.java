package ru.example.checklist;


import android.graphics.*;
import android.os.*;
import android.support.v4.app.*;
import android.view.*;
import android.widget.*;
import java.util.*;

public class PageFragment  extends ListFragment {

    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";
    static final String TAG = "myLogs";

    int pageNumber;
    int backColor;
    private ArrayList<CheckItem> checkListFrag ;
    private MyListAdapter myListAdapter;
		
    // определяем массив типа String
//    final String[] catNames = new String[]{"Рыжик", "Барсик", "Мурзик",
//            "Мурка", "Васька", "Томасина", "Кристина", "Пушок", "Дымка",
//            "Кузя", "Китти", "Масяня", "Симба"};
//

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
				//setRetainInstance(true);
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);


				//  DataBase data = new DataBase();
        ArrayList<CheckItem> checkListFrag = DataBase.getCheckList(pageNumber);   // data.getCheckList(pageNumber) ;
        this.checkListFrag = checkListFrag;
        myListAdapter = new MyListAdapter(getActivity(),
																					R.layout.fragment_row, checkListFrag);
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

				/*
				 TextView tvPage = (TextView) view.findViewById(R.id.tvPage);
				 tvPage.setText("Page " + pageNumber);
				 tvPage.setBackgroundColor(backColor);
				 */

        return view;


    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if (myListAdapter.isSpecialItem(position)){
            myListAdapter.removeSpecialItem(position);
        }else{
            myListAdapter.addSpecialItem(position);
        }
        Toast.makeText(getActivity(),
											 getListView().getItemAtPosition(position).toString(),
											 Toast.LENGTH_LONG).show();
				//     System.out.println(myListAdapter.isSpecialItem(position));
				//    Log.d(TAG, "boolean position = " + myListAdapter.isSpecialItem(position));
        myListAdapter.notifyDataSetChanged();
    }

		public boolean[] getSpecialArray (){
				return myListAdapter.getSpecialItem();
		}



		/*
		 private class MyListAdapter extends ArrayAdapter<CheckItem> {

		 private Context mContext;
		 private final boolean[] specialItem;

		 public MyListAdapter(Context context, int textViewResourceId,
		 ArrayList<CheckItem> objects) {
		 super(context, textViewResourceId, objects);
		 mContext = context;
		 specialItem = new boolean[checkListFrag.size()];
		 }

		 @Override
		 public View getView(int position, View convertView, ViewGroup parent) {
		 // return super.getView(position, convertView, parent);

		 LayoutInflater inflater = (LayoutInflater) mContext
		 .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		 View row = inflater.inflate(R.layout.fragment_row, parent,
		 false);
		 TextView item = (TextView) row.findViewById(R.id.itemView);
		 TextView subitem = (TextView) row.findViewById(R.id.subItemView);
		 ImageView imageView = (ImageView) row.findViewById(R.id.imageView);

		 CheckItem checkItem = checkListFrag.get(position);
		 item.setText(checkItem.getOption());
		 subitem.setText(checkItem.getValue());


		 //     imageView.setImageResource(R.mipmap.ic_launcher_round);

		 if (!specialItem[position]) {


		 subitem.setTextColor(0xff5e6060);
		 imageView.setImageResource(R.drawable.ic_launcher);
		 } else {

		 subitem.setTextColor(Color.GREEN);
		 imageView.setImageResource(R.drawable.ic_launcher);
		 }
		 //   Log.d(TAG, "boolean position = " + myListAdapter.isSpecialItem(position));
		 return row;
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


		 */
}


