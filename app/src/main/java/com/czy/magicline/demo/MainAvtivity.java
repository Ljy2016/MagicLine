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
    private ActivityMainMvvmBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_mvvm);
        pointOne = new PointModel();
        pointTwo = new PointModel();
        binding.setPoint(pointOne);
        init();
    }

    private void init() {
        binding.setMyClick(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.conform:
                        binding.myview.setPointOne(pointOne);
                        binding.myview.setPointTwo(pointTwo);
                        binding.myview.setVisibility(View.VISIBLE);
                        binding.myview.startDraw();
                        break;
                    case R.id.firstPoint:
                        binding.setPoint(pointOne);
                        break;
                    case R.id.secondPint:
                        binding.setPoint(pointTwo);
                        break;
                    case R.id.myview:
                        view.setVisibility(View.GONE);
                        break;
                }
            }
        });

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
