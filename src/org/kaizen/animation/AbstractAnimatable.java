/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation;

import java.time.Duration;
import java.time.LocalDateTime;
import org.kaizen.animation.easement.Easement;

public abstract class AbstractAnimatable<T> implements Animatable<T> {

	private Range<T> range;
	private LocalDateTime startTime;
	private Duration duration = Duration.ofSeconds(5);
	private T value;
	private AnimatableListener<T> animatableListener;
	private AnimatableLifeCycleListener<T> lifeCycleListener;
	private Easement easement;
	private double rawOffset;

	public AbstractAnimatable(Range<T> range, Duration duration, AnimatableListener<T> listener) {
		this.range = range;
		this.value = range.getFrom();
		this.animatableListener = listener;
	}

	public AbstractAnimatable(Range<T> range, Duration duration, AnimatableListener<T> listener, AnimatableLifeCycleListener<T> lifeCycleListener) {
		this(range, duration, listener);
		this.lifeCycleListener = lifeCycleListener;
	}

	public AbstractAnimatable(Range<T> range, Duration duration, Easement easement, AnimatableListener<T> listener) {
		this(range, duration, listener);
		this.easement = easement;
	}

	public AbstractAnimatable(Range<T> range, Duration duration, Easement easement, AnimatableListener<T> listener, AnimatableLifeCycleListener<T> lifeCycleListener) {
		this(range, duration, easement, listener);
		this.lifeCycleListener = lifeCycleListener;
	}

	public void setLifeCycleListener(AnimatableLifeCycleListener<T> lifeCycleListener) {
		this.lifeCycleListener = lifeCycleListener;
	}

	public void setEasement(Easement easement) {
		this.easement = easement;
	}

	@Override
	public Easement getEasement() {
		return easement;
	}

	public Duration getDuration() {
		return duration;
	}

	public Range<T> getRange() {
		return range;
	}

	public void setRange(Range<T> range) {
		this.range = range;
	}

	@Override
	public T getValue() {
		return value;
	}

	protected void setDuration(Duration duration) {
		this.duration = duration;
	}

	public double getCurrentProgress(double rawProgress) {
		Easement easement = getEasement();
		double progress = Math.min(1.0, Math.max(0.0, getRawProgress()));
		if (easement != null) {
			progress = easement.calculate(progress);
		}
		return progress;
	}

	public double getRawProgress() {
		if (startTime == null) {
			return 0.0;
		}
		Duration duration = getDuration();
		Duration runningTime = Duration.between(startTime, LocalDateTime.now());
		double progress = rawOffset + (runningTime.toMillis() / (double) duration.toMillis());

		return Math.min(1.0, Math.max(0.0, progress));
	}

	@Override
	public void tick() {
		if (startTime == null) {
			startTime = LocalDateTime.now();
			fireAnimationStarted();
		}
		double rawProgress = getRawProgress();
		double progress = getCurrentProgress(rawProgress);
		if (rawProgress >= 1.0) {
			progress = 1.0;
		}
		value = getRange().valueAt(progress);
		fireAnimationChanged();
		if (rawProgress >= 1.0) {
			fireAnimationCompleted();
		}
	}

	@Override
	public void start() {
		if (startTime != null) {
			// Restart?
			return;
		}
		Animator.INSTANCE.add(this);
	}

	@Override
	public void stop() {
		stopWithNotitifcation(true);
	}

	@Override
	public void pause() {
		rawOffset += getRawProgress();
		stopWithNotitifcation(false);

		double remainingProgress = 1.0 - rawOffset;
		Duration remainingTime = getDuration().minusMillis((long) remainingProgress);
		setDuration(remainingTime);

		lifeCycleListener.animationStopped(this);
	}

	protected void fireAnimationChanged() {
		if (animatableListener == null) {
			return;
		}
		animatableListener.animationChanged(this);
	}

	protected void fireAnimationCompleted() {
		stopWithNotitifcation(false);
		if (lifeCycleListener == null) {
			return;
		}
		lifeCycleListener.animationCompleted(this);
	}
	
	protected void fireAnimationStarted() {
		if (lifeCycleListener == null) {
			return;
		}
		lifeCycleListener.animationStarted(this);
	}
	
	protected void fireAnimationPaused() {
		if (lifeCycleListener == null) {
			return;
		}
		lifeCycleListener.animationPaused(this);
	}

	protected void stopWithNotitifcation(boolean notify) {
		Animator.INSTANCE.remove(this);
		startTime = null;
		if (notify) {
			if (lifeCycleListener == null) {
				return;
			}
			lifeCycleListener.animationStopped(this);
		}
	}

}
