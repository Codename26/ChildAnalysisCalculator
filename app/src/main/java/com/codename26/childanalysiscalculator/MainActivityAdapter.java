package com.codename26.childanalysiscalculator;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.ItemViewHolder> {

    public interface OnItemClickListener{
        void onItemClick(ItemMainActivity item);
    }

    private Context mContext;
    private ArrayList<ItemMainActivity> mItems;
    private final OnItemClickListener mListener;


    public MainActivityAdapter(Context context, ArrayList<ItemMainActivity> items, OnItemClickListener listener){
        mContext = context;
        mItems = items;
        mListener = listener;
    }


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_main_activity, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        ItemMainActivity item = mItems.get(position);
        holder.bind(item, mListener);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public ImageView icon;
        public ItemViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitle);
            icon = itemView.findViewById(R.id.ivIcon);
        }

        public void bind(final ItemMainActivity item, final OnItemClickListener listener) {
            title.setText(item.getTitle());
            if (item.getIconURI() != null && !item.getIconURI().equals("")) {
                String iconID = item.getIconURI();
                int resourceID = mContext.getResources().getIdentifier(iconID, "drawable",
                        mContext.getPackageName());
                icon.setImageResource(resourceID);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onItemClick(item);
                    }
                });
            }
        }
    }
}
