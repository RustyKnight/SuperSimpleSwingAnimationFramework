/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation;

public class DefaultAnimatable implements Animatable {

    private AnimatableListener animatableListener;
    
    private boolean animating = false;

    public DefaultAnimatable(AnimatableListener listener) {
        this.animatableListener = listener;
    }

    public boolean isAnimating() {
        return animating;
    }

    protected void setAnimating(boolean animating) {
        this.animating = animating;
    }

    @Override
    public void tick() {
        fireAnimationChanged();
    }

    @Override
    public void start() {
        if (isAnimating()) {
            return;
        }
        fireAnimationStarted();
        setAnimating(true);
        Animator.INSTANCE.add(this);
    }

    @Override
    public void stop() {
        if (!isAnimating()) {
            return;
        }
        setAnimating(false);
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
    
    public static class AnimatableListenerAdaptor implements AnimatableListener {

        @Override
        public void animationChanged(Animatable animator) {
        }

        @Override
        public void animationStarted(Animatable animator) {
        }

        @Override
        public void animationStopped(Animatable animator) {
        }
        
    }

}
