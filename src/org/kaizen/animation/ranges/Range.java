/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation.ranges;

public abstract class Range<T> {

    private T from;
    private T to;

    public Range(T from, T to) {
        this.from = from;
        this.to = to;
    }

    public T getFrom() {
        return from;
    }

    public T getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "From " + getFrom() + " to " + getTo();
    }

    public abstract T valueAt(double progress);

    public void reverse() {
        T nextFrom = to;
        to = from;
        from = nextFrom;
    }
    
}
