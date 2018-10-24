/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation.timeline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author shanewhitehead
 */
public class AbstractTimeLine<T> implements Timeline<T> {

    private Map<Double, KeyFrame<T>> mapEvents = new HashMap<>(25);
    
    protected Map<Double, KeyFrame<T>> getEvents() {
        return mapEvents;
    }

    @Override
    public List<KeyFrame<T>> getKeyFrames() {
        return Collections.unmodifiableList(mapEvents.values().stream().collect(Collectors.toList()));
    }

    @Override
    public void addKeyFrames(List<KeyFrame<T>> keyFrames) {
        for (KeyFrame<T> kf : keyFrames) {
            mapEvents.put(kf.getProgress(), kf);
        }
    }

    @Override
    public void addKeyFrame(double progress, T value) {
        mapEvents.put(progress, new DefaultKeyFrame<T>(progress, value));
    }

    @Override
    public double getPointOnTimeLine(T value) {
        for (Map.Entry<Double, KeyFrame<T>> entry : mapEvents.entrySet()) {
            if (entry.getValue().getValue() == value) {
                return entry.getKey();
            }
        }

        return -1;
    }
    
    public List<KeyFrame<T>> getKeyFramesBetween(double progress, double delta) {

        int startAt = 0;

        List<Double> keyFrames = new ArrayList<>(mapEvents.keySet());
        while (startAt < keyFrames.size() && keyFrames.get(startAt) <= progress - delta) {
            startAt++;
        }

        startAt = Math.min(keyFrames.size() - 1, startAt);
        int endAt = startAt;
        while (endAt < keyFrames.size() && keyFrames.get(endAt) <= progress + delta) {
            endAt++;
        }
        endAt = Math.min(keyFrames.size() - 1, endAt);

        List<KeyFrame<T>> frames = new ArrayList<>(5);
        for (int index = startAt; index <= endAt; index++) {
            KeyFrame<T> keyFrame = mapEvents.get(keyFrames.get(index));
            if (keyFrame.getProgress() >= progress - delta
                    && keyFrame.getProgress() <= progress + delta) {
                frames.add(keyFrame);
            }
        }

        return frames;
    }
    
//        public List<KeyFrame<T>> getKeyFramesBetween(float progress) {
//
//        List<KeyFrame<T>> frames = new ArrayList<>(2);
//        int startAt = 0;
//        Float[] keyFrames = mapEvents.keySet().toArray(new Float[mapEvents.size()]);
//        while (startAt < keyFrames.length && keyFrames[startAt] <= progress) {
//            startAt++;
//        }
//
//        startAt = Math.min(startAt, keyFrames.length - 1);
//
//        frames.add(mapEvents.get(keyFrames[startAt - 1]));
//        frames.add(mapEvents.get(keyFrames[startAt]));
//
//        return frames;
//
//    }


}
