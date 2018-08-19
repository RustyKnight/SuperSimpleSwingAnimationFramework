package org.kaizen.animation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.Timer;

public enum Animator {
	INSTANCE;
	private Timer timer;
	private List<Animatable> properies;

	private Animator() {
		properies = new ArrayList<>(5);
		timer = new Timer(5, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Animatable> copy = new ArrayList<>(properies);
				Iterator<Animatable> it = copy.iterator();
				while (it.hasNext()) {
					Animatable ap = it.next();
					ap.tick();
				}
				if (properies.isEmpty()) {
					timer.stop();
				}
			}
		});
	}

	public void add(Animatable ap) {
		properies.add(ap);
		timer.start();
	}
	
	protected void removeAll(List<Animatable> completed) {
		properies.removeAll(completed);
	}

	public void remove(Animatable ap) {
		properies.remove(ap);
		if (properies.isEmpty()) {
			timer.stop();
		}
	}

}
