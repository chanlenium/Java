package selectionSort;

/** Selection Sort
 * Find the minimum value among the given lists. The value is replaced with the first value (pass).
 * Except for the first location, change the list in the same way.
 * Worst complexity: n^2
 * Average complexity: n^2
 * Best complexity: n^2
 * Space complexity: 1
 */
public class SelectionSort {
    public int[] sort(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            int lowestNumberIndex = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[lowestNumberIndex]){
                    lowestNumberIndex = j;
                }
            }
            if(lowestNumberIndex != i) {
                int tempValue = arr[i];
                arr[i] = arr[lowestNumberIndex];
                arr[lowestNumberIndex] = tempValue;
            }
        }
        return arr;
    }
}
