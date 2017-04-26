package ru.example.checklist;

import android.content.*;
import android.graphics.*;
import android.support.v4.app.*;
import android.view.*;
import android.widget.*;
import java.util.*;

  //import android.support.v7.appcompat.R;

public class MyListAdapter extends ArrayAdapter<CheckItem>
{

		private Context mContext;
		private boolean[] specialItem;
		private ArrayList<CheckItem> checkList;

		public MyListAdapter(Context context, int textViewResourceId,
												 ArrayList<CheckItem> checkList) {
				super(context, textViewResourceId, checkList);
				mContext = context;
				this.checkList = checkList;
				specialItem = new boolean[checkList.size()];
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

				CheckItem checkItem = checkList.get(position);
				item.setText(checkItem.getOption());
				subitem.setText(checkItem.getValue());


				//     imageView.setImageResource(R.mipmap.ic_launcher_round);

				if (!specialItem[position]) {


						subitem.setTextColor(0xff5e6060);
						imageView.setImageResource(R.mipmap.ic_launcher);
				} else {

						subitem.setTextColor(Color.GREEN);
						imageView.setImageResource(R.mipmap.ic_message_text);
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
		public boolean[] getSpecialItem()
		{
				return specialItem;
		}

		public void setSpecialItem (boolean[] spIt){
				this.specialItem = spIt;
		}

}


