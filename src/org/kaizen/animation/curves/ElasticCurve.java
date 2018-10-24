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
public class ElasticCurve {

    private static final float PI_DIV_6 = 0.5235987755982988730771072305465838140328615665625F; // Note: 40/6 = 6.666... = 2/0.3 = PI/6;
    private static final float PI_DIV_18 = 0.1745329251994329576923690768488612713442871888541F;

    public static AnimationCurve IN = new In();
    public static AnimationCurve OUT = new Out();
    public static AnimationCurve IN_OUT = new InOut();

    protected static class In implements AnimationCurve {

        @Override
        public double calculate(double time) {
            double m = time - 1d;
            double result = (-Math.pow(2, 10d * m) * Math.sin((m * 40d - 3d) * PI_DIV_6)); // Note: 40/6 = 6.666... = 2/0.3 = PI/6;
            return result;
        }
    }

    protected static class Out implements AnimationCurve {

        @Override
        public double calculate(double time) {
            return (1d + (Math.pow(2, 10d * -time) * Math.sin((-time * 40d - 3d) * PI_DIV_6)));
        }
    }

    protected static class InOut implements AnimationCurve {

        @Override
        public double calculate(double time) {
            time *= 2d; // remap: [0,0.5] -> [-1,0]
            time -= 1d; // and    [0.5,1] -> [0,+1]

            double k = ((80d * time - 9d) * PI_DIV_18);

            if (time < 0d) {
                return (double) (-0.5F * Math.pow(2, 10d * time) * Math.sin(k));
            }
            return (double) (1d + 0.5F * Math.pow(2, -10d * time) * Math.sin(k));
        }
    }

}
