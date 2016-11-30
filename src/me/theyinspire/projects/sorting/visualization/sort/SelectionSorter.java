package me.theyinspire.projects.sorting.visualization.sort;

import me.theyinspire.projects.sorting.visualization.viz.Visualization;
import me.theyinspire.projects.sorting.visualization.viz.VisualizationProducer;

/**
 * @author Zohreh Sadeghi (zsadeghi@uw.edu)
 * @since 1.0 (11/29/16, 10:37 PM)
 */
public class SelectionSorter implements Sorter {

    private final VisualizationProducer producer;

    public SelectionSorter(VisualizationProducer producer) {
        this.producer = producer;
    }

    @Override
    public void sort(int[] items) {
        for (int i = 0; i < items.length; i ++) {
            int localMinimum = -1;
            for (int j = i; j < items.length; j ++) {
                if (localMinimum < 0 || items[j] < items[localMinimum]) {
                    localMinimum = j;
                }
            }
            ArrayUtils.swap(items, i, localMinimum);
            producer.visualize(new Visualization(items, i, items.length, i));
        }
    }

}
