/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaizen.animation;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.kaizen.animation.curves.Curves;
import org.kaizen.animation.ranges.AnimatableRange;
import org.kaizen.animation.ranges.DefaultAnimatableRange;
import org.kaizen.animation.ranges.FloatRange;
import org.kaizen.animation.timeline.BlendingTimeLine;
import org.kaizen.animation.timeline.EventTimeLine;
import org.kaizen.animation.timeline.FloatBlender;

/**
 *
 * @author shanewhitehead
 */
public class TestTimeLine {

    public static void main(String[] args) {
        new TestTimeLine();
    }

    public TestTimeLine() {
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
                frame.setLayout(new GridLayout(2, 0));
                frame.add(new BlendingTimeLinePane());
                frame.add(new EventTimeLinePane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class BlendingTimeLinePane extends JPanel {

        private float alpha;
        private AnimatableDuration animatable;

        public BlendingTimeLinePane() {
            BlendingTimeLine<Float> timeLine = new BlendingTimeLine<>(new FloatBlender());
            timeLine.addKeyFrame(0.0, 0.0f);
            timeLine.addKeyFrame(0.5, 1.0f);
            timeLine.addKeyFrame(1.0, 0.0f);

            animatable = new DefaultAnimatableDuration(Duration.ofSeconds(5), Curves.SINE_IN_OUT.getCurve(), new AnimatableAdapter<Double>() {
                @Override
                public void animationTimeChanged(AnimatableDuration animatable) {
                    double progress = animatable.getProgress();
                    float desiredAlpha = timeLine.getValueAt(progress);
                    if (desiredAlpha != alpha) {
                        alpha = desiredAlpha;
                        repaint();
                    }
                }

                @Override
                public void animationCompleted(Animatable animator) {
                    animatable.start();
                }

            });

            setLayout(new GridBagLayout());
            add(new JLabel("Happy, happy, joy, joy"));
            setOpaque(false);

            animatable.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setComposite(AlphaComposite.SrcOver.derive(alpha));
            super.paint(g2d);
            g2d.dispose();
        }

    }

    public class EventTimeLinePane extends JPanel {

        private AnimatableDuration animatable;
        private EventTimeLine<Object> timeLine;
        private double progress = 0;

        public EventTimeLinePane() {
            timeLine = new EventTimeLine<>();

            // The value here is irrelevent to the example :/
            timeLine.addKeyFrame(0.0, new Object());
            timeLine.addKeyFrame(0.05, new Object());
            timeLine.addKeyFrame(0.15, new Object());
            timeLine.addKeyFrame(0.3, new Object());
            timeLine.addKeyFrame(0.5, new Object());
            timeLine.addKeyFrame(0.51, new Object());
            timeLine.addKeyFrame(0.52, new Object());
            timeLine.addKeyFrame(0.53, new Object());
            timeLine.addKeyFrame(0.75, new Object());
            timeLine.addKeyFrame(0.9, new Object());

            animatable = new DefaultAnimatableDuration(Duration.ofSeconds(5), Curves.SINE_IN_OUT.getCurve(), new AnimatableAdapter<Double>() {
                @Override
                public void animationTimeChanged(AnimatableDuration animatable) {
                    progress = animatable.getProgress();
                    List<Object> currentEvents = timeLine.getEventsAt(progress);
                    for (Object value : currentEvents) {
                        highlight(value);
                    }
                    repaint();
                }

                @Override
                public void animationCompleted(Animatable animator) {
                    System.out.println("Completed");
                    animatable.start();
                }

                @Override
                public void animationStarted(Animatable animator) {
                    System.out.println("Started");
                }

                @Override
                public void animationStopped(Animatable animator) {
                    System.out.println("Stopped");
                }

            });

            animatable.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        private Map<Object, Float> pointAlphas = new HashMap<>(5);

        protected void highlight(Object value) {
            // Note is already playing...
            // Equally, we could maintain a reference to the animator, mapped to
            // the note, but what ever...
            if (pointAlphas.containsKey(value)) {
                return;
            }
            pointAlphas.put(value, 1.0f);

            FloatRange range = new FloatRange(1.0f, 0.0f);
            DefaultAnimatableRange<Float> pointAnimatable = new DefaultAnimatableRange<>(range, Duration.ofSeconds(1), null /*Curves.SINE_IN.getCurve()*/, new AnimatableAdapter<Float>() {
                @Override
                public void animationChanged(AnimatableRange<Float> animatable) {
                    pointAlphas.put(value, animatable.getValue());
                    repaint();
                }

                @Override
                public void animationCompleted(Animatable animator) {
                    pointAlphas.remove(value);
                    repaint();
                }

                @Override
                public void animationStarted(Animatable animator) {
                    pointAlphas.remove(value);
                    repaint();
                }
                
            });
            pointAnimatable.start();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int startX = 10;
            int endX = getWidth() - 10;
            int range = endX - startX;
            int yPos = getHeight() / 2;

            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.DARK_GRAY);
            g2d.drawLine(startX, yPos, endX, yPos);
            for (Object value : timeLine.getValues()) {
                double potl = timeLine.getPointOnTimeLine(value);
                double xPos = startX + (range * potl);

                Ellipse2D dot = new Ellipse2D.Double(xPos - 2.5, yPos - 2.5, 5, 5);
                g2d.fill(dot);
            }

            g2d.setColor(Color.RED);
            for (Map.Entry<Object, Float> entry : pointAlphas.entrySet()) {
                double potl = timeLine.getPointOnTimeLine(entry.getKey());
                double xPos = startX + (range * potl);
                
                Graphics2D alpha2D = (Graphics2D) g2d.create();
                alpha2D.setComposite(AlphaComposite.SrcOver.derive(entry.getValue()));
                Ellipse2D dot = new Ellipse2D.Double(xPos - 5, yPos - 5, 10, 10);
                alpha2D.fill(dot);
                alpha2D.dispose();
            }

            double xPos = startX + (range * progress);
            g2d.draw(new Line2D.Double(xPos, 0, xPos, getHeight()));
            g2d.dispose();
        }
    }

}
