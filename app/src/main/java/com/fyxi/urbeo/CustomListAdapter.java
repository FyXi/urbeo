package com.fyxi.urbeo;

/**
 * Created by FrancoisXavier on 2014-09-13.
 */
import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomListAdapter extends BaseAdapter {

    private ArrayList listData;

    private LayoutInflater layoutInflater;

    public CustomListAdapter(Context context, ArrayList listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.challenge_unit, null);
            holder = new ViewHolder();
            holder.headlineView = (TextView) convertView.findViewById(R.id.title);
            holder.locationView = (TextView) convertView.findViewById(R.id.location);
            //holder.descriptionView = (TextView) convertView.findViewById(R.id.description);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.headlineView.setText(((Challenge) listData.get(position)).getHeadline());
        holder.locationView.setText(((Challenge) listData.get(position)).getLocation());
        //holder.descriptionView.setText(((Challenge) listData.get(position)).getDescription());

        return convertView;
    }

    static class ViewHolder {
        TextView headlineView;
        TextView locationView;
        //TextView descriptionView;
    }

}