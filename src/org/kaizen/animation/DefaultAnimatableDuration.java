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
public class DefaultAnimatableDuration extends DefaultAnimatable implements AnimatableDuration {

    protected enum State {
        RUNNING, STOPPED, PAUSED;
    }

    private Instant startTime;
    private Duration duration = Duration.ofSeconds(5);
    private AnimationCurve curve;
    private double rawOffset;

    private AnimatableDurationListener durationAnimatableListener;

    private State state;

    public DefaultAnimatableDuration(Duration duration, AnimationCurve easement, AnimatableDurationListener listener) {
        super(listener);
        this.durationAnimatableListener = listener;
        this.curve = easement;
        this.duration = duration;
    }

    public Duration getDuration() {
        return duration;
    }

    public Duration getRemainingDuration() {
        if (startTime == null && state == State.PAUSED) {
            return duration;
        } else if (startTime == null && state == State.STOPPED) {
            return Duration.ZERO;
        }
        Duration duration = getDuration();
        Duration runningTime = Duration.between(startTime, Instant.now());

        return duration.minus(runningTime);
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
        if (startTime == null) {
            stop();
        }
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
        state = State.RUNNING;
        super.start();
    }

    @Override
    public void stop() {
        state = State.STOPPED;
        startTime = null;
        super.stop();
    }

    @Override
    public void pause() {
        rawOffset += getRawProgress();
        Animator.INSTANCE.remove(this);

        double remainingProgress = 1.0 - rawOffset;
        Duration remainingTime = getDuration().minusMillis((long) remainingProgress);
        duration = remainingTime;

        state = State.PAUSED;

        fireAnimationPaused();
    }

    protected void completed() {
        stop();
        fireAnimationCompleted();
    }

    @Override
    protected void fireAnimationChanged() {
        durationAnimatableListener.animationTimeChanged(this);
        super.fireAnimationChanged();
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
