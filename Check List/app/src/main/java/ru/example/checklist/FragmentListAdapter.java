package ru.example.checklist;

import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;
import java.util.*;
import android.support.v7.widget.helper.*;

public class FragmentListAdapter extends RecyclerView.Adapter<FragmentListAdapter.FragmentViewHolder> {

    

 //   private List<RemindDTO> data;
		private ArrayList<CheckItem> checkList;

    public FragmentListAdapter(ArrayList<CheckItem> checkList) {
   //     this.data = data;
				this.checkList=checkList;
    }

    @Override
    public FragmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_row, parent, false);

        return new FragmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FragmentViewHolder holder, int position) {
      //  RemindDTO item = data.get(position);
				CheckItem chitem = checkList.get(position);
				
        holder.item.setText(chitem.getOption());
				holder.subitem.setText(chitem.getValue());
    }

    @Override
    public int getItemCount() {
        return checkList.size();
    }

   /* public void setData(List<RemindDTO> data) {
        this.data = data;
    }
*/
    public static class FragmentViewHolder extends RecyclerView.ViewHolder {
        LinearLayout itemLayout;
        TextView item;
				TextView subitem;

        public FragmentViewHolder(View itemView) {
            super(itemView);

            itemLayout = (LinearLayout) itemView.findViewById(R.id.fragment_rowLinearLayout);
            item = (TextView) itemView.findViewById(R.id.itemView);
						subitem = (TextView) itemView.findViewById(R.id.subItemView);
        }
    }



}
