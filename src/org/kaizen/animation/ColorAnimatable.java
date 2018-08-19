/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation;

import java.awt.Color;
import java.time.Duration;

public class ColorAnimatable extends AbstractAnimatable<Color> {
	
	public ColorAnimatable(ColorRange animationRange, Duration duration, AnimatableListener<Color> listener) {
		super(animationRange, duration, listener);
	}
	
}
