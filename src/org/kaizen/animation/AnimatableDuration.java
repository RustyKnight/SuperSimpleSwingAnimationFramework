/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation;

import java.time.Duration;
import org.kaizen.animation.curves.AnimationCurve;

/**
 *
 * @author shanewhitehead
 */
public interface AnimatableDuration extends Animatable, PausableAnimatable {
    // Returns the amount of time that this animation
    // has played as a percantage of the playable duration
    // 0-1
    public double getProgress();
    public Duration getDuration();
    public AnimationCurve getCurve();
}
