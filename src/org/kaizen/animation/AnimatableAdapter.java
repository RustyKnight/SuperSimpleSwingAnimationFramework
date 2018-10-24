/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation;

import org.kaizen.animation.ranges.AnimatableRange;
import org.kaizen.animation.ranges.AnimatableRangeListener;

/**
 *
 * @author swhitehead
 */
public class AnimatableAdapter<T> implements AnimatableListener, DurationAnimatableListener, AnimatableRangeListener<T> {

    @Override
    public void animationChanged(Animatable animator) {
    }

    @Override
    public void animationStarted(Animatable animator) {
    }

    @Override
    public void animationStopped(Animatable animator) {
    }

    @Override
    public void animationPaused(Animatable animator) {
    }

    @Override
    public void animationCompleted(Animatable animator) {
    }

    @Override
    public void animationChange(AnimatableRange<T> animatable) {
    }

}
