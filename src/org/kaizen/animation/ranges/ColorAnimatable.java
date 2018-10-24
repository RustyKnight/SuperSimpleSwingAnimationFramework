/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation.ranges;

import java.awt.Color;
import java.time.Duration;
import org.kaizen.animation.curves.AnimationCurve;

public class ColorAnimatable extends AbstractAnimatableRange<Color> {

    public ColorAnimatable(ColorRange animationRange, Duration duration, AnimationCurve curve, AnimatableRangeListener<Color> listener) {
        super(animationRange, duration, curve, listener);
    }

}
