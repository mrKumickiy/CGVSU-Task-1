package ru.edu.vsu.cs.cg2026.g2_1.kumickij_k_s.task_1;

import java.awt.*;

public class Car implements DrawableObject {
    private final CarBody body;
    private final CarWheel backWheel;
    private final CarWheel frontWheel;
    private int wheelAngularSpeed;

    public Car(int x, int y, int width, int height, int wheelRadius, int wheelAngularSpeed, int roundness,
               Color bodyColor, Color windowColor, Color frontLightColor, Color backLightColor,
               Color wheelColor, Color diskColor) {
        this.body = new CarBody(x, y, width, height, roundness, bodyColor, windowColor, frontLightColor, backLightColor);
        this.backWheel = new CarWheel((int) (body.getX() + 0.1 * body.getWidth()), body.getY() + body.getHeight() - wheelRadius, wheelRadius, wheelColor, diskColor);
        this.frontWheel = new CarWheel((int) (body.getX() + 0.9 * body.getWidth() - 2 * wheelRadius), body.getY() + body.getHeight() - wheelRadius, wheelRadius, wheelColor, diskColor);
        this.wheelAngularSpeed = wheelAngularSpeed;
    }

    public void setX(int x) {
        this.body.setX(x);
        this.backWheel.setX((int) (body.getX() + 0.1 * body.getWidth()));
        this.frontWheel.setX((int) (body.getX() + 0.9 * body.getWidth()));
    }

    public void setY(int y) {
        this.body.setY(y);
        this.backWheel.setY(body.getY() + body.getHeight() - 2 * backWheel.getRadius());
        this.frontWheel.setY(body.getY() + body.getHeight() - 2 * frontWheel.getRadius());
    }

    public void setWidth(int width) {
        this.body.setWidth(width);
        this.backWheel.setX((int) (body.getX() + 0.1 * body.getWidth()));
        this.frontWheel.setX((int) (body.getX() + 0.9 * body.getWidth()));
    }

    public void setHeight(int height) {
        this.body.setHeight(height);
        this.backWheel.setY(body.getY() + body.getHeight() - 2 * backWheel.getRadius());
        this.frontWheel.setY(body.getY() + body.getHeight() - 2 * frontWheel.getRadius());
    }

    public void setWheelRadius(int radius) {
        this.backWheel.setRadius(radius);
        this.frontWheel.setRadius(radius);
        this.backWheel.setY(body.getY() + body.getHeight() - 2 * backWheel.getRadius());
        this.frontWheel.setY(body.getY() + body.getHeight() - 2 * frontWheel.getRadius());
    }

    public void setAngle(double angle) {
        this.backWheel.setAngle(angle);
        this.frontWheel.setAngle(angle);
    }

    public void setRoundness(int roundness) {
        this.body.setRoundness(roundness);
    }

    public void setBodyColor(Color bodyColor) {
        this.body.setBodyColor(bodyColor);
    }

    public void setWindowColor(Color windowColor) {
        this.body.setWindowColor(windowColor);
    }

    public void setFrontLightColor(Color frontLightColor) {
        this.body.setFrontLightColor(frontLightColor);
    }

    public void setBackLightColor(Color backLightColor) {
        this.body.setBackLightColor(backLightColor);
    }

    public void setWheelColor(Color wheelColor) {
        this.backWheel.setWheelColor(wheelColor);
        this.frontWheel.setWheelColor(wheelColor);
    }

    public void setDiskColor(Color diskColor) {
        this.backWheel.setDiskColor(diskColor);
        this.frontWheel.setDiskColor(diskColor);
    }

    public void setWheelAngularSpeed(int speed) {
        this.wheelAngularSpeed = speed;
    }

    @Override
    public void draw(Graphics graphics, int panelWidth, int panelHeight) {
        this.body.draw(graphics, panelWidth, panelHeight);
        this.backWheel.draw(graphics, panelWidth, panelHeight);
        this.frontWheel.draw(graphics, panelWidth, panelHeight);
    }
    @Override
    public void update(int tick) {
        this.backWheel.setAngle(Math.toRadians(wheelAngularSpeed * tick));
        this.frontWheel.setAngle(Math.toRadians(wheelAngularSpeed * tick));
    }
}
