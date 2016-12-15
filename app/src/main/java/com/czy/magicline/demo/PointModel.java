package com.czy.magicline.demo;

import android.net.ParseException;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * 作者：Ljy on 2016/12/14.
 * 邮箱：enjoy_azad@sina.com
 */

public class PointModel {
    //运动路径中心x坐标
    private int centerX=540;
    //运动路径中心y坐标
    private int centerY=960;
    //x轴最大值
    private int maxX=500;
    //y轴最大值
    private int maxY=500;
    //运动角速度
    private float palstance=0.5f;
    //当前x坐标
    private int currentX;
    //当前y坐标
    private int currentY;

    public String getCenterX() {
        return centerX + "";
    }

    public void setCenterX(String centerX) {
        try {
            this.centerX = Integer.parseInt(centerX);
        } catch (Exception e) {
            this.centerX = 0;
        }
    }

    public String getCenterY() {
        return centerY + "";
    }

    public void setCenterY(String centerY) {
        try {
            this.centerY = Integer.parseInt(centerY);
        } catch (Exception e) {
            this.centerY = 0;
        }
    }

    public String getMaxX() {
        return maxX + "";
    }

    public void setMaxX(String maxX) {
        try {
            this.maxX = Integer.parseInt(maxX);
        } catch (Exception e) {
            this.maxX = 0;
        }
    }

    public String getMaxY() {
        return maxY + "";
    }

    public void setMaxY(String maxY) {
        try {
            this.maxY = Integer.parseInt(maxY);
        } catch (Exception e) {
            this.maxY = 0;
        }
    }

    public String getPalstance() {
        return palstance + "";
    }

    public void setPalstance(String palstance) {
        try {
            this.palstance = Float.parseFloat(palstance);
        } catch (Exception e) {
            this.palstance = 0;
        }
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    //暂定点进行圆周运动 通过传入的弧度计算出当前点的位置参数currentX，currentY
    public void setCurrentX(float radina) {
        currentX = (int) (maxX * Math.cos(radina) + centerX);
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }

    public void setCurrentY(float radina) {
        currentY = (int) (maxY * Math.sin(radina) + centerY);
    }
}
