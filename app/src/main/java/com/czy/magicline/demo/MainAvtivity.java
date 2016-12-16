package com.czy.magicline.demo;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

import com.chenzy.magicline.MagicLineView;
import com.czy.magicline.demo.databinding.ActivityMainMvvmBinding;

/**
 * 作者：Ljy on 2016/12/15.
 * 邮箱：enjoy_azad@sina.com
 */

public class MainAvtivity extends Activity {
    private PointModel pointOne;
    private PointModel pointTwo;
    private PointModel bezierPoint;
    private ActivityMainMvvmBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_mvvm);
        pointOne = new PointModel();
        pointTwo = new PointModel();
        bezierPoint = new PointModel();
        binding.setPoint(pointOne);
        init();
    }

    private void init() {
        binding.setMyClick(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn_conform:
                        Log.e("TAG", "onClick: " + "点击了");
                        binding.myview.setPointOne(pointOne);
                        binding.myview.setPointTwo(pointTwo);
                        binding.myview.setBezierPoint(bezierPoint);
                        binding.myview.setVisibility(View.VISIBLE);
                        binding.myview.setIsBezier(binding.isBezier.isChecked());
                        binding.myview.startDraw();
                        break;
                    case R.id.firstPoint:
                        changeBackground(view.getId());
                        binding.setPoint(pointOne);
                        break;
                    case R.id.secondPoint:
                        changeBackground(view.getId());
                        binding.setPoint(pointTwo);
                        break;
                    case R.id.bezierPoint:
                        changeBackground(view.getId());
                        binding.setPoint(bezierPoint);
                        break;
                    case R.id.myview:
                        view.setVisibility(View.GONE);
                        break;
                }
            }
        });

    }

    private void changeBackground(int id) {
        binding.firstPoint.setBackgroundColor(id == R.id.firstPoint ? Color.parseColor("#ff0000") : Color.parseColor("#999999"));
        binding.secondPoint.setBackgroundColor(id == R.id.secondPoint ? Color.parseColor("#ff0000") : Color.parseColor("#999999"));
        binding.bezierPoint.setBackgroundColor(id == R.id.bezierPoint ? Color.parseColor("#ff0000") : Color.parseColor("#999999"));
    }

    private MagicLineViewPlus.DrawingListener drawingListener = new MagicLineViewPlus.DrawingListener() {
        @Override
        public void drawStart() {

        }

        @Override
        public void drawOver() {

        }
    };
}
