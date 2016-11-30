package me.theyinspire.projects.sorting.visualization;

import me.theyinspire.projects.sorting.visualization.viz.VisualizationProducer;

import javax.swing.*;

/**
 * @author Zohreh Sadeghi (zsadeghi@uw.edu)
 * @since 1.0 (11/29/16, 9:24 PM)
 */
public class MainPanelLauncher implements Runnable {

    private MainFrame frame;

    public void init(VisualizationProducer producer) {
        frame = new MainFrame(producer);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void run() {
        try {
            UIManager.setLookAndFeel(UIManager.getLookAndFeel());
        } catch (UnsupportedLookAndFeelException ignored) {
        }
    }

    public void draw(int[] array, int from, int to, int offset) {
        frame.draw(array, from, to, offset);
    }

    public void clear() {
        frame.clear();
    }

}
