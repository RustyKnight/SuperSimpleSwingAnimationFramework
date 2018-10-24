/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation.ranges;

import org.kaizen.animation.ranges.Range;
import java.time.Duration;
import org.kaizen.animation.AnimatableDuration;
import org.kaizen.animation.curves.AnimationCurve;

/**
 *
 * @author shanewhitehead
 */
public interface AnimatableRange<T> extends AnimatableDuration {

    public Range<T> getRange();
    public T getValue();

}
