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
public interface AnimatableLifeCycleListener<T> {
	public void animationCompleted(Animatable<T> animator);
	public void animationStarted(Animatable<T> animator);
	public void animationPaused(Animatable<T> animator);
	public void animationStopped(Animatable<T> animator);
}
