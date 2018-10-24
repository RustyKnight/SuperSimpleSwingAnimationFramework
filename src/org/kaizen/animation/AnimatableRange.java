/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation;

import java.time.Duration;
import org.kaizen.animation.easement.Easement;

/**
 *
 * @author shanewhitehead
 */
public interface AnimatableRange<T> extends AnimatableDuration {

    public Range<T> getRange();
    public T getValue();

}
