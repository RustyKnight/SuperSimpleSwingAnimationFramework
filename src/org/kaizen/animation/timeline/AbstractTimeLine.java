/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation.timeline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author shanewhitehead
 */
public class AbstractTimeLine<T> implements Timeline<T> {

    private List<KeyFrame<T>> keyframes = new ArrayList<>(25);

    @Override
    public List<KeyFrame<T>> getKeyFrames() {
        return keyframes;
    }

    @Override
    public void addKeyFrames(List<KeyFrame<T>> keyFrames) {        
        this.keyframes.addAll(keyFrames);
        Collections.sort(this.keyframes, keyFrameComparator);
    }

    @Override
    public void addKeyFrame(double progress, T value) {
        this.keyframes.add(new DefaultKeyFrame<T>(progress, value));
        Collections.sort(this.keyframes, keyFrameComparator);
    }

    @Override
    public double getPointOnTimeLine(T value) {
        for (KeyFrame<T> keyframe : keyframes) {
            if (keyframe.getValue() == value) {
                return keyframe.getProgress();
            }
        }
        return -1;
    }
 
    private Comparator<KeyFrame> keyFrameComparator = new Comparator<KeyFrame>() {
        @Override
        public int compare(KeyFrame o1, KeyFrame o2) {
            if (o1.getProgress() < o2.getProgress()) {
                return -1;
            } else if (o1.getProgress() > o2.getProgress()) {
                return 1;
            }

            return 0;
        }
    };
}
