package com.example.user.demo_expandable_recyclerview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import com.yahoo.mobile.client.android.util.rangeseekbar.RangeSeekBar;

public class MySeek2 extends RangeSeekBar{
    public MySeek2(Context context) {
        super(context);
    }

    public MySeek2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MySeek2(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
