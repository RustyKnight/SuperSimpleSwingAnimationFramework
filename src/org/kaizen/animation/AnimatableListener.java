/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation;

/**
 *
 * @author swhitehead
 */
public interface AnimatableListener {
    public void animationChanged(Animatable animator);
    public void animationStarted(Animatable animator);
    public void animationStopped(Animatable animator);
}
