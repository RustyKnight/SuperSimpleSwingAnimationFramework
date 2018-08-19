/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation;

import java.awt.Color;

public class ColorRange extends Range<Color> {

	public ColorRange(Color from, Color to) {
		super(from, to);
	}

	@Override
	public Color valueAt(double progress) {
		return blend(getTo(), getFrom(), progress);
	}

	protected Color blend(Color color1, Color color2, double ratio) {
		float r = (float) ratio;
		float ir = (float) 1.0 - r;
		float red = color1.getRed() * r + color2.getRed() * ir;
		float green = color1.getGreen() * r + color2.getGreen() * ir;
		float blue = color1.getBlue() * r + color2.getBlue() * ir;
		float alpha = color1.getAlpha() * r + color2.getAlpha() * ir;
		red = Math.min(255f, Math.max(0f, red));
		green = Math.min(255f, Math.max(0f, green));
		blue = Math.min(255f, Math.max(0f, blue));
		alpha = Math.min(255f, Math.max(0f, alpha));
		Color color = null;
		try {
			color = new Color((int) red, (int) green, (int) blue, (int) alpha);
		} catch (IllegalArgumentException exp) {
			exp.printStackTrace();
		}
		return color;
	}

}
