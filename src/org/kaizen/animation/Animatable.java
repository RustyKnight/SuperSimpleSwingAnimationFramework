/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation;

import java.time.Duration;
import org.kaizen.animation.easement.Easement;

public interface Animatable<T> {

	public Range<T> getRange();
	public T getValue();
	public void tick();
	public Duration getDuration();
	public Easement getEasement();
	
	// Wondering if these should be part of a secondary interface
	// Provide a "self managed" unit of work
	public void start();
	public void stop();
	public void pause();
	
}
