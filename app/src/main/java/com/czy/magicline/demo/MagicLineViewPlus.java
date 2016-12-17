package com.czy.magicline.demo;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 简单的规律绘制直线构造神奇的视觉效果
 * 启发、原理:http://mp.weixin.qq.com/s/FieNhelCar1cZjhBS28ymQ
 * Created by zhangyu on 2016/9/7.
 */
public class MagicLineViewPlus extends View {
    private static final String TAG = "MagicLineView";
    private Paint paint;
    //动画 用于更改绘图的path数目
    private ValueAnimator valueAnimator;
    //动画监听
    private DrawingListener drawingListener;
    //需要绘制的path集合
    private List<Path> pathList;

    public void setPathList(List<Path> pathList) {
        this.pathList = pathList;
    }

    //动画绘制的时间
    private int animDuration = 1000 * 15;
    //需要绘制的path数目
    private int count;

    public MagicLineViewPlus(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MagicLineViewPlus(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public MagicLineViewPlus(Context context) {
        super(context);
        init();
    }

    private void init() {
        setBackgroundColor(Color.BLACK);
        valueAnimator = ValueAnimator.ofFloat(0f, 1f);
        valueAnimator.setDuration(animDuration);
        valueAnimator.addUpdateListener(animatorUpdateListener);
        valueAnimator.addListener(animatorListener);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.WHITE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < count; i++) {
            canvas.drawPath(pathList.get(i), paint);
        }

    }

    private ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() {
        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            //所绘制的path数组自增1
            count++;
            if (count < pathList.size()) {
                invalidate();
            }
        }
    };

    private Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {
            if (null != drawingListener)
                drawingListener.drawStart();

        }

        @Override
        public void onAnimationEnd(Animator animation) {
            if (null != drawingListener)
                drawingListener.drawOver();
        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
    };

    /**
     * 开始绘制
     */
    public void startDraw() {
        count = 0;
        valueAnimator.start();
    }

    /**
     * 停止绘制
     */
    public void stopDraw() {
        count = 0;
        valueAnimator.cancel();
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if (hasWindowFocus) {
//            viewWidth = getWidth();
//            viewHeight = getHeight();
        }
    }

    public void setDrawingListener(DrawingListener drawingListener) {
        this.drawingListener = drawingListener;
    }

    public interface DrawingListener {
        void drawStart();

        void drawOver();
    }
}
