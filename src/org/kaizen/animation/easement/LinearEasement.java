/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation.easement;

/**
 *
 * @author swhitehead
 */
public class LinearEasement implements Easement {
	
	@Override
	public double calculate(double time) {
		return time;
	}
	
}
