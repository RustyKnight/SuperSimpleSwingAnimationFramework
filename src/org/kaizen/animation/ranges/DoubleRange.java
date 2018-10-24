/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation.ranges;

/**
 *
 * @author shanewhitehead
 */
public class DoubleRange extends Range<Double> {

    public DoubleRange(Double from, Double to) {
        super(from, to);
    }

    public Double getDistance() {
        return getTo() - getFrom();
    }

    @Override
    public Double valueAt(double progress) {
        double distance = getDistance();
        double value = (double) Math.round(distance * progress);
        value += getFrom();
        return value;
    }

}
