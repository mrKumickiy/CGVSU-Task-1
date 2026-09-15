package ru.edu.vsu.cs.cg2026.g2_1.kumickij_k_s.task_1;

import javax.swing.*;
import java.awt.*;

public class Window extends JPanel {

    public Window() throws HeadlessException {
        DrawingPanel drawingPanel = new DrawingPanel(this.getWidth(), this.getHeight(),100);
        this.add(drawingPanel);
    }
}
