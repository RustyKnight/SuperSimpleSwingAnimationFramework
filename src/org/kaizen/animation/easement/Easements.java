/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation.easement;

// Easing functions based on
// * https://easings.net
// * http://robertpenner.com/easing/
// * https://github.com/jesusgollonet/processing-penner-easing
// * https://git.dorkbox.com/dorkbox/TweenEngine
public enum Easements {

	LINEAR(new LinearEasement()),
	SINE_IN(SineEasement.IN),
	SINE_OUT(SineEasement.OUT),
	SINE_IN_OUT(SineEasement.IN_OUT),
	QUAD_IN(QuadEasement.IN),
	QUAD_OUT(QuadEasement.OUT),
	QUAD_IN_OUT(QuadEasement.IN_OUT),
	CUBIC_IN(CubicEasement.IN),
	CUBIC_OUT(CubicEasement.OUT),
	CUBIC_IN_OUT(CubicEasement.IN_OUT),
	QUART_IN(QuartEasement.IN),
	QUART_OUT(QuartEasement.OUT),
	QUART_IN_OUT(QuartEasement.IN_OUT),
	QUINT_IN(QuintEasement.IN),
	QUINT_OUT(QuintEasement.OUT),
	QUINT_IN_OUT(QuintEasement.IN_OUT),
	SEXTIC_IN(SexticEasement.IN),
	SEXTIC_OUT(SexticEasement.OUT),
	SEXTIC_IN_OUT(SexticEasement.IN_OUT),
	SEPTIC_IN(SepticEasement.IN),
	SEPTIC_OUT(SepticEasement.OUT),
	SEPTIC_IN_OUT(SepticEasement.IN_OUT),
	OCTIC_IN(OcitcEasement.IN),
	OCTIC_OUT(OcitcEasement.OUT),
	OCTIC_IN_OUT(OcitcEasement.IN_OUT),
	EXPONENT_IN(ExponentEasement.IN),
	EXPONENT_OUT(ExponentEasement.OUT),
	EXPONENT_IN_OUT(ExponentEasement.IN_OUT),
	CIRCLE_IN(CircleEasement.IN),
	CIRCLE_OUT(CircleEasement.OUT),
	CIRCLE_IN_OUT(CircleEasement.IN_OUT),
	BACK_IN(BackEasement.IN),
	BACK_OUT(BackEasement.OUT),
	BACK_IN_OUT(BackEasement.IN_OUT),
	ELASTIC_IN(ElasticEasement.IN),
	ELASTIC_OUT(ElasticEasement.OUT),
	ELASTIC_IN_OUT(ElasticEasement.IN_OUT),
	BOUNCE_IN(BounceEasement.IN),
	BOUNCE_OUT(BounceEasement.OUT),
	BOUNCE_IN_OUT(BounceEasement.IN_OUT);

	private Easement easement;

	private Easements(Easement esement) {
		this.easement = esement;
	}

	public double calculate(double time) {
		return easement.calculate(time);
	}

	public Easement getEasement() {
		return easement;
	}
	
}
