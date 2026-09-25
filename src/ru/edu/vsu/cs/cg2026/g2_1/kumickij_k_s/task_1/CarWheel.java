package ru.edu.vsu.cs.cg2026.g2_1.kumickij_k_s.task_1;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class CarWheel implements DrawableObject {
    private int x;
    private int y;
    private int radius;
    private double angle = 0;
    private Color wheelColor;
    private Color diskColor;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public void setWheelColor(Color wheelColor) {
        this.wheelColor = wheelColor;
    }

    public void setDiskColor(Color diskColor) {
        this.diskColor = diskColor;
    }

    public int getRadius() {
        return radius;
    }
    public CarWheel(int x, int y, int radius, Color wheelColor, Color diskColor) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.wheelColor = wheelColor;
        this.diskColor = diskColor;
    }

    public CarWheel(int x, int y, int radius, int angle, Color wheelColor, Color diskColor) {
        this(x, y, radius, wheelColor, diskColor);
        this.angle = angle;
    }

    @Override
    public void draw(Graphics graphics, int panel_width, int panel_height) {
        int rectWidth = (int) (2 * 0.75 * radius);
        int rectHeight = (int) (2 * 0.15 * radius);
        Graphics2D gr = (Graphics2D) graphics;

        gr.setColor(wheelColor);
        gr.fillOval(x, y, 2 * radius, 2 * radius);

        gr.setColor(diskColor);
        Rectangle rectangle = new Rectangle(-rectWidth/2, -rectHeight/2, rectWidth, rectHeight);
        AffineTransform transform = new AffineTransform();
        transform.translate(x + radius, y + radius);
        transform.rotate(angle);
        for (int i = 0; i < 4; i++) {
            Shape angledRect = transform.createTransformedShape(rectangle);
            gr.fill(angledRect);
            transform.rotate(-Math.PI/4);
        }

    }
}
