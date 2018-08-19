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
public class QuadEasement {

	public static Easement IN = new In();
	public static Easement OUT = new Out();
	public static Easement IN_OUT = new InOut();

	// Ease in
	protected static class In implements Easement {

		@Override
		public double calculate(double time) {
			return time * time;
		}
	}

	// Ease Out
	protected static class Out implements Easement {

		@Override
		public double calculate(double time) {
			double m = time - 1d;
			double result = 1d - m * m;
			System.out.println(time + " ~ " + result);
			return result;
		}
	}

	// Ease in/out
	protected static class InOut implements Easement {

		@Override
		public double calculate(double time) {
			double t = time * 2d;
			if (t < 1d) {
				double result = time * t;
				return result;
			}

			double m = time - 1d;
			double result = 1d - m * m * 2d;
			return result;
		}
	}

}
