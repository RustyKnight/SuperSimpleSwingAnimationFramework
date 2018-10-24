/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation.ranges;

public class IntRange extends Range<Integer> {

	public IntRange(Integer from, Integer to) {
		super(from, to);
	}

	public Integer getDistance() {
		return getTo() - getFrom();
	}

	@Override
	public Integer valueAt(double progress) {
		int distance = getDistance();
		int value = (int) Math.round((double) distance * progress);
		value += getFrom();

//		int from = getFrom();
//		int to = getTo();
//
//		if (from < to) {
//			value = Math.max(from, Math.min(to, value));
//		} else {
//			value = Math.max(to, Math.min(from, value));
//		}

		return value;
	}
}
