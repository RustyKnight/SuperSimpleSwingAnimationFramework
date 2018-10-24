/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation.ranges;

import java.time.Duration;
import org.kaizen.animation.curves.AnimationCurve;

public class DoubleAnimatable extends AbstractAnimatableRange<Double> {

    public DoubleAnimatable(DoubleRange range, Duration duration, AnimationCurve curve, AnimatableRangeListener<Double> listener) {
        super(range, duration, curve, listener);
    }

}
