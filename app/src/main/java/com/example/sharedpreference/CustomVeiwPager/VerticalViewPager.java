package com.example.sharedpreference.CustomVeiwPager;

import android.content.Context;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.PageTransformer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class VerticalViewPager extends ViewPager {

    float downX;

    public VerticalViewPager(@NonNull Context context) {
        super(context);
        init();
    }

    public VerticalViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {

        setPageTransformer(true, new VerticalPageTransformer());


    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent ev) {

        boolean intercepted = super.onInterceptTouchEvent(swapXY(ev));
        swapXY(ev);
        return intercepted;

//        boolean wasSwipeToRight = this.wasSwipeToRightEvent(ev);
//        return super.onInterceptTouchEvent(ev);


    }

    private MotionEvent swapXY(MotionEvent ev) {


        float width = getWidth();
        float height = getHeight();

        float newX = (ev.getY() / height) * width;
        float newY = (ev.getX() / width) * height;


        Log.d("Motioin_Event", newX +  " = " + newY);

        ev.setLocation(newX, newY);

        return ev;



    }

    private boolean wasSwipeToRightEvent(MotionEvent event){
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = event.getX();
                return false;

            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
                return downX - event.getX() > 0;

            default:
                return false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);

    }

    class VerticalPageTransformer implements PageTransformer {

        private static final float MIN_SCALE = 0.75f;

        @Override
        public void transformPage(@NonNull View view, float position) {

            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            float alpha = 0;

//            if (0 <= position && position <= 1) {
//                alpha = 1 - position;
//            }
//            else if (-1 < position && position < 0)
//            {

//            if (true) {

                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float verticalMargin = pageHeight * (1 - scaleFactor) / 2;
                float horizontalMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horizontalMargin - verticalMargin / 2);
                } else {
                    view.setTranslationX(-horizontalMargin + verticalMargin / 2);
                }

                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                alpha = position + 1;
//           }

//                view.setAlpha(alpha);
                view.setTranslationX(view.getWidth() * -position);
                float yPosition = position * view.getHeight();
                view.setTranslationY(yPosition);
            }

//        }

//            if (pos < -1)
//            {
//                view.setAlpha(0);
//            }
//            else if (pos <= 1)
//            {
//                view.setAlpha(1);
//
//
//                float XPos = view.getWidth() * - pos;
//                view.setTranslationX(XPos);
//
//                float YPos = pos * view.getHeight();
//                view.setTranslationY(YPos);
//
//            }
//            else
//            {
//                view.setAlpha(0);
//            }



//        }


    }

}



