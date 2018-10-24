/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation.timeline;

public class IntBlender implements BlendingTimeLine.Blender<Integer> {

    @Override
    public Integer blend(Integer start, Integer end, double ratio) {
        double ir = (int) 1.0 - ratio;
        return (int)(start * ratio + end * ir);
    }

}
