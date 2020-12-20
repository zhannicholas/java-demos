package ml.zhannicholas.concurrency.forkjoinframework;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ParallelMergeSortTest {

    private int[] createArray(int length) {
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    @Test
    void sort() {
        int[] array = createArray(10_000_000);
        int[] copy = new int[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        Arrays.sort(copy);
        ParallelMergeSort forkJoinArraySort = new ParallelMergeSort(array);
        forkJoinArraySort.sort();
        assertArrayEquals(array, copy);
    }
}