package ru.edu.vsu.cs.cg2026.g2_1.kumickij_k_s.task_1;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        MainWindow mainWindow = new MainWindow(1280,720);
        mainWindow.setTitle("Машина едет по дороге");
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);;
        mainWindow.setVisible(true);
    }
}
