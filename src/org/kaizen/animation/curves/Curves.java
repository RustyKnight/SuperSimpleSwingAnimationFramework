/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation.curves;

// Easing functions based on
// * https://easings.net
// * http://robertpenner.com/easing/
// * https://github.com/jesusgollonet/processing-penner-easing
// * https://git.dorkbox.com/dorkbox/TweenEngine
public enum Curves {

    LINEAR(new LinearCurve()),
    SINE_IN(SineCurve.IN),
    SINE_OUT(SineCurve.OUT),
    SINE_IN_OUT(SineCurve.IN_OUT),
    QUAD_IN(QuadCurve.IN),
    QUAD_OUT(QuadCurve.OUT),
    QUAD_IN_OUT(QuadCurve.IN_OUT),
    CUBIC_IN(CubicCurve.IN),
    CUBIC_OUT(CubicCurve.OUT),
    CUBIC_IN_OUT(CubicCurve.IN_OUT),
    QUART_IN(QuartCurve.IN),
    QUART_OUT(QuartCurve.OUT),
    QUART_IN_OUT(QuartCurve.IN_OUT),
    QUINT_IN(QuintCurve.IN),
    QUINT_OUT(QuintCurve.OUT),
    QUINT_IN_OUT(QuintCurve.IN_OUT),
    SEXTIC_IN(SexticCurve.IN),
    SEXTIC_OUT(SexticCurve.OUT),
    SEXTIC_IN_OUT(SexticCurve.IN_OUT),
    SEPTIC_IN(SepticCurve.IN),
    SEPTIC_OUT(SepticCurve.OUT),
    SEPTIC_IN_OUT(SepticCurve.IN_OUT),
    OCTIC_IN(OcitcCurve.IN),
    OCTIC_OUT(OcitcCurve.OUT),
    OCTIC_IN_OUT(OcitcCurve.IN_OUT),
    EXPONENT_IN(ExponentCurve.IN),
    EXPONENT_OUT(ExponentCurve.OUT),
    EXPONENT_IN_OUT(ExponentCurve.IN_OUT),
    CIRCLE_IN(CircleCurve.IN),
    CIRCLE_OUT(CircleCurve.OUT),
    CIRCLE_IN_OUT(CircleCurve.IN_OUT),
    BACK_IN(BackCurve.IN),
    BACK_OUT(BackCurve.OUT),
    BACK_IN_OUT(BackCurve.IN_OUT),
    ELASTIC_IN(ElasticCurve.IN),
    ELASTIC_OUT(ElasticCurve.OUT),
    ELASTIC_IN_OUT(ElasticCurve.IN_OUT),
    BOUNCE_IN(BounceCurve.IN),
    BOUNCE_OUT(BounceCurve.OUT),
    BOUNCE_IN_OUT(BounceCurve.IN_OUT);

    private AnimationCurve easement;

    private Curves(AnimationCurve esement) {
        this.easement = esement;
    }

    public double calculate(double time) {
        return easement.calculate(time);
    }

    public AnimationCurve getCurve() {
        return easement;
    }

}
