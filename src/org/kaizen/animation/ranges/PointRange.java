/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation.ranges;

import java.awt.Point;

/**
 *
 * @author shane.whitehead
 */
public class PointRange extends Range<Point> {

    public PointRange(Point from, Point to) {
        super(from, to);
    }

    public int getXDistance() {
        return getTo().x - getFrom().x;
    }

    public int getYDistance() {
        return getTo().y - getFrom().y;
    }
    
    protected int getFromX() {
        return getFrom().x;
    }
    
    protected int getFromY() {
        return getFrom().y;
    }

    @Override
    public Point valueAt(double progress) {
        int xDistance = getXDistance();
        int yDistance = getYDistance();
        
        int xValue = (int) Math.round((double) xDistance * progress);
        int yValue = (int) Math.round((double) yDistance * progress);
        
        xValue += getFromX();
        yValue += getFromY();

        return new Point(xValue, yValue);
    }
}
