package ru.edu.vsu.cs.cg2026.g2_1.kumickij_k_s.task_1;

import java.awt.*;

public class Background {
    private Color skyColor;
    private Color groundColor;
    private Color sunColor;
    private int skyHeight;
    private int sunRadius;
    private int sunXOffset;

    public Background(Color skyColor, Color groundColor, Color sunColor, int skyHeight, int sunRadius, int sunXOffset) {
        this.skyColor = skyColor;
        this.groundColor = groundColor;
        this.sunColor = sunColor;
        this.skyHeight = skyHeight;
        this.sunRadius = sunRadius;
        this.sunXOffset = sunXOffset;
    }

    void draw(Graphics graphics,int panelWidth,int panelHeight) {
        Graphics2D gr = (Graphics2D) graphics;
        gr.setColor(skyColor);
        gr.fillRect(0,0, panelWidth, skyHeight);

        gr.setColor(sunColor);
        gr.fillOval(sunXOffset,skyHeight / 2-2*sunRadius,sunRadius * 2, sunRadius * 2);

        gr.setColor(groundColor);
        gr.fillRect(0,skyHeight, panelWidth, panelHeight - skyHeight);
    }
}
