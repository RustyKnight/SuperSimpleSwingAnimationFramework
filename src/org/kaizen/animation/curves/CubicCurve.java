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
public class CubicCurve {

    public static AnimationCurve IN = new In();
    public static AnimationCurve OUT = new Out();
    public static AnimationCurve IN_OUT = new InOut();

    protected static class In implements AnimationCurve {

        @Override
        public double calculate(double time) {
            return time * time * time;
        }
    }

    protected static class Out implements AnimationCurve {

        @Override
        public double calculate(double time) {
            double m = time - 1d;
            return 1d + m * m * m;
        }
    }

    protected static class InOut implements AnimationCurve {

        @Override
        public double calculate(double time) {
            double t = time * 2d;
            if (t < 1d) {
                return time * t * t;
            }
            double m = time - 1d;
            return 1d + m * m * m * 4d;
        }
    }

}
