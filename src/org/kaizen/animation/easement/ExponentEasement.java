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
public class ExponentEasement {
	
	public static Easement IN = new In();
	public static Easement OUT = new Out();
	public static Easement IN_OUT = new InOut();

	protected static class In implements Easement {

		@Override
		public double calculate(double time) {
			return (double) Math.pow(2, 10d * (time - 1d));
		}
	}

	protected static class Out implements Easement {

		@Override
		public double calculate(double time) {
			return (double) (1d - Math.pow(2, -10d * time));
		}
	}

	protected static class InOut implements Easement {

		@Override
		public double calculate(double time) {
			if (time < 0.5F) {
				return (double) Math.pow(2, 10d * (2d * time - 1d) - 1d);
			}

			return (double) (1d - Math.pow(2, -10d * (2d * time - 1d) - 1d));
		}
	}

}
