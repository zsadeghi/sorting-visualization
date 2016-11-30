package me.theyinspire.projects.sorting.visualization.sort;

import me.theyinspire.projects.sorting.visualization.viz.Visualization;
import me.theyinspire.projects.sorting.visualization.viz.VisualizationProducer;

/**
 * @author Zohreh Sadeghi (zsadeghi@uw.edu)
 * @since 1.0 (11/29/16, 10:39 PM)
 */
public class BubbleSorter implements Sorter {

    private final VisualizationProducer producer;

    public BubbleSorter(VisualizationProducer producer) {
        this.producer = producer;
    }

    @Override
    public void sort(int[] items) {
        for (int i = 0; i < items.length - 1; i ++) {
            for (int j = items.length - 1; j > i; j --) {
                if (items[j] < items[j - 1]) {
                    ArrayUtils.swap(items, j, j - 1);
                    producer.visualize(new Visualization(items, i, items.length, i));
                }
            }
        }

    }

}
