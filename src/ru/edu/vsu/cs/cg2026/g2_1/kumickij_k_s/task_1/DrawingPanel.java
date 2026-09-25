package ru.edu.vsu.cs.cg2026.g2_1.kumickij_k_s.task_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DrawingPanel extends JPanel implements ActionListener {
    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;
    private int ticksFromStart = 0;
    private final java.util.List<DrawableObject> objectList;
    private final Timer timer;


    public DrawingPanel(int width, int height, int timerDelay) {
        this.PANEL_WIDTH = width;
        this.PANEL_HEIGHT = height;
        this.timer = new Timer(timerDelay, this);
        this.objectList = new ArrayList<>();
        timer.start();
    }

    public void add(DrawableObject object) {
        objectList.add(object);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        for (DrawableObject object : objectList) {
            object.draw(graphics, PANEL_WIDTH, PANEL_HEIGHT);
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == timer) {
            ticksFromStart++;
            for (DrawableObject object : objectList) {
                object.update(ticksFromStart);
            }
            repaint();
        }
    }
}
