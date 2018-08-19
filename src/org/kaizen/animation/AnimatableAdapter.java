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
public class AnimatableAdapter<T> implements AnimatableListener<T>, AnimatableLifeCycleListener<T> {

	@Override
	public void animationChanged(Animatable<T> animator) {};

	@Override
	public void animationStopped(Animatable<T> animator) {};

	@Override
	public void animationPaused(Animatable<T> animator) {};

	@Override
	public void animationStarted(Animatable<T> animator) {};

	@Override
	public void animationCompleted(Animatable<T> animator) {};
	
}
