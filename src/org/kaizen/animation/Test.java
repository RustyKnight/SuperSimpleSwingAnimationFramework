/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import org.kaizen.animation.easement.Easement;
import org.kaizen.animation.easement.Easements;
import org.kaizen.animation.easement.LinearEasement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

	public static void main(String[] args) {
		new Test();
	}

	public Test() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
					ex.printStackTrace();
				}

				JFrame frame = new JFrame("Testing");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.add(new ControlPane());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

	public class ControlPane extends JPanel {
		
		private AnimationPane animationPane;
		
		public ControlPane() {
			animationPane = new AnimationPane();
			JComboBox<EasementDescription> easements = new JComboBox<>(new EasementComboBoxModel());
			easements.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					EasementDescription ed = (EasementDescription) easements.getSelectedItem();
					animationPane.setEasement(ed.getEasement());
				}
			});
			JButton start = new JButton("Start");
			start.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					animationPane.start();
				}
			});
			
			JPanel options = new JPanel();
			options.add(easements);
			options.add(start);
			
			setLayout(new BorderLayout());
			add(animationPane);
			add(options, BorderLayout.SOUTH);
			
		}
	}
	
	public class EasementDescription {
		private String name;
		private Easement easement;

		public EasementDescription(String name, Easement easement) {
			this.name = name;
			this.easement = easement;
		}

		public Easement getEasement() {
			return easement;
		}

		@Override
		public String toString() {
			return name;
		}
		
	}
	
	public class EasementComboBoxModel extends DefaultComboBoxModel<EasementDescription> {

		public EasementComboBoxModel() {
			addElement(new EasementDescription("Linear", Easements.LINEAR.getEasement()));
			addElement(new EasementDescription("Sine In", Easements.SINE_IN.getEasement()));
			addElement(new EasementDescription("Sine Out", Easements.SINE_OUT.getEasement()));
			addElement(new EasementDescription("Sine In/Out", Easements.SINE_IN_OUT.getEasement()));
			addElement(new EasementDescription("Quad In", Easements.QUAD_IN.getEasement()));
			addElement(new EasementDescription("Quad Out", Easements.QUAD_OUT.getEasement()));
			addElement(new EasementDescription("Quad In/Out", Easements.QUAD_IN_OUT.getEasement()));
			addElement(new EasementDescription("Cubic In", Easements.CUBIC_IN.getEasement()));
			addElement(new EasementDescription("Cubic Out", Easements.CUBIC_OUT.getEasement()));
			addElement(new EasementDescription("Cubic In/Out", Easements.CUBIC_IN_OUT.getEasement()));
			addElement(new EasementDescription("Quart In", Easements.QUART_IN.getEasement()));
			addElement(new EasementDescription("Quart Out", Easements.QUART_OUT.getEasement()));
			addElement(new EasementDescription("Quart In/Out", Easements.QUART_IN_OUT.getEasement()));
			addElement(new EasementDescription("Quint In", Easements.QUINT_IN.getEasement()));
			addElement(new EasementDescription("Quint Out", Easements.QUINT_OUT.getEasement()));
			addElement(new EasementDescription("Quint In/Out", Easements.QUINT_IN_OUT.getEasement()));
			addElement(new EasementDescription("Sextic In", Easements.SEXTIC_IN.getEasement()));
			addElement(new EasementDescription("Sextic Out", Easements.SEXTIC_OUT.getEasement()));
			addElement(new EasementDescription("Sextic In/Out", Easements.SEXTIC_IN_OUT.getEasement()));
			addElement(new EasementDescription("Septic In", Easements.SEPTIC_IN.getEasement()));
			addElement(new EasementDescription("Septic Out", Easements.SEPTIC_OUT.getEasement()));
			addElement(new EasementDescription("Septic In/Out", Easements.SEPTIC_IN_OUT.getEasement()));
			addElement(new EasementDescription("Octic In", Easements.OCTIC_IN.getEasement()));
			addElement(new EasementDescription("Octic Out", Easements.OCTIC_OUT.getEasement()));
			addElement(new EasementDescription("Octic In/Out", Easements.OCTIC_IN_OUT.getEasement()));
			addElement(new EasementDescription("Exponent In", Easements.EXPONENT_IN.getEasement()));
			addElement(new EasementDescription("Exponent Out", Easements.EXPONENT_OUT.getEasement()));
			addElement(new EasementDescription("Exponent In/Out", Easements.EXPONENT_IN_OUT.getEasement()));
			addElement(new EasementDescription("Circle In", Easements.CIRCLE_IN.getEasement()));
			addElement(new EasementDescription("Circle Out", Easements.CIRCLE_OUT.getEasement()));
			addElement(new EasementDescription("Circle In/Out", Easements.CIRCLE_IN_OUT.getEasement()));
			addElement(new EasementDescription("Back In", Easements.BACK_IN.getEasement()));
			addElement(new EasementDescription("Back Out", Easements.BACK_OUT.getEasement()));
			addElement(new EasementDescription("Back In/Out", Easements.BACK_IN_OUT.getEasement()));
			addElement(new EasementDescription("Elastic In", Easements.ELASTIC_IN.getEasement()));
			addElement(new EasementDescription("Elastic Out", Easements.ELASTIC_OUT.getEasement()));
			addElement(new EasementDescription("Elastic In/Out", Easements.ELASTIC_IN_OUT.getEasement()));
			addElement(new EasementDescription("Bounce In", Easements.BOUNCE_IN.getEasement()));
			addElement(new EasementDescription("Bounce Out", Easements.BOUNCE_OUT.getEasement()));
			addElement(new EasementDescription("Bounce In/Out", Easements.BOUNCE_IN_OUT.getEasement()));
		}
		
	}

	public class AnimationPane extends JPanel {

		private IntRange horizontalRange = new IntRange(10, 380);
		private IntRange verticalRange = new IntRange(380, 10);
		private IntAnimatable horizontalAnimatable;
		private IntAnimatable verticalAnimatable;

		private int xPos = horizontalRange.getFrom();
		private int yPos = verticalRange.getFrom();

		private AnimationHandler animationHandler = new AnimationHandler();

		private Easement easement = new LinearEasement();

		public AnimationPane() {
		}

		public void setEasement(Easement easement) {
			this.easement = easement;
		}

		public void start() {
			if (horizontalAnimatable != null) {
				horizontalAnimatable.stop();
			}
			if (verticalAnimatable != null) {
				verticalAnimatable.stop();
			}

			xPos = horizontalRange.getFrom();
			yPos = verticalRange.getFrom();
			
			if (easement == null) {
				return;
			}
			
			Duration duration = Duration.ofSeconds(5);
			horizontalAnimatable = new IntAnimatable(horizontalRange, duration, easement, animationHandler, animationHandler);
			verticalAnimatable = new IntAnimatable(verticalRange, duration, easement, animationHandler, animationHandler);
			
			horizontalAnimatable.start();
			verticalAnimatable.start();
		}

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(400, 400);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			int horizontalCentre = (getHeight() - 10) / 2;
			Graphics2D g2d = (Graphics2D) g.create();
			g2d.setColor(Color.BLACK);
			g2d.fillRect(xPos, horizontalCentre, 10, 10);
			g2d.fillRect(getWidth() - 20, yPos, 10, 10);
			g2d.dispose();
		}

		protected class AnimationHandler extends AnimatableAdapter<Integer> {

			@Override
			public void animationChanged(Animatable<Integer> animator) {
				if (animator == horizontalAnimatable) {
					xPos = animator.getValue();
				} else if (animator == verticalAnimatable) {
					yPos = animator.getValue();
				}
				repaint();
			}

		}

	}

}
