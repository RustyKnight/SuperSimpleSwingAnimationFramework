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
public class BackEasement {

	private static final float K = 1.70158F;
	private static final float K2 = 1.70158F * 1.525F;

	public static Easement IN = new In();
	public static Easement OUT = new Out();
	public static Easement IN_OUT = new InOut();

	protected static class In implements Easement {

		@Override
		public double calculate(double time) {
			return time * time * (time * (K + 1d) - K);
		}
	}

	protected static class Out implements Easement {

		@Override
		public double calculate(double time) {
			double m = time - 1d;
			return 1d + m * m * (m * (K + 1d) + K);
		}
	}

	protected static class InOut implements Easement {

		@Override
		public double calculate(double time) {
			double m = time - 1d;
			double t = time * 2d;
			// doublek = 1.70158F * 1.525F; (as constant K2)

			if (time < 0.5F) {
				return time * t * (t * (K2 + 1d) - K2);
			} else {
				return 1d + 2d * m * m * (2d * m * (K2 + 1d) + K2);
			}
		}
	}

}
