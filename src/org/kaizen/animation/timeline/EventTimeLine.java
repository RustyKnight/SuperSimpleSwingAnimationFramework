/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation.timeline;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A event time line, which will return all the points which occur at a specified,
 * normalized, point along the timeline
 * @author shanewhitehead
 * @param <T> 
 */
public class EventTimeLine<T> extends AbstractTimeLine<T> {

    public EventTimeLine() {
    }

    public List<T> getEventsAt(double progress) {

        if (progress < 0) {
            progress = 0;
        } else if (progress > 1) {
            progress = 1;
        }

        return getKeyFramesBetween(progress, 0.01f)
                .stream()
                .map(kf -> kf.getValue())
                .collect(Collectors.toList());
    }

    public List<KeyFrame<T>> getKeyFramesBetween(double progress, double delta) {
        List<KeyFrame<T>> keyFrames = getKeyFrames();

        List<KeyFrame<T>> frames = new ArrayList<>(5);
        for (KeyFrame<T> keyFrame : keyFrames) {
            if (keyFrame.getProgress() >= progress - delta && keyFrame.getProgress() <= progress + delta) {
                frames.add(keyFrame);
            }
        }
        return frames;
    }

}

