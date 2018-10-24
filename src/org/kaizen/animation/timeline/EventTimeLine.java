/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation.timeline;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
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

    public List<T> getValues() {
        return Collections.unmodifiableList(getEvents().values().stream()
                .map(kf -> kf.getValue())
                .collect(Collectors.toList()));
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

//    public List<KeyFrame<T>> getKeyFramesBetween(double progress, double delta) {
//
//        int startAt = 0;
//
//        List<Double> keyFrames = new ArrayList<>(mapEvents.keySet());
//        while (startAt < keyFrames.size() && keyFrames.get(startAt) <= progress - delta) {
//            startAt++;
//        }
//
//        startAt = Math.min(keyFrames.size() - 1, startAt);
//        int endAt = startAt;
//        while (endAt < keyFrames.size() && keyFrames.get(endAt) <= progress + delta) {
//            endAt++;
//        }
//        endAt = Math.min(keyFrames.size() - 1, endAt);
//
//        List<KeyFrame<T>> frames = new ArrayList<>(5);
//        for (int index = startAt; index <= endAt; index++) {
//            KeyFrame<T> keyFrame = mapEvents.get(keyFrames.get(index));
//            if (keyFrame.getProgress() >= progress - delta
//                    && keyFrame.getProgress() <= progress + delta) {
//                frames.add(keyFrame);
//            }
//        }
//
//        return frames;
//
//    }


}

