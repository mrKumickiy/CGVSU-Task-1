package ru.edu.vsu.cs.cg2026.g2_1.kumickij_k_s.task_1;

import java.awt.*;

public class CarBody {
    private int x;
    private int y;
    private int width;
    private int height;
    private int roundness;
    private Color bodyColor;
    private Color windowColor;
    private Color frontLightColor;
    private Color backLightColor;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setRoundness(int roundness) {
        this.roundness = roundness;
    }

    public void setBodyColor(Color bodyColor) {
        this.bodyColor = bodyColor;
    }

    public void setWindowColor(Color windowColor) {
        this.windowColor = windowColor;
    }

    public void setFrontLightColor(Color frontLightColor) {
        this.frontLightColor = frontLightColor;
    }

    public void setBackLightColor(Color backLightColor) {
        this.backLightColor = backLightColor;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public CarBody(int x, int y, int width, int height, int roundness, Color bodyColor, Color windowColor, Color frontLightColor, Color backLightColor) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.roundness = roundness;
        this.bodyColor = bodyColor;
        this.windowColor = windowColor;
        this.frontLightColor = frontLightColor;
        this.backLightColor = backLightColor;
    }

    public void draw(Graphics graphics) {
        Graphics2D gr = (Graphics2D) graphics;

        int upperBodyWidth = (int)(0.65 * width);
        int upperBodyHeight = (int)(0.425 * height);
        int upperBodyX = (int)(x + (float)((width - upperBodyWidth) / 2));
        int lowerBodyY = y + upperBodyHeight;
        int lowerBodyHeight = height - upperBodyHeight;

        drawBody(gr, upperBodyWidth, upperBodyHeight, upperBodyX, lowerBodyHeight, lowerBodyY);
        drawWindow(gr, upperBodyWidth, upperBodyHeight, upperBodyX);
        drawLights(gr, lowerBodyY, lowerBodyHeight);
    }

    private void drawBody(Graphics2D gr, int upperBodyWidth, int upperBodyHeight, int upperBodyX, int lowerBodyHeight, int lowerBodyY) {
        gr.setColor(bodyColor);
        gr.fillRoundRect(upperBodyX, y, upperBodyWidth, upperBodyHeight + roundness, roundness, roundness);
        gr.fillRoundRect(x, lowerBodyY, width, lowerBodyHeight, roundness, roundness);
    }

    private void drawWindow(Graphics2D gr, int upperBodyWidth, int upperBodyHeight, int upperBodyX) {
        int winWidth = (int)(0.85 * upperBodyWidth);
        int winHeight = (int)(0.75 * upperBodyHeight);
        int winX =(int)(upperBodyX + (float)((upperBodyWidth - winWidth)/2));
        int winY = (int)(y + (float)((upperBodyHeight - winHeight)/2));

        gr.setColor(windowColor);
        gr.fillRoundRect(winX, winY, winWidth, winHeight, roundness, roundness);
    }

    private void drawLights(Graphics2D gr, int lowerBodyY, int lowerBodyHeight) {
        int lightWidth = (int)(0.15 * width);
        int lightHeight = (int)(0.25 * lowerBodyHeight);
        int lightY = (int)(1.1 * lowerBodyY);
        int frontLightX = x + width - lightWidth;

        gr.setColor(frontLightColor);
        gr.fillOval(frontLightX, lightY, lightWidth, lightHeight);
        gr.setColor(backLightColor);
        gr.fillRoundRect(x, lightY, lightWidth, lightHeight, roundness, roundness);
        gr.setColor(Color.BLACK);
        gr.drawOval(frontLightX, lightY, lightWidth, lightHeight);
        gr.drawRoundRect(x, lightY, lightWidth, lightHeight, roundness, roundness);
    }
}
