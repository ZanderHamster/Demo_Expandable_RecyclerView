package com.example.user.demo_expandable_recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;

import java.util.List;

public class Adapter extends ExpandableRecyclerAdapter<Title, SubTitle, TitleViewHolder, SubTitleViewHolder> {

    private static final int CHILD_CHECKBOX = 1;
    private static final int CHILD_RADIOBUTTON = 2;
    private static final int CHILD_EDITTEXT = 3;
    private static final int CHILD_RANGEBAR = 4;

    private LayoutInflater mInflater;
    private List<Title> titleList;

    public Adapter(@NonNull List<Title> parentList, Context context) {
        super(parentList);
        mInflater = LayoutInflater.from(context);
        titleList = parentList;
    }

    @NonNull
    @Override
    public TitleViewHolder onCreateParentViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {
        View titleView = mInflater.inflate(R.layout.item_title, parentViewGroup, false);
        return new TitleViewHolder(titleView);
    }

    @NonNull
    @Override
    public SubTitleViewHolder onCreateChildViewHolder(@NonNull ViewGroup childViewGroup, int viewType) {
        View titleView;
        switch (viewType) {
            default:
            case CHILD_CHECKBOX:
                titleView = mInflater.inflate(R.layout.item_checkbox, childViewGroup, false);
                break;
            case CHILD_RADIOBUTTON:
                titleView = mInflater.inflate(R.layout.item_radiobutton, childViewGroup, false);
                break;
            case CHILD_EDITTEXT:
                titleView = mInflater.inflate(R.layout.item_edittext, childViewGroup, false);
                break;
            case CHILD_RANGEBAR:
                titleView = mInflater.inflate(R.layout.item_range, childViewGroup, false);
                break;
        }

        return new SubTitleViewHolder(titleView);
    }

    @Override
    public void onBindParentViewHolder(@NonNull TitleViewHolder parentViewHolder, int parentPosition, @NonNull Title parent) {
        parentViewHolder.bind(parent);
    }

    @Override
    public void onBindChildViewHolder(@NonNull SubTitleViewHolder childViewHolder, int parentPosition, int childPosition, @NonNull SubTitle child) {
        childViewHolder.bind(child);
    }

    @Override
    public int getChildViewType(int parentPosition, int childPosition) {
        SubTitle subTitle = titleList.get(parentPosition).getChild(childPosition);
        switch (subTitle.getType()) {
            case CHECKBOX:
                return CHILD_CHECKBOX;
            case RADIOBUTTON:
                return CHILD_RADIOBUTTON;
            case EDITTEXT:
                return CHILD_EDITTEXT;
            case RANGEBAR:
                return CHILD_RANGEBAR;
        }
        return 0;
    }
}
