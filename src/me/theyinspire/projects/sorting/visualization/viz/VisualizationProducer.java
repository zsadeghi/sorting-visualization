package me.theyinspire.projects.sorting.visualization.viz;

import me.theyinspire.projects.sorting.visualization.MainPanelLauncher;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Zohreh Sadeghi (zsadeghi@uw.edu)
 * @since 1.0 (11/29/16, 10:14 PM)
 */
public class VisualizationProducer implements Runnable {

    private final Queue<Visualization> queue;
    private final MainPanelLauncher launcher;
    private final int interval;
    private boolean paused;

    public VisualizationProducer(MainPanelLauncher launcher, int interval) {
        this.launcher = launcher;
        this.interval = interval;
        queue = new LinkedBlockingQueue<>();
        paused = true;
    }

    public void visualize(Visualization visualization) {
        queue.add(visualization);
    }

    public void togglePause() {
        paused = !paused;
    }

    @Override
    public void run() {
        while (true) {
            if (!paused && !queue.isEmpty()) {
                final Visualization visualization = queue.remove();
                launcher.draw(visualization.getArray(), visualization.getFrom(), visualization.getTo(), visualization.getOffset());
            }
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

}
