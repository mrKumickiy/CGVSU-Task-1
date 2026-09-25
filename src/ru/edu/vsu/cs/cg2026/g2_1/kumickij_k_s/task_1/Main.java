package ru.edu.vsu.cs.cg2026.g2_1.kumickij_k_s.task_1;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args){
        MainWindow mainWindow = new MainWindow(1280,720);
        mainWindow.setTitle("Машина едет по дороге");
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);;
        mainWindow.setVisible(true);

        DrawingPanel panel = mainWindow.getPanel();
        panel.add(new Sky(Color.CYAN, 100, mainWindow.getWidth() - 250, 25, Color.YELLOW));
        Road road = new Road(20, (int)(0.65 * mainWindow.getHeight()), Color.GRAY, (int)(0.2 * mainWindow.getWidth()), (int)(0.1 * mainWindow.getHeight()), (int)(0.05 * mainWindow.getWidth()), Color.WHITE);
        road.setMarkupY(road.getRoadHeight()/2 - road.getMarkupHeight());
        panel.add(road);
        panel.add(new Car((int)(0.1 * mainWindow.getWidth()), (int)(0.4 *  mainWindow.getHeight()), (int)(0.45 *  mainWindow.getWidth()), (int)(0.4 *  mainWindow.getHeight()),
                (int)(0.125 * 0.45 * mainWindow.getWidth()), 15,12,
                Color.YELLOW, Color.BLUE, Color.WHITE, Color.RED, Color.BLACK, Color.LIGHT_GRAY));
    }
}
