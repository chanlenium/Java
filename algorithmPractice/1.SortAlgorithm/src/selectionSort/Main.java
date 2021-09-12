package selectionSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();

        int[] arr = new int[]{2, 8, 0, 5, 7};
        selectionSort.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
