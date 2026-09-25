package ru.edu.vsu.cs.cg2026.g2_1.kumickij_k_s.task_1;

import java.awt.*;

public class Road implements DrawableObject {
    private int roadSpeed;
    private int roadHeight;
    private Color roadColor;
    private int markupWidth;
    private int markupHeight;
    private int markupPadding;
    private int markupPeriod;
    private int markupX = 0;
    private int markupY;
    private Color markupColor;

    public void setRoadHeight(int roadHeight) {
        this.roadHeight = roadHeight;
    }

    public void setRoadColor(Color roadColor) {
        this.roadColor = roadColor;
    }

    public void setMarkupWidth(int markupWidth) {
        this.markupWidth = markupWidth;
        markupPeriod = markupWidth + markupPadding;
    }

    public void setMarkupHeight(int markupHeight) {
        this.markupHeight = markupHeight;
    }

    public void setMarkupPadding(int markupPadding) {
        this.markupPadding = markupPadding;
        markupPeriod = markupWidth + markupPadding;
    }

    public void setMarkupColor(Color markupColor) {
        this.markupColor = markupColor;
    }

    public void setMarkupX(int x) {
        this.markupX = Math.abs(x) % markupPeriod;
    }

    public void setMarkupY(int y) {
        this.markupY = y;
    }

    public void setRoadSpeed(int speed) {this.roadSpeed = speed;}

    public int getRoadHeight() {
        return roadHeight;
    }

    public int getMarkupHeight() {
        return markupHeight;
    }

    public Road(int roadSpeed,int roadHeight, Color roadColor, int markupWidth, int markupHeight, int markupPadding, Color markupColor) {
        this.roadSpeed = roadSpeed;
        this.roadHeight = roadHeight;
        this.roadColor = roadColor;
        this.markupWidth = markupWidth;
        this.markupHeight = markupHeight;
        this.markupPadding = markupPadding;
        this.markupColor = markupColor;
        markupPeriod = markupWidth + markupPadding;
    }

    public Road(int roadSpeed, int roadHeight, Color roadColor, int markupWidth, int markupHeight, int markupPadding, int markupY, Color markupColor) {
        this(roadSpeed,roadHeight, roadColor, markupWidth, markupHeight, markupPadding, markupColor);
        this.markupY = markupY;
    }

    public Road(int roadSpeed, int roadHeight, Color roadColor, int markupWidth, int markupHeight, int markupPadding, int markupX, int markupY, Color markupColor) {
        this(roadSpeed, roadHeight, roadColor, markupWidth, markupHeight, markupPadding, markupY, markupColor);
        setMarkupX(markupX);
    }

    @Override
    public void draw(Graphics graphics, int panelWidth, int panelHeight) {
        Graphics2D gr = (Graphics2D) graphics;

        gr.setColor(roadColor);
        gr.fillRect(0,panelHeight - roadHeight, panelWidth, roadHeight);

        gr.setColor(markupColor);
        for (int x = panelWidth + markupPadding - markupX; x > -markupWidth; x -= markupPeriod) {
            gr.fillRect(x, panelHeight - roadHeight + markupY, markupWidth, markupHeight);
        }
    }
    @Override
    public void update(int tick) {
        setMarkupX(roadSpeed * tick);
    }
}
