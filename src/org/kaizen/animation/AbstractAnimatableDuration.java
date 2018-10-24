/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import org.kaizen.animation.curves.AnimationCurve;

/**
 *
 * @author shanewhitehead
 */
public class AbstractAnimatableDuration extends AbstractAnimatable implements AnimatableDuration {

    private Instant startTime;
    private Duration duration = Duration.ofSeconds(5);
    private AnimationCurve curve;
    private double rawOffset;

    private DurationAnimatableListener durationAnimatableListener;

    public AbstractAnimatableDuration(Duration duration, AnimationCurve easement, DurationAnimatableListener listener) {
        super(listener);
        this.durationAnimatableListener = listener;
        this.curve = easement;
        this.duration = duration;
    }

    public Duration getDuration() {
        return duration;
    }

    @Override
    public AnimationCurve getCurve() {
        return curve;
    }

    @Override
    public double getProgress() {
        return getCurrentProgress(getRawProgress());
    }

    protected double getCurrentProgress(double rawProgress) {
        AnimationCurve curve = getCurve();
        double progress = Math.min(1.0, Math.max(0.0, getRawProgress()));
        if (curve != null) {
            progress = curve.calculate(progress);
        }
        return progress;
    }

    protected double getRawProgress() {
        if (startTime == null) {
            return 0.0;
        }
        Duration duration = getDuration();
        Duration runningTime = Duration.between(startTime, Instant.now());
        double progress = rawOffset + (runningTime.toMillis() / (double) duration.toMillis());

        return Math.min(1.0, Math.max(0.0, progress));
    }

    @Override
    public void tick() {
        double rawProgress = getRawProgress();
        fireAnimationChanged();
        if (rawProgress >= 1.0) {
            completed();
        }
    }

    @Override
    public void start() {
        if (startTime != null) {
            return;
        }
        startTime = Instant.now();
        super.start();
    }

    @Override
    public void pause() {
        rawOffset += getRawProgress();
        Animator.INSTANCE.remove(this);

        double remainingProgress = 1.0 - rawOffset;
        Duration remainingTime = getDuration().minusMillis((long) remainingProgress);
        duration = remainingTime;

        fireAnimationPaused();
    }

    protected void completed() {
        stop();
        fireAnimationCompleted();
    }

    protected void fireAnimationPaused() {
        if (durationAnimatableListener == null) {
            return;
        }
        durationAnimatableListener.animationPaused(this);
    }

    protected void fireAnimationCompleted() {
        if (durationAnimatableListener == null) {
            return;
        }
        durationAnimatableListener.animationCompleted(this);
    }
}
