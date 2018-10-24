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
public interface KeyFrame<T> {

    // The point along the time which the key frame appears
    public double getProgress();
    // The value of the key frame
    public T getValue();

}
