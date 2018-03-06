package com.codename26.childanalysiscalculator;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.ItemViewHolder> {

    private Context mContext;
    private ArrayList<ItemMainActivity> mItems;

    public MainActivityAdapter(Context context, ArrayList<ItemMainActivity> items){
        mContext = context;
        mItems = items;
    }


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_main_activity, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        ItemMainActivity item = mItems.get(position);
        holder.title.setText(item.getTitle());
        if (item.getIconURI() != null && !item.getIconURI().equals("")) {
            String iconID = item.getIconURI();
            int resourceID = mContext.getResources().getIdentifier(iconID, "drawable",
                    mContext.getPackageName());
            holder.icon.setImageResource(resourceID);
        }

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
    }
}
