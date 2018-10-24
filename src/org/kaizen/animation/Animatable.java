/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation;

import java.time.Duration;
import org.kaizen.animation.curves.AnimationCurve;

public interface Animatable {

    public void tick();

    // Wondering if these should be part of a secondary interface
    // Provide a "self managed" unit of work
    public void start();
    public void stop();

}
