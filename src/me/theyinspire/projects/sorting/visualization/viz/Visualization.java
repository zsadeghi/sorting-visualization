package me.theyinspire.projects.sorting.visualization.viz;

/**
 * @author Zohreh Sadeghi (zsadeghi@uw.edu)
 * @since 1.0 (11/29/16, 10:10 PM)
 */
public class Visualization {

    private final int[] array;
    private final int from;
    private final int to;
    private final int offset;

    private static int[] copyOf(int[] array) {
        int[] copy = new int[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return copy;
    }

    public Visualization(int[] array, int from, int to, int offset) {
        this.array = copyOf(array);
        this.from = from;
        this.to = to;
        this.offset = offset;
    }

    public int[] getArray() {
        return array;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getOffset() {
        return offset;
    }
}
