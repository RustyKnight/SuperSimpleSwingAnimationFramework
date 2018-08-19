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
public class CircleEasement {

	public static Easement IN = new In();
	public static Easement OUT = new Out();
	public static Easement IN_OUT = new InOut();

	protected static class In implements Easement {

		@Override
		public double calculate(double time) {
			return (1d - Math.sqrt(1d - time * time));
		}
	}

	protected static class Out implements Easement {

		@Override
		public double calculate(double time) {
			double m = time - 1d;
			return Math.sqrt(1d - m * m);
		}
	}

	protected static class InOut implements Easement {

		@Override
		public double calculate(double time) {
			double m = time - 1d;
			double t = time * 2d;

			if (t < 1d) {
				return ((1d - Math.sqrt(1d - t * t)) * 0.5);
			}
			return ((Math.sqrt(1d - 4 * m * m) + 1d) * 0.5d);
		}
	}
}
