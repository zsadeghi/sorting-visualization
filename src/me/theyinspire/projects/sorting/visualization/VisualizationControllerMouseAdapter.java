package me.theyinspire.projects.sorting.visualization;

import me.theyinspire.projects.sorting.visualization.viz.VisualizationProducer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Zohreh Sadeghi (zsadeghi@uw.edu)
 * @since 1.0 (11/29/16, 11:14 PM)
 */
public class VisualizationControllerMouseAdapter extends MouseAdapter {

    private final VisualizationProducer producer;

    public VisualizationControllerMouseAdapter(VisualizationProducer producer) {
        this.producer = producer;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        producer.togglePause();
    }

}
