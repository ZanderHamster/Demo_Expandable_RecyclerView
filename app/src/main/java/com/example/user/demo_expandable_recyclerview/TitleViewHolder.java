package com.example.user.demo_expandable_recyclerview;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ParentViewHolder;

public class TitleViewHolder extends ParentViewHolder {
    private TextView textView;

    public TitleViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.title_tv);
    }

    public void bind(@NonNull Title title) {
        textView.setText(title.getName());
    }
}
