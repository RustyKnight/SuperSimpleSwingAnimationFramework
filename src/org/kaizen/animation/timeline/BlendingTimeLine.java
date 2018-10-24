/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation.timeline;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A implementation of a time line which blends values between key frames.
 *
 * Great for moving between various key points or anything where you need to
 * blend multiple to-from values of a period of time
 *
 * @author shanewhitehead
 * @param <T>
 */
public class BlendingTimeLine<T> extends AbstractTimeLine<T> {

    private Blender<T> blender;

    public BlendingTimeLine(Blender<T> blender) {
        this.blender = blender;
    }

    public Blender<T> getBlender() {
        return blender;
    }

    public T getValueAt(double progress) {
        if (progress < 0) {
            progress = 0;
        } else if (progress > 1) {
            progress = 1;
        }

        List<KeyFrame<T>> keyFrames = getKeyFramesBetween(progress);

        double max = keyFrames.get(1).getProgress() - keyFrames.get(0).getProgress();
        double value = progress - keyFrames.get(0).getProgress();
        double weight = value / max;

        T blend = blend(keyFrames.get(0).getValue(), 
                keyFrames.get(1).getValue(), 1d - weight);
        return blend;
    }

    protected T blend(T start, T end, double ratio) {
        return blender.blend(start, end, ratio);
    }

    public interface Blender<T> {
        public T blend(T start, T end, double ratio);
    }

    public List<KeyFrame<T>> getKeyFramesBetween(double progress) {

        Map<Double, KeyFrame<T>> events = getEvents();
        
        List<KeyFrame<T>> frames = new ArrayList<>(2);
        int startAt = 0;
        
        List<Double> keyFrames = events.keySet().stream().collect(Collectors.toList());
        while (startAt < keyFrames.size() && keyFrames.get(startAt) <= progress) {
            startAt++;
        }

        startAt = Math.min(startAt, keyFrames.size() - 1);

        frames.add(events.get(keyFrames.get(startAt - 1)));
        frames.add(events.get(keyFrames.get(startAt)));

        return frames;

    }
}
