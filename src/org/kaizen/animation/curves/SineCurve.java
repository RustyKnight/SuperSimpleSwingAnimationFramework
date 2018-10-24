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
public class SineCurve {

    private static final float PI = 3.1415926535897932384626433832795028841971693993759F;
    private static final float PI_DIV_2 = 1.5707963267948966192313216916397514420985846996875F;

    public static AnimationCurve IN = new In();
    public static AnimationCurve OUT = new Out();
    public static AnimationCurve IN_OUT = new InOut();

    protected static class In implements AnimationCurve {

        @Override
        public double calculate(double time) {
            return (double) (1d - Math.cos(time * PI_DIV_2));
        }
    }

    protected static class Out implements AnimationCurve {

        @Override
        public double calculate(double time) {
            return (double) Math.sin(time * PI_DIV_2);
        }
    }

    protected static class InOut implements AnimationCurve {

        @Override
        public double calculate(double time) {
            return (double) (0.5F * (1d - Math.cos(time * PI)));
        }
    }

}
