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
public class BounceCurve {

    private static final float BOUNCE_R = 1.0F / 2.75F;       // reciprocal
    private static final float BOUNCE_K0 = 7.5625F;
    private static final float BOUNCE_K1 = 1.0F * BOUNCE_R;   // 36.36%
    private static final float BOUCNE_K2 = 2.0F * BOUNCE_R;   // 72.72%
    private static final float BOUNCE_K3 = 1.5F * BOUNCE_R;   // 54.54%
    private static final float BOUNCE_K4 = 2.5F * BOUNCE_R;   // 90.90%
    private static final float BOUNCE_K5 = 2.25F * BOUNCE_R;  // 81.81%
    private static final float BOUCNE_K6 = 2.625F * BOUNCE_R; // 95.45%

    public static AnimationCurve IN = new In();
    public static AnimationCurve OUT = new Out();
    public static AnimationCurve IN_OUT = new InOut();

    protected static class In implements AnimationCurve {

        @Override
        public double calculate(double time) {
            return 1d - OUT.calculate(1d - time);
        }
    }

    protected static class Out implements AnimationCurve {

        @Override
        public double calculate(double time) {
            if (time < BOUNCE_K1) {
                return BOUNCE_K0 * time * time;
            } else if (time < BOUCNE_K2) {
                // 48/64
                double t = time - BOUNCE_K3;
                return BOUNCE_K0 * t * t + 0.75F;
            } else if (time < BOUNCE_K4) {
                // 60/64
                double t = time - BOUNCE_K5;
                return BOUNCE_K0 * t * t + 0.9375F;
            } else {
                // 63/64
                double t = time - BOUCNE_K6;
                return BOUNCE_K0 * t * t + 0.984375F;
            }
        }
    }

    protected static class InOut implements AnimationCurve {

        @Override
        public double calculate(double time) {
            double t = time * 2d;

            if (t < 1d) {
                return 0.5d - 0.5d * OUT.calculate(1.0F - t);
            }

            return 0.5d + 0.5d * OUT.calculate(t - 1.0F);
        }
    }

}
