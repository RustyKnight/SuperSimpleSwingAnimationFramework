/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation;

/**
 *
 * @author shanewhitehead
 */
public interface AnimatableDurationListener extends AnimatableListener {
    public void animationPaused(Animatable animator);
    public void animationCompleted(Animatable animator);
    public void animationTimeChanged(AnimatableDuration animatable);
}
