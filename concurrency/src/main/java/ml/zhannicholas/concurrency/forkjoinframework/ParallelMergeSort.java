package ml.zhannicholas.concurrency.forkjoinframework;

import java.util.concurrent.RecursiveAction;

/**
 * Merge sort using Fork/Join framework.
 */
public class ParallelMergeSort extends RecursiveAction{
    private final int[] array;
    private final int left;
    private final int right;

    public ParallelMergeSort(int[] array) {
        this(array, 0, array.length - 1);
    }

    public ParallelMergeSort(int[] array, int left, int right) {
        this.array = array;
        this.left = left;
        this.right = right;
    }

    public void sort() {
        compute();
    }


    @Override
    protected void compute() {
        if (left < right) {
            if (right - left < 128) {
                insertionSort(left, right);
            } else {
                int mid = left + (right - left) / 2;
                RecursiveAction leftSort = new ParallelMergeSort(array, left, mid);
                RecursiveAction rightSort = new ParallelMergeSort(array, mid + 1, right);
                invokeAll(leftSort, rightSort);
                merge(left, mid, right);
            }
        }
    }

    private void insertionSort(int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int cur = array[i];
            int j = i - 1;
            while (left <= j && cur < array[j]) {
                array[j + 1] = array[j--];
            }
            array[j + 1] = cur;
        }
    }

    private void merge(int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int li = left, ri = mid + 1, i = 0;
        while (li <= mid && ri <= right) {
            if (array[li] <= array[ri]) {
                temp[i++] = array[li++];
            } else {
                temp[i++] = array[ri++];
            }
        }
        while (li <= mid) {
            temp[i++] = array[li++];
        }
        while (ri <= right) {
            temp[i++] = array[ri++];
        }

        System.arraycopy(temp, 0, array, left, temp.length);
    }
}
