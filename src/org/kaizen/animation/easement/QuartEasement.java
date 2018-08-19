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
public class QuartEasement {
		
	public static Easement IN = new In();
	public static Easement OUT = new Out();
	public static Easement IN_OUT = new InOut();

	protected static class In implements Easement {

		@Override
		public double calculate(double time) {
			double t = time * time;
			return t * t;
		}
	}

	protected static class Out implements Easement {

		@Override
		public double calculate(double time) {
			double m = time - 1d;
			double m2 = m * m;
			return 1d - m2 * m2;
		}
	}

	protected static class InOut implements Easement {

		@Override
		public double calculate(double time) {
			double t = time * 2d;
			if (t < 1d) {
				return time * t * t * t;
			}
			double m = time - 1d;
			double m2 = m * m;
			return 1d - m2 * m2 * 8d;
		}
	}
	
}
