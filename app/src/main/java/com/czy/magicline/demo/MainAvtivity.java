package com.czy.magicline.demo;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import com.chenzy.magicline.MagicLineView;
import com.czy.magicline.demo.databinding.ActivityMainMvvmBinding;

/**
 * 作者：Ljy on 2016/12/15.
 * 邮箱：enjoy_azad@sina.com
 */

public class MainAvtivity extends Activity {
    //第一个点
    private PointModel pointOne;
    //第二个点
    private PointModel pointTwo;
    //贝塞尔曲线运动的控制点
    private PointModel bezierPoint;
    //databinding生成的类
    private ActivityMainMvvmBinding binding;
    //路径生成类
    private PathModel pathModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_mvvm);
        DisplayMetrics dm = new DisplayMetrics();
        // 获取屏幕信息
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int centerX = dm.widthPixels/2;
        int centerY = dm.heightPixels/2;
        pointOne = new PointModel(centerX, centerY);
        pointTwo = new PointModel(centerX, centerY);
        bezierPoint = new PointModel(centerX, centerY);
        pathModel = new PathModel();
        binding.setPoint(pointOne);
        changeBackground(R.id.firstPoint);
        init();
    }

    private void init() {
        binding.setMyClick(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn_conform:
                        pathModel.setFirstPoint(pointOne);
                        pathModel.setSecondPoint(pointTwo);
                        //勾选贝塞尔路径
                        if (binding.isBezier.isChecked()) {
                            pathModel.setBeizerPoint(bezierPoint);
                            binding.myview.setPathList(pathModel.getBezierPathList(1000));
                        } else {
                            binding.myview.setPathList(pathModel.getPathList(1000));
                        }
                        binding.myview.setVisibility(View.VISIBLE);
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
                        binding.myview.stopDraw();
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
}
