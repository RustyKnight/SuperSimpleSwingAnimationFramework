/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation.ranges;

import java.time.Duration;
import org.kaizen.animation.AbstractAnimatableDuration;
import org.kaizen.animation.AnimatableListener;
import org.kaizen.animation.curves.AnimationCurve;

/**
 *
 * @author shanewhitehead
 */
public class AbstractAnimatableRange<T> extends AbstractAnimatableDuration implements AnimatableRange<T>{
    
    private Range<T> range;
    private T value;
    
    private AnimatableRangeListener<T> listener;

    public AbstractAnimatableRange(Range<T> range, Duration duration, AnimationCurve curve, AnimatableRangeListener<T> listener) {
        super(duration, curve, listener);
        this.listener = listener;
        this.range = range;
        this.value = range.getFrom();
    }

    @Override
    public Range<T> getRange() {
        return range;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public void tick() {
        double rawProgress = getRawProgress();
        double progress = getCurrentProgress(rawProgress);
        if (rawProgress >= 1.0) {
            progress = 1.0;
        }
        value = getRange().valueAt(progress);
        fireAnimationChanged();
        if (rawProgress >= 1.0) {
            completed();
        }
    }

    @Override
    protected void fireAnimationChanged() {
        super.fireAnimationChanged();
        if (listener == null) {
            return;
        }
        listener.animationChange(this);
    }

}
