//package com.example.user.demo_expandable_recyclerview;
//
//
//import android.content.Context;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.support.annotation.NonNull;
//import android.util.AttributeSet;
//
//import org.florescu.android.rangeseekbar.RangeSeekBar;
//import org.florescu.android.util.PixelUtil;
//
//public class MyRangeBar extends RangeSeekBar<Integer>{
//    public static final int ACTIVE_COLOR = Color.argb(0xFF, 0x33, 0xB5, 0xE5);
//    /**
//     * An invalid pointer id.
//     */
//    public static final int INVALID_POINTER_ID = 255;
//
//    // Localized constants from MotionEvent for compatibility
//    // with API < 8 "Froyo".
//    public static final int ACTION_POINTER_INDEX_MASK = 0x0000ff00, ACTION_POINTER_INDEX_SHIFT = 8;
//
//    public static final Integer DEFAULT_MINIMUM = 0;
//    public static final Integer DEFAULT_MAXIMUM = 100;
//    public static final Integer DEFAULT_STEP = 1;
//    public static final int HEIGHT_IN_DP = 30;
//    public static final int TEXT_LATERAL_PADDING_IN_DP = 3;
//
//    private static final int INITIAL_PADDING_IN_DP = 8;
//    private static final int DEFAULT_TEXT_SIZE_IN_DP = 14;
//    private static final int DEFAULT_TEXT_DISTANCE_TO_BUTTON_IN_DP = 8;
//    private static final int DEFAULT_TEXT_DISTANCE_TO_TOP_IN_DP = 8;
//
//    private static final int LINE_HEIGHT_IN_DP = 1;
//    private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
//
//    public MyRangeBar(Context context) {
//        super(context);
////        init(context, null);
//    }
//
//    public MyRangeBar(Context context, AttributeSet attrs) {
//        super(context, attrs);
////        init(context, attrs);
//    }
//
//    public MyRangeBar(Context context, AttributeSet attrs, int defStyle) {
//        super(context, attrs, defStyle);
////        init(context, attrs);
//    }
//
//    @Override
//    protected synchronized void onDraw(@NonNull Canvas canvas) {
//        super.onDraw(canvas);
//
//        textSize = PixelUtil.dpToPx(context, DEFAULT_TEXT_SIZE_IN_DP);
//        paint.setTextSize(textSize);
//        paint.setStyle(Paint.Style.FILL);
//        paint.setColor(defaultColor);
//        paint.setAntiAlias(true);
//        float minMaxLabelSize = 0;
//
//        if (showLabels) {
//            // draw min and max labels
//            String minLabel = getContext().getString(org.florescu.android.rangeseekbar.R.string.demo_min_label);
//            String maxLabel = getContext().getString(org.florescu.android.rangeseekbar.R.string.demo_max_label);
//            minMaxLabelSize = Math.max(paint.measureText(minLabel), paint.measureText(maxLabel));
//            float minMaxHeight = textOffset + thumbHalfHeight + textSize / 3;
//            canvas.drawText(minLabel, 0, minMaxHeight, paint);
//            canvas.drawText(maxLabel, getWidth() - minMaxLabelSize, minMaxHeight, paint);
//        }
//        padding = internalPad + minMaxLabelSize + thumbHalfWidth;
//
//        // draw seek bar background line
//        rect.left = padding;
//        rect.right = getWidth() - padding;
//        canvas.drawRect(rect, paint);
//
//        boolean selectedValuesAreDefault = (normalizedMinValue <= minDeltaForDefault && normalizedMaxValue >= 1 - minDeltaForDefault);
//
//        int colorToUseForButtonsAndHighlightedLine = !alwaysActive && !activateOnDefaultValues && selectedValuesAreDefault ?
//                defaultColor : // default values
//                activeColor;   // non default, filter is active
//
//        // draw seek bar active range line
//        rect.left = normalizedToScreen(normalizedMinValue);
//        rect.right = normalizedToScreen(normalizedMaxValue);
//
//        paint.setColor(colorToUseForButtonsAndHighlightedLine);
//        canvas.drawRect(rect, paint);
//
//        // draw minimum thumb (& shadow if requested) if not a single thumb control
//        if (!singleThumb) {
//            if (thumbShadow) {
//                drawThumbShadow(normalizedToScreen(normalizedMinValue), canvas);
//            }
//            drawThumb(normalizedToScreen(normalizedMinValue), Thumb.MIN.equals(pressedThumb), canvas,
//                    selectedValuesAreDefault);
//        }
//
//        // draw maximum thumb & shadow (if necessary)
//        if (thumbShadow) {
//            drawThumbShadow(normalizedToScreen(normalizedMaxValue), canvas);
//        }
//        drawThumb(normalizedToScreen(normalizedMaxValue), Thumb.MAX.equals(pressedThumb), canvas,
//                selectedValuesAreDefault);
//
//        // draw the text if sliders have moved from default edges
//        if (showTextAboveThumbs && (activateOnDefaultValues || !selectedValuesAreDefault)) {
//            paint.setTextSize(textSize);
//            paint.setColor(textAboveThumbsColor);
//
//            String minText = valueToString(getSelectedMinValue());
//            String maxText = valueToString(getSelectedMaxValue());
//            float minTextWidth = paint.measureText(minText);
//            float maxTextWidth = paint.measureText(maxText);
//            // keep the position so that the labels don't get cut off
//            float minPosition = Math.max(0f, normalizedToScreen(normalizedMinValue) - minTextWidth * 0.5f);
//            float maxPosition = Math.min(getWidth() - maxTextWidth, normalizedToScreen(normalizedMaxValue) - maxTextWidth * 0.5f);
//
//            if (!singleThumb) {
//                // check if the labels overlap, or are too close to each other
//                int spacing = PixelUtil.dpToPx(getContext(), TEXT_LATERAL_PADDING_IN_DP);
//                float overlap = minPosition + minTextWidth - maxPosition + spacing;
//                if (overlap > 0f) {
//                    // we could move them the same ("overlap * 0.5f")
//                    // but we rather move more the one which is farther from the ends, as it has more space
//                    minPosition -= overlap * normalizedMinValue / (normalizedMinValue + 1-normalizedMaxValue);
//                    maxPosition += overlap * (1-normalizedMaxValue) / (normalizedMinValue + 1-normalizedMaxValue);
//                }
//                canvas.drawText(minText,
//                        minPosition,
//                        distanceToTop + textSize,
//                        paint);
//
//            }
//
//            canvas.drawText(maxText,
//                    maxPosition,
//                    distanceToTop + textSize,
//                    paint);
//        }
//    }
//}
