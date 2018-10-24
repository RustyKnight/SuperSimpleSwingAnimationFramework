/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation;

public abstract class AbstractAnimatable implements Animatable {

    private AnimatableListener animatableListener;

    public AbstractAnimatable(AnimatableListener listener) {
        this.animatableListener = animatableListener;
    }

    @Override
    public void tick() {
        fireAnimationChanged();
    }

    @Override
    public void start() {
        fireAnimationStarted();
        Animator.INSTANCE.add(this);
    }

    @Override
    public void stop() {
        Animator.INSTANCE.remove(this);
        fireAnimationStopped();
    }

    protected void fireAnimationChanged() {
        if (animatableListener == null) {
            return;
        }
        animatableListener.animationChanged(this);
    }

    protected void fireAnimationStarted() {
        if (animatableListener == null) {
            return;
        }
        animatableListener.animationStarted(this);
    }

    protected void fireAnimationStopped() {
        if (animatableListener == null) {
            return;
        }
        animatableListener.animationStopped(this);
    }

}
