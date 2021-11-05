/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation.ranges;

import java.awt.Point;
import java.time.Duration;
import org.kaizen.animation.curves.AnimationCurve;

public class PointAnimatableRange extends DefaultAnimatableRange<Point> {

    public PointAnimatableRange(PointRange range, Duration duration, AnimationCurve curve, AnimatableRangeListener<Point> listener) {
        super(range, duration, curve, listener);
    }

}

