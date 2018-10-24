/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation.timeline;

import java.util.List;

/**
 * A timeline is a representation of key frames which occur along a normalized 
 * time frame (0-1)
 * @author shanewhitehead
 */
public interface Timeline<T> {
    
    public List<KeyFrame<T>> getKeyFrames();
    public void addKeyFrames(List<KeyFrame<T>> keyFrames);
    public void addKeyFrame(double progress, T value); 
    public double getPointOnTimeLine(T value);
    
}
