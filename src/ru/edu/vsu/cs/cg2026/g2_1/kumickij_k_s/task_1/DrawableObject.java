package ru.edu.vsu.cs.cg2026.g2_1.kumickij_k_s.task_1;

import java.awt.*;

public interface DrawableObject {
    void draw(Graphics graphics, int PANEL_WIDTH, int PANEL_HEIGHT);
    default void update(int tick) {}
}
