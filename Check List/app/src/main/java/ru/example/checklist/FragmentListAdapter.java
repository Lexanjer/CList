package ru.example.checklist;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import android.support.v7.widget.*;

public class FragmentListAdapter extends RecyclerView.Adapter<FragmentListAdapter.FragmentViewHolder> {


    private ArrayList<CheckItem> checkList;
    private boolean[] specialItem;

    public FragmentListAdapter(ArrayList<CheckItem> checkList) {
        this.checkList = checkList;
        specialItem = new boolean[checkList.size()];
    }

    @Override
    public FragmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_row, parent, false);
        return new FragmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FragmentViewHolder holder, int position) {

        CheckItem chitem = checkList.get(position);

        holder.item.setText(chitem.getOption());
        holder.subitem.setText(chitem.getValue());

        if (!specialItem[position]) {
            holder.subitem.setTextColor(0xff5e6060);
            holder.imageView.setImageResource(R.mipmap.ic_launcher);
        } else {
            holder.subitem.setTextColor(Color.GREEN);
            holder.imageView.setImageResource(R.mipmap.ic_message_text);
        }

    }

    @Override
    public int getItemCount() {
        return checkList.size();
    }


    public static class FragmentViewHolder extends RecyclerView.ViewHolder {
        CardView itemLayout;
        TextView item;
        TextView subitem;
        ImageView imageView;

        public FragmentViewHolder(View itemView) {
            super(itemView);

            itemLayout = (CardView) itemView.findViewById(R.id.cardViewCheck);
            item = (TextView) itemView.findViewById(R.id.itemView);
            subitem = (TextView) itemView.findViewById(R.id.subItemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);


        }
    }


}
