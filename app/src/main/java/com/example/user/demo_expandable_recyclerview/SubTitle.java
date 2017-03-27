package com.example.user.demo_expandable_recyclerview;

import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.List;

public class SubTitle {

    public enum SubTitleType {
        CHECKBOX,
        RADIOBUTTON,
        EDITTEXT,
        RANGEBAR
    }

    private SubTitleType type;
    private String name;
    private RadioGroup radioGroup;
    private List<RadioButton> radioButtonList;

    public SubTitle(SubTitleType type, String name) {
        this.type = type;
        this.name = name;
    }

    public SubTitle(SubTitleType type, List<RadioButton> radioButtonList) {
        this.type = type;
        this.radioButtonList = radioButtonList;
    }

    public SubTitleType getType() {
        return type;
    }

    public void setType(SubTitleType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RadioGroup getRadioGroup() {
        return radioGroup;
    }

    public void setRadioGroup(RadioGroup radioGroup) {
        this.radioGroup = radioGroup;
    }

    public List<RadioButton> getRadioButtonList() {
        return radioButtonList;
    }

    public void setRadioButtonList(List<RadioButton> radioButtonList) {
        this.radioButtonList = radioButtonList;
    }
}
