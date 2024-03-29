/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation;

public class DefaultAnimatable implements Animatable {

    private AnimatableListener animatableListener;
    
    private boolean running = false;

    public DefaultAnimatable(AnimatableListener listener) {
        this.animatableListener = listener;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    protected void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void tick() {
        fireAnimationChanged();
    }

    @Override
    public void start() {
        if (isRunning()) {
            return;
        }
        fireAnimationStarted();
        setRunning(true);
        Animator.INSTANCE.add(this);
    }

    @Override
    public void stop() {
        if (!isRunning()) {
            return;
        }
        setRunning(false);
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
