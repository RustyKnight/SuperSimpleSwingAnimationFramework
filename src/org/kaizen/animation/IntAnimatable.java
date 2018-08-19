/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation;

import java.time.Duration;
import org.kaizen.animation.easement.Easement;

public class IntAnimatable extends AbstractAnimatable<Integer> {

	public IntAnimatable(IntRange range, Duration duration, Easement easement, AnimatableListener<Integer> listener, AnimatableLifeCycleListener<Integer> lifeCycleListener) {
		super(range, duration, easement, listener, lifeCycleListener);
	}

}
