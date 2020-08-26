package com.example.expandablelistview;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class CustomExpandableListViewAdapter extends BaseExpandableListAdapter {

    Context context;

    String[] groupName = {"laptop","car","mobile","bike"};
    String[][] childname = {{"dell","lenovo","apple","hp"},{"mecidez","suuki","audi"},{"mi","apple","nokia"},{"harley","kawasaki","ninja"}};

    CustomExpandableListViewAdapter(Context context)
    {
        this.context = context;
    }


    @Override
    public int getGroupCount() {
        return groupName.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childname[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupName[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childname[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        TextView textView = new TextView(context);
        textView.setText(groupName[groupPosition]);
        textView.setPadding(100,0,0,0);
        textView.setTextColor(Color.MAGENTA);
        textView.setTextSize(28);

        return textView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final TextView textView = new TextView(context);
        textView.setText(childname[groupPosition][childPosition]);
        textView.setTextSize(24);
        textView.setTextColor(Color.RED);
        textView.setPadding(100,0,0,0);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, textView.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });


        return textView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
