package me.theyinspire.projects.sorting.visualization.sort;

import me.theyinspire.projects.sorting.visualization.viz.Visualization;
import me.theyinspire.projects.sorting.visualization.viz.VisualizationProducer;

import java.lang.reflect.Array;

/**
 * @author Zohreh Sadeghi (zsadeghi@uw.edu)
 * @since 1.0 (11/29/16, 10:34 PM)
 */
public class MergeSorter implements Sorter {

    private final VisualizationProducer producer;

    public MergeSorter(VisualizationProducer producer) {
        this.producer = producer;
    }

    /**
     * This method merges the two halves of an array, given that each half is sorted individually
     * @param array    the array
     * @param from     the starting point of the array
     * @param mid      the middle of the array
     * @param to       the end of the array
     */
    @SuppressWarnings("unchecked")
    protected void merge(int[] array, int from, int mid, int to) {
        //let's create two arrays for the left and right portions of the original array
        final int[] left = (int[]) Array.newInstance(array.getClass().getComponentType(), mid - from);
        final int[] right = (int[]) Array.newInstance(array.getClass().getComponentType(), to - mid);
        System.arraycopy(array, from, left, 0, left.length);
        System.arraycopy(array, mid, right, 0, right.length);
        //we need two cursors, each of which are pointing at the current point of interest in either array
        int leftCursor = 0;
        int rightCursor = 0;
        //we need a cursor which points to the point at which the winning item should be written
        int cursor = from;
        while (cursor < to) {
            final Integer leftItem;
            final Integer rightItem;
            if (leftCursor < left.length) {
                leftItem = left[leftCursor];
            } else {
                leftItem = null;
            }
            if (rightCursor < right.length) {
                rightItem = right[rightCursor];
            } else {
                rightItem = null;
            }
            if (leftItem == null) {
                array[cursor] = rightItem;
                rightCursor ++;
            } else if (rightItem == null) {
                array[cursor] = leftItem;
                leftCursor ++;
            } else if (rightItem < leftItem) {
                array[cursor] = rightItem;
                rightCursor ++;
            } else {
                array[cursor] = leftItem;
                leftCursor ++;
            }
            cursor ++;
            producer.visualize(new Visualization(array, from, to, from));
        }
    }

    protected void sort(int[] items, int from, int to) {
        if (to - from < 2) {
            return;
        }
        int mid = from + (to - from) / 2;
        sort(items, from, mid);
        sort(items, mid, to);
        merge(items, from, mid, to);
    }

    @Override
    public final void sort(int[] items) {
        sort(items, 0, items.length);
    }

}
