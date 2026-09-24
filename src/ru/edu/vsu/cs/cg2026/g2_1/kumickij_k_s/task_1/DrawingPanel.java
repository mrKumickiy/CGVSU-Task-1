package ru.edu.vsu.cs.cg2026.g2_1.kumickij_k_s.task_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingPanel extends JPanel implements ActionListener {
    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;
    private final int ROAD_SPEED = 20;
    private final int WHEEL_TURING_SPEED = 15;

    private int ticksFromStart = 0;

    private final Timer timer;
    private final Sky sky;
    private final Road road;
    private final Car car;

    public DrawingPanel(int width, int height, int timerDelay) {
        this.PANEL_WIDTH = width;
        this.PANEL_HEIGHT = height;

        this.timer = new Timer(timerDelay, this);

        this.sky = new Sky(Color.CYAN, 100, PANEL_WIDTH - 250, 25, Color.YELLOW);

        this.road = new Road((int)(0.65 * PANEL_HEIGHT),Color.GRAY,(int)(0.2 * PANEL_WIDTH),(int)(0.1 * PANEL_HEIGHT),(int)(0.05 * PANEL_WIDTH), Color.WHITE);
        road.setMarkupY(road.getRoadHeight()/2 - road.getMarkupHeight());

        this.car = new Car((int)(0.1 * PANEL_WIDTH), (int)(0.4 * PANEL_HEIGHT), (int)(0.45 * PANEL_WIDTH), (int)(0.4 * PANEL_HEIGHT),
                (int)(0.125 * 0.45 * PANEL_WIDTH), 12,
                Color.YELLOW, Color.BLUE, Color.WHITE, Color.RED, Color.BLACK, Color.LIGHT_GRAY);
        timer.start();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        sky.draw(graphics, PANEL_WIDTH, PANEL_HEIGHT);
        road.draw(graphics, PANEL_WIDTH, PANEL_HEIGHT);
        car.draw(graphics);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == timer) {
            ticksFromStart++;
            road.setMarkupX(ROAD_SPEED * ticksFromStart);
            car.setAngle(Math.toRadians(WHEEL_TURING_SPEED * ticksFromStart));
            repaint();
        }
    }
}
