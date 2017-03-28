package com.example.user.demo_expandable_recyclerview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.edmodo.rangebar.RangeBar;

import org.florescu.android.rangeseekbar.RangeSeekBar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private CrystalRangeSeekbar rangeSeekbar;
    private TextView leftThumb;
    private TextView rightThumb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SubTitle checkBox1 = new SubTitle(SubTitle.SubTitleType.CHECKBOX, "checkBox1");
        SubTitle checkBox2 = new SubTitle(SubTitle.SubTitleType.CHECKBOX, "checkBox2");
        SubTitle checkBox3 = new SubTitle(SubTitle.SubTitleType.CHECKBOX, "checkBox3");
        SubTitle checkBox4 = new SubTitle(SubTitle.SubTitleType.CHECKBOX, "checkBox4");
        SubTitle checkBox5 = new SubTitle(SubTitle.SubTitleType.CHECKBOX, "checkBox5");
        SubTitle checkBox6 = new SubTitle(SubTitle.SubTitleType.CHECKBOX, "checkBox6");
        SubTitle checkBox7 = new SubTitle(SubTitle.SubTitleType.CHECKBOX, "checkBox7");


        SubTitle range = new SubTitle(SubTitle.SubTitleType.RANGEBAR, "range");

        List<String> radioItems = new ArrayList<>();
        radioItems.add("radio1");
        radioItems.add("radio2");
        radioItems.add("radio3");
        radioItems.add("radio4");
        radioItems.add("radio5");
        radioItems.add("radio6");
        radioItems.add("radio7");
        radioItems.add("radio8");
        SubTitle radioGroup2 = new SubTitle(SubTitle.SubTitleType.RADIOBUTTON, initRadioGroup(radioItems));


        SubTitle editText1 = new SubTitle(SubTitle.SubTitleType.EDITTEXT, "editText1");
        SubTitle editText2 = new SubTitle(SubTitle.SubTitleType.EDITTEXT, "editText2");
        SubTitle editText3 = new SubTitle(SubTitle.SubTitleType.EDITTEXT, "editText3");


        Title title1 = new Title("CheckBox", Arrays.asList(checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7));
        Title title2 = new Title("RadioButton", Arrays.asList(radioGroup2));
        Title title3 = new Title("EditText", Arrays.asList(editText1, editText2, editText3));
        Title title4 = new Title("Range", Arrays.asList(range));
        List<Title> Titles = Arrays.asList(title1, title2, title3, title4);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        Adapter adapter = new Adapter(Titles, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    public List<RadioButton> initRadioGroup(List<String> listItems) {
        List<RadioButton> radioButtonList = new ArrayList<>();
        for (int i = 0; i < listItems.size(); i++) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(listItems.get(i));
            radioButtonList.add(radioButton);
        }
        return radioButtonList;
    }
}
