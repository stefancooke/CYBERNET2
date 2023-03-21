package com.example.cybernet;

import android.content.Context;
import android.graphics.Typeface;
import android.icu.text.CaseMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.HashMap;
import java.util.List;

public class ExpandableAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> expandableTitle;
    private HashMap<String,List<String >> expandableDetail;

    public ExpandableAdapter(Context context, List<String> expandableTitle, HashMap<String, List<String>> expandableDetail) {
        this.context = context;
        this.expandableTitle = expandableTitle;
        this.expandableDetail = expandableDetail;
    }

    @Override
    public int getGroupCount() {
        return this.expandableTitle.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.expandableDetail.get(this.expandableTitle.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int i) {
        return this.expandableTitle.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return this.expandableDetail.get(this.expandableTitle.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        String listTitle = (String) getGroup(i);
        if (view==null){
            LayoutInflater layoutInflater=(LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.list_group, null);

        }
        TextView TitleView=(TextView) view.findViewById(R.id.listTitle);
        TitleView.setTypeface(null, Typeface.BOLD);
        TitleView.setText(listTitle);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        final String ListText=(String) getChild(i,i1);
        if(view==null){
            LayoutInflater layoutInflater=(LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.list_view, null);

        }
        TextView TextView = (android.widget.TextView) view.findViewById(R.id.listView);
        TextView.setText(ListText);


        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
