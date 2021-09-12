package bubbleSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();

        int[] array = new int[]{8, 2, 14, 7, 5};
        bubbleSort.sort(array);

        System.out.println(Arrays.toString(array));
    }
}
