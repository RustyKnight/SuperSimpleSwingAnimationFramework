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
public class FloatRange extends Range<Float> {

    public FloatRange(Float from, Float to) {
        super(from, to);
    }

    public Float getDistance() {
        return getTo() - getFrom();
    }

    @Override
    public Float valueAt(double progress) {
        float distance = getDistance();
        float value = distance * (float)progress;
        value += getFrom();
        return value;
    }

}
