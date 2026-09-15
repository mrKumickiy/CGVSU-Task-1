package ru.edu.vsu.cs.cg2026.g2_1.kumickij_k_s.task_1;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private final DrawingPanel panel;

    public MainWindow(int width, int height) throws HeadlessException {
        setSize(width, height);
        panel = new DrawingPanel(this.getWidth(), this.getHeight(),100);
        this.add(panel);
    }
}
