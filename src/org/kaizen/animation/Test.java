/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation;

import org.kaizen.animation.ranges.IntAnimatableRange;
import org.kaizen.animation.ranges.IntRange;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import org.kaizen.animation.curves.Curves;
import org.kaizen.animation.curves.LinearCurve;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.kaizen.animation.curves.AnimationCurve;
import org.kaizen.animation.ranges.AnimatableRange;
import org.kaizen.animation.ranges.AnimatableRangeListener;

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
        private AnimationCurve easement;

        public EasementDescription(String name, AnimationCurve easement) {
            this.name = name;
            this.easement = easement;
        }

        public AnimationCurve getEasement() {
            return easement;
        }

        @Override
        public String toString() {
            return name;
        }

    }

    public class EasementComboBoxModel extends DefaultComboBoxModel<EasementDescription> {

        public EasementComboBoxModel() {
            addElement(new EasementDescription("Linear", Curves.LINEAR.getEasement()));
            addElement(new EasementDescription("Sine In", Curves.SINE_IN.getEasement()));
            addElement(new EasementDescription("Sine Out", Curves.SINE_OUT.getEasement()));
            addElement(new EasementDescription("Sine In/Out", Curves.SINE_IN_OUT.getEasement()));
            addElement(new EasementDescription("Quad In", Curves.QUAD_IN.getEasement()));
            addElement(new EasementDescription("Quad Out", Curves.QUAD_OUT.getEasement()));
            addElement(new EasementDescription("Quad In/Out", Curves.QUAD_IN_OUT.getEasement()));
            addElement(new EasementDescription("Cubic In", Curves.CUBIC_IN.getEasement()));
            addElement(new EasementDescription("Cubic Out", Curves.CUBIC_OUT.getEasement()));
            addElement(new EasementDescription("Cubic In/Out", Curves.CUBIC_IN_OUT.getEasement()));
            addElement(new EasementDescription("Quart In", Curves.QUART_IN.getEasement()));
            addElement(new EasementDescription("Quart Out", Curves.QUART_OUT.getEasement()));
            addElement(new EasementDescription("Quart In/Out", Curves.QUART_IN_OUT.getEasement()));
            addElement(new EasementDescription("Quint In", Curves.QUINT_IN.getEasement()));
            addElement(new EasementDescription("Quint Out", Curves.QUINT_OUT.getEasement()));
            addElement(new EasementDescription("Quint In/Out", Curves.QUINT_IN_OUT.getEasement()));
            addElement(new EasementDescription("Sextic In", Curves.SEXTIC_IN.getEasement()));
            addElement(new EasementDescription("Sextic Out", Curves.SEXTIC_OUT.getEasement()));
            addElement(new EasementDescription("Sextic In/Out", Curves.SEXTIC_IN_OUT.getEasement()));
            addElement(new EasementDescription("Septic In", Curves.SEPTIC_IN.getEasement()));
            addElement(new EasementDescription("Septic Out", Curves.SEPTIC_OUT.getEasement()));
            addElement(new EasementDescription("Septic In/Out", Curves.SEPTIC_IN_OUT.getEasement()));
            addElement(new EasementDescription("Octic In", Curves.OCTIC_IN.getEasement()));
            addElement(new EasementDescription("Octic Out", Curves.OCTIC_OUT.getEasement()));
            addElement(new EasementDescription("Octic In/Out", Curves.OCTIC_IN_OUT.getEasement()));
            addElement(new EasementDescription("Exponent In", Curves.EXPONENT_IN.getEasement()));
            addElement(new EasementDescription("Exponent Out", Curves.EXPONENT_OUT.getEasement()));
            addElement(new EasementDescription("Exponent In/Out", Curves.EXPONENT_IN_OUT.getEasement()));
            addElement(new EasementDescription("Circle In", Curves.CIRCLE_IN.getEasement()));
            addElement(new EasementDescription("Circle Out", Curves.CIRCLE_OUT.getEasement()));
            addElement(new EasementDescription("Circle In/Out", Curves.CIRCLE_IN_OUT.getEasement()));
            addElement(new EasementDescription("Back In", Curves.BACK_IN.getEasement()));
            addElement(new EasementDescription("Back Out", Curves.BACK_OUT.getEasement()));
            addElement(new EasementDescription("Back In/Out", Curves.BACK_IN_OUT.getEasement()));
            addElement(new EasementDescription("Elastic In", Curves.ELASTIC_IN.getEasement()));
            addElement(new EasementDescription("Elastic Out", Curves.ELASTIC_OUT.getEasement()));
            addElement(new EasementDescription("Elastic In/Out", Curves.ELASTIC_IN_OUT.getEasement()));
            addElement(new EasementDescription("Bounce In", Curves.BOUNCE_IN.getEasement()));
            addElement(new EasementDescription("Bounce Out", Curves.BOUNCE_OUT.getEasement()));
            addElement(new EasementDescription("Bounce In/Out", Curves.BOUNCE_IN_OUT.getEasement()));
        }

    }

    public class AnimationPane extends JPanel {

        private IntRange horizontalRange = new IntRange(10, 380);
        private IntRange verticalRange = new IntRange(380, 10);
        private IntAnimatableRange horizontalAnimatable;
        private IntAnimatableRange verticalAnimatable;

        private int xPos = horizontalRange.getFrom();
        private int yPos = verticalRange.getFrom();

        private AnimatableAdapter<Integer> animationHandler = new AnimationHandler();

        private AnimationCurve easement = new LinearCurve();

        public AnimationPane() {
        }

        public void setEasement(AnimationCurve easement) {
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
            horizontalAnimatable = new IntAnimatableRange(horizontalRange, duration, easement, animationHandler);
            verticalAnimatable = new IntAnimatableRange(verticalRange, duration, easement, animationHandler);

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
            public void animationChange(AnimatableRange<Integer> animatable) {
                if (animatable == horizontalAnimatable) {
                    xPos = animatable.getValue();
                } else if (animatable == verticalAnimatable) {
                    yPos = animatable.getValue();
                }
                repaint();
            }

        }

    }

}
