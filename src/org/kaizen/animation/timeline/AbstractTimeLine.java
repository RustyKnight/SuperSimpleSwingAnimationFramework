/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation.timeline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author shanewhitehead
 */
public class AbstractTimeLine<T> implements Timeline<T> {

//    private Map<Double, KeyFrame<T>> mapEvents = new HashMap<>(25);
    private List<KeyFrame<T>> keyframes = new ArrayList<>(25);
//
//    protected Map<Double, KeyFrame<T>> getEvents() {
//        return mapEvents;
//    }
//
//    protected List<Double> getEventKeys() {
//        return orderedEventKeys;
//    }

    @Override
    public List<KeyFrame<T>> getKeyFrames() {
        return keyframes;
    }
//
//    @Override
//    public List<KeyFrame<T>> getKeyFrames() {
//        Comparator<KeyFrame> comparator = new Comparator<KeyFrame>() {
//            @Override
//            public int compare(KeyFrame o1, KeyFrame o2) {
//                if (o1.getProgress() < o2.getProgress()) {
//                    return -1;
//                } else if (o1.getProgress() > o2.getProgress()) {
//                    return 1;
//                }
//                
//                return 0;
//            }
//        };
//        
//        List<KeyFrame<T>> sorted = mapEvents.values()
//                .stream()
//                .sorted(comparator)
//                .collect(Collectors.toList());
//
//        return Collections.unmodifiableList(sorted);
//    }

    @Override
    public void addKeyFrames(List<KeyFrame<T>> keyFrames) {        
        this.keyframes.addAll(keyFrames);
        Collections.sort(this.keyframes, keyFrameComparator);
//        for (KeyFrame<T> kf : keyFrames) {
//            mapEvents.put(kf.getProgress(), kf);
//            orderedEventKeys.add(kf.getProgress());
//        }
    }

    @Override
    public void addKeyFrame(double progress, T value) {
//        mapEvents.put(progress, new DefaultKeyFrame<T>(progress, value));
//        orderedEventKeys.add(kf.getProgress());
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
//        
//        for (Map.Entry<Double, KeyFrame<T>> entry : mapEvents.entrySet()) {
//            if (entry.getValue().getValue() == value) {
//                return entry.getKey();
//            }
//        }

        return -1;
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
//    }
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
