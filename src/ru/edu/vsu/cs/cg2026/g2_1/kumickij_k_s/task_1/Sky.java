package ru.edu.vsu.cs.cg2026.g2_1.kumickij_k_s.task_1;

import java.awt.*;

public class Sky implements DrawableObject {
    private Color skyColor;
    private int sunRadius;
    private int sunX;
    private int sunY;
    private Color sunColor;

    public void setSkyColor(Color skyColor) {
        this.skyColor = skyColor;
    }

    public void setSunColor(Color sunColor) {
        this.sunColor = sunColor;
    }

    public void setSunRadius(int sunRadius) {
        this.sunRadius = sunRadius;
    }

    public void setSunX(int sunX) {
        this.sunX = sunX;
    }

    public void setSunY(int sunY) {this.sunY = sunY; }

    public Sky(Color skyColor, int sunRadius, int sunX, int sunY, Color sunColor) {
        this.skyColor = skyColor;
        this.sunRadius = sunRadius;
        this.sunX = sunX;
        this.sunY = sunY;
        this.sunColor = sunColor;
    }

    @Override
    public void draw(Graphics graphics,int panelWidth,int panelHeight) {
        Graphics2D gr = (Graphics2D) graphics;
        gr.setColor(skyColor);
        gr.fillRect(0,0, panelWidth, panelHeight);

        gr.setColor(sunColor);
        gr.fillOval(sunX,sunY,2 * sunRadius, 2 * sunRadius);
    }
}
