package me.theyinspire.projects.sorting.visualization.sort;

import me.theyinspire.projects.sorting.visualization.viz.Visualization;
import me.theyinspire.projects.sorting.visualization.viz.VisualizationProducer;

/**
 * @author Zohreh Sadeghi (zsadeghi@uw.edu)
 * @since 1.0 (11/29/16, 10:07 PM)
 */
public class InsertionSorter implements Sorter {

    private final VisualizationProducer producer;

    public InsertionSorter(VisualizationProducer producer) {
        this.producer = producer;
    }

    @Override
    public void sort(int[] items) {
        for (int i = 1; i < items.length; i++) {
            int item = items[i];
            int placement = findPlacement(items, item, i);
            System.arraycopy(items, placement, items, placement + 1, i - placement);
            items[placement] = item;
            producer.visualize(new Visualization(items, 0, items.length, 0));
        }
    }


    /**
     * This method finds where a given item should be placed according to the provided comparator by looking at all the items
     * in the specified portion of the input array of items
     * @param items         all the items
     * @param item          the item which we want to place
     * @param length        the length of the array which should be visited
     * @return the position of the item compared to the array, which can range from {@literal 0} to {@literal length} (thus
     * indicating that the item is comparatively larger than all the other items).
     */
    private int findPlacement(int[] items, int item, int length) {
        int placement = length;
        for (int j = 0; j < length; j ++) {
            if (items[j] > item) {
                placement = j;
                break;
            }
        }
        return placement;
    }

}
