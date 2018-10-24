/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation.curves;

/**
 *
 * @author swhitehead
 */
public class ExponentCurve {

    public static AnimationCurve IN = new In();
    public static AnimationCurve OUT = new Out();
    public static AnimationCurve IN_OUT = new InOut();

    protected static class In implements AnimationCurve {

        @Override
        public double calculate(double time) {
            return (double) Math.pow(2, 10d * (time - 1d));
        }
    }

    protected static class Out implements AnimationCurve {

        @Override
        public double calculate(double time) {
            return (double) (1d - Math.pow(2, -10d * time));
        }
    }

    protected static class InOut implements AnimationCurve {

        @Override
        public double calculate(double time) {
            if (time < 0.5F) {
                return (double) Math.pow(2, 10d * (2d * time - 1d) - 1d);
            }

            return (double) (1d - Math.pow(2, -10d * (2d * time - 1d) - 1d));
        }
    }

}
