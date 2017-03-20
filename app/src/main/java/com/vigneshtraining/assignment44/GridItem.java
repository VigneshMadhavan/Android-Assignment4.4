package com.vigneshtraining.assignment44;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by vimadhavan on 3/20/2017.
 */

public class GridItem extends BaseAdapter {

    private ArrayList<GridData> _data;
    private Context _c;

    public GridItem(ArrayList<GridData> _data, Context _c) {
        this._data = _data;
        this._c = _c;
    }

    @Override
    public int getCount() {
        return _data.size();
    }

    @Override
    public Object getItem(int position) {
        return _data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater li = (LayoutInflater) _c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = li.inflate(R.layout.custom_grid, parent,false);
            Log.e("Inside", "here--------------------------- In view1");
            holder = new ViewHolder();

            holder.imageView = (ImageView) convertView.findViewById(R.id.thumb);
            holder.title= (TextView) convertView.findViewById(R.id.title);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
            Log.e("Inside", "here--------------------------- In view2");
        }

        GridData data=(GridData) _data.get(position);
        holder.title.setText(data.getTitle());
        try {

            if (data.getImage() != null) {
                Log.e("Inside", position+"---here--------------------------- In view3...."+data.getImage());
                holder.imageView.setImageResource(data.getImage());
            } else {
                Log.e("Inside", "here--------------------------- In view4");
                holder.imageView.setImageResource(android.R.drawable.ic_dialog_alert);
            }
            // Seting round image

        } catch (OutOfMemoryError e) {
            // Add default picture
            Log.e("Inside", "here--------------------------- In view5");
            holder.imageView.setImageResource(android.R.drawable.ic_dialog_alert);
            e.printStackTrace();
        }


        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView title;
    }
}
