/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation.timeline;

public class FloatBlender implements BlendingTimeLine.Blender<Float> {

    @Override
    public Float blend(Float start, Float end, double ratio) {
        double ir = (int) 1.0 - ratio;
        return (float)(start * ratio + end * ir);
    }

}
