package me.theyinspire.projects.sorting.visualization.sort;

/**
 * @author Zohreh Sadeghi (zsadeghi@uw.edu)
 * @since 1.0 (6/6/15, 4:27 PM)
 */
public final class ArrayUtils {

    private ArrayUtils() {
        throw new UnsupportedOperationException();
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
