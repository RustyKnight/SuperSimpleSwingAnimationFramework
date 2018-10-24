/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation.ranges;

import org.kaizen.animation.AnimatableDurationListener;

/**
 *
 * @author shanewhitehead
 */
public interface AnimatableRangeListener<T> extends AnimatableDurationListener {
    public void animationChanged(AnimatableRange<T> animatable);
}
