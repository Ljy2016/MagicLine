package com.czy.magicline.demo;

import android.graphics.Path;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：Ljy on 2016/12/17.
 * 邮箱：enjoy_azad@sina.com
 */

public class PathModel {
    private PointModel firstPoint;
    private PointModel secondPoint;
    private PointModel beizerPoint;
    private List<Path> pathList;

    public void setFirstPoint(PointModel firstPoint) {
        this.firstPoint = firstPoint;
    }

    public void setSecondPoint(PointModel secondPoint) {
        this.secondPoint = secondPoint;
    }

    public void setBeizerPoint(PointModel beizerPoint) {
        this.beizerPoint = beizerPoint;
    }

    //
    public List<Path> getPathList(int count) {
        pathList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Path path = new Path();
            path.moveTo(firstPoint.getCurrentX(), firstPoint.getCurrentY());
            path.lineTo(secondPoint.getCurrentX(), secondPoint.getCurrentY());
            pathList.add(path);
        }
        return pathList;
    }

    public List<Path> getBezierPathList(int count) {
        pathList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Path path = new Path();
            path.moveTo(firstPoint.getCurrentX(), firstPoint.getCurrentY());
            path.quadTo(beizerPoint.getCurrentX(), beizerPoint.getCurrentY(), secondPoint.getCurrentX(), secondPoint.getCurrentY());
            pathList.add(path);
        }
        return pathList;
    }

}
