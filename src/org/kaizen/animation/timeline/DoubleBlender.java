/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation.timeline;

public class DoubleBlender implements BlendingTimeLine.Blender<Double> {

    @Override
    public Double blend(Double start, Double end, double ratio) {
        double ir = (double) 1.0 - ratio;
        double value = start + ((end - start) * ir);
        return value;
    }

}
