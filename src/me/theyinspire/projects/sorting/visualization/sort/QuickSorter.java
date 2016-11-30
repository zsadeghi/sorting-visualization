package me.theyinspire.projects.sorting.visualization.sort;

import me.theyinspire.projects.sorting.visualization.viz.Visualization;
import me.theyinspire.projects.sorting.visualization.viz.VisualizationProducer;

/**
 * @author Zohreh Sadeghi (zsadeghi@uw.edu)
 * @since 1.0 (11/29/16, 10:27 PM)
 */
public class QuickSorter implements Sorter {

    private final VisualizationProducer producer;

    public QuickSorter(VisualizationProducer producer) {
        this.producer = producer;
    }

    private void sort(int[] items, int from, int to) {
        if (from < to - 1) {
            if (to - from == 2) {
                if (items[from] > items[to - 1]) {
                    ArrayUtils.swap(items, from, to - 1);
                }
                return;
            }
            int middle = partition(items, from, to);
            sort(items, from, middle);
            sort(items, middle + 1, to);
        }
    }

    private int partition(int[] items, int from, int to) {
        final int partition = items[to - 1];
        int smaller = from - 1;
        int seen = from;
        while (seen < to - 1) {
            if (partition >= items[seen]) {
                smaller ++;
                ArrayUtils.swap(items, smaller, seen);
                producer.visualize(new Visualization(items, Math.max(0, from - 1), Math.min(to, items.length - 1), Math.max(0, from - 1)));
            }
            seen ++;
        }
        ArrayUtils.swap(items, smaller + 1, to - 1);
        return smaller + 1;
    }

    @Override
    public void sort(int[] items) {
        sort(items, 0, items.length);
    }

}
