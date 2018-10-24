/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation.timeline;

/**
 *
 * @author shanewhitehead
 */
public class DefaultKeyFrame<T> implements KeyFrame<T> {
    
    private double progress;
    private T value;

    public DefaultKeyFrame(double progress, T value) {
        this.progress = progress;
        this.value = value;
    }

    public double getProgress() {
        return progress;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "KeyFrame progress = " + getProgress() + "; value = " + getValue();
    }
    
}
