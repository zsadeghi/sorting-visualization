package me.theyinspire.projects.sorting.visualization;

import me.theyinspire.projects.sorting.visualization.viz.VisualizationProducer;

import javax.swing.*;
import java.awt.*;

/**
 * @author Zohreh Sadeghi (zsadeghi@uw.edu)
 * @since 1.0 (11/29/16, 9:26 PM)
 */
public class MainFrame extends JFrame {

    private final MainPanel panel;

    public MainFrame(VisualizationProducer producer) throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        panel = new MainPanel(producer);
        add(panel);
    }

    public void draw(int[] array, int from, int to, int offset) {
        panel.draw(array, from, to, offset);
    }

    public void clear() {
        panel.clear();
    }

}
