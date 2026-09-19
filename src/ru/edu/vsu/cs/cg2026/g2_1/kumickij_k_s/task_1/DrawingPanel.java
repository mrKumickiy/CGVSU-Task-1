package ru.edu.vsu.cs.cg2026.g2_1.kumickij_k_s.task_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

public class DrawingPanel extends JPanel implements ActionListener {
    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;
    private int ticksFromStart = 0;
    private final Timer timer;
    private final Background background;
    private final CarModel carModel;

    public DrawingPanel(int width, int height, int timerDelay) {
        this.PANEL_WIDTH = width;
        this.PANEL_HEIGHT = height;
        this.timer = new Timer(timerDelay, this);
        this.background = new Background(Color.CYAN, Color.GRAY, Color.YELLOW,
                (int)(PANEL_HEIGHT * 0.65), 100, PANEL_WIDTH - 250);
        this.carModel = new CarModel((int)(0.1 * PANEL_WIDTH), (int)(0.4 * PANEL_HEIGHT),
                (int)(0.45 * PANEL_WIDTH), (int)(0.4 * PANEL_HEIGHT), 12,
                Color.YELLOW, Color.BLUE, Color.WHITE, Color.RED);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        background.draw(graphics, PANEL_WIDTH, PANEL_HEIGHT);
        carModel.draw(graphics);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == timer) {
            repaint();
            ticksFromStart++;
        }
    }
}
