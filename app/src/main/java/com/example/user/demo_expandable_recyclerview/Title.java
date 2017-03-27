package com.example.user.demo_expandable_recyclerview;

import com.bignerdranch.expandablerecyclerview.model.Parent;

import java.util.List;

public class Title implements Parent<SubTitle> {
    String name = "default";
    List<SubTitle> subTitleList;

    public Title(String name, List<SubTitle> subTitleList) {
        this.name = name;
        this.subTitleList = subTitleList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubTitle> getSubTitleList() {
        return subTitleList;
    }

    public void setSubTitleList(List<SubTitle> subTitleList) {
        this.subTitleList = subTitleList;
    }

    public SubTitle getChild(int position) {
        return subTitleList.get(position);
    }


    @Override
    public List<SubTitle> getChildList() {
        return subTitleList;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }

    public SubTitle getSubTitle(int position) {
        return subTitleList.get(position);
    }
}
