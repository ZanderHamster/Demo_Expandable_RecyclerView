package com.example.user.demo_expandable_recyclerview;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ChildViewHolder;
import com.appyvet.rangebar.RangeBar;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.widgets.BubbleThumbRangeSeekbar;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.crystal.crystalrangeseekbar.widgets.CrystalSeekbar;
//import com.edmodo.rangebar.RangeBar;

import org.florescu.android.rangeseekbar.RangeSeekBar;

import java.util.List;

import io.apptik.widget.MultiSlider;

public class SubTitleViewHolder extends ChildViewHolder {
    private TextView textView;
    private CheckBox checkBox;
    private EditText editText;
    private RangeBar rangeBar;
    private TextView leftThumb;
    private TextView rightThumb;
    private CrystalRangeSeekbar rangeSeekbar;
    private RangeSeekBar<Integer> seekBar;

    private RadioGroup radioGroup;

    public SubTitleViewHolder(@NonNull View itemView) {
        super(itemView);
        radioGroup = (RadioGroup) itemView.findViewById(R.id.radio_group);
        editText = (EditText) itemView.findViewById(R.id.editText);
        checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);

        leftThumb = (TextView) itemView.findViewById(R.id.leftThumb);
        rightThumb = (TextView) itemView.findViewById(R.id.rightThumb);

        
        seekBar = (RangeSeekBar<Integer>) itemView.findViewById(R.id.rangeSeekBar);
        if(seekBar!=null) {
            seekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
                @Override
                public void onRangeSeekBarValuesChanged(RangeSeekBar<Integer> bar, Integer minValue, Integer maxValue) {
                    leftThumb.setText("" + minValue);
                    rightThumb.setText("" + maxValue);
                }
            });
        }
//        seekBar.setOnDragListener(new View.OnDragListener() {
//            @Override
//            public boolean onDrag(View v, DragEvent event) {
//                leftThumb.setText("" + seekBar.getSelectedMinValue());
//                rightThumb.setText("" + seekBar.getSelectedMaxValue());
//                return true;
//            }
//        });

//        rangeSeekbar = (CrystalRangeSeekbar) itemView.findViewById(R.id.rangeSeekBar);
//
//        if (rangeSeekbar != null) {
////            rangeSeekbar.setBarColor(R.color.colorMain);
////            rangeSeekbar.setCornerRadius(12);
//            rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
//                @Override
//                public void valueChanged(Number minValue, Number maxValue) {
//                    leftThumb.setText(minValue.toString());
//                    rightThumb.setText(maxValue.toString());
//                }
//            });
//        }

//        rangeBar = (RangeBar) itemView.findViewById(R.id.rangeBar);
//        rangeBar.setPinRadius(0);
//        rangeBar.setDrawTicks(false);
//        rangeBar.setTickEnd(10);
//        rangeBar.setTickStart(5);
//        rangeBar.setRangePinsByValue(5,10);
//        leftThumb.setText("" + ((int) rangeBar.getTickStart()));
//        rightThumb.setText("" + ((int) rangeBar.getTickEnd()));
//        rangeBar.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
//            @Override
//            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex, int rightPinIndex, String leftPinValue, String rightPinValue) {
//                leftThumb.setText(leftPinValue);
//                rightThumb.setText(rightPinValue);
//            }
//        });

//        rangeBar = (RangeBar) itemView.findViewById(R.id.rangeBar);
//        rangeBar.setThumbRadius(10);
//        rangeBar.setTickCount(20);
//        rangeBar.setTickHeight(0);
//        rangeBar.setThumbIndices(10,15);
//        rangeBar.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
//            @Override
//            public void onIndexChangeListener(RangeBar rangeBar, int leftThumbIndex, int rightThumbIndex) {
//                leftThumb.setText("" + leftThumbIndex);
//                rightThumb.setText("" + rightThumbIndex);
//            }
//        });


    }

    public void bind(@NonNull SubTitle subTitle) {
        switch (subTitle.getType()) {
            case CHECKBOX:
                checkBox.setText(subTitle.getName());
                break;
            case RADIOBUTTON:
                if (radioGroup.getChildCount() != 0) {
                } else {
                    initRadioButton(subTitle);
                }
                break;
            case EDITTEXT:
                editText.setText(subTitle.getName());
                break;
            case RANGEBAR:

                break;
        }

    }

    public void initRadioButton(SubTitle subTitle) {
        List<RadioButton> radioButtonList = subTitle.getRadioButtonList();
        int checkedID = getCheckedId(radioButtonList);

        for (int i = 0; i < radioButtonList.size(); i++) {
            radioGroup.addView(radioButtonList.get(i));
        }

    }

    private int getCheckedId(List<RadioButton> radioButtonList) {
        int id = -1;
        for (int i = 0; i < radioButtonList.size(); i++) {
            if (radioButtonList.get(i).isChecked()) {
                id = i;
                return id;
            }
        }
        return id;
    }
}
