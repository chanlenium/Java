package bubbleSort;

/** Bubble sort :
 * Comparing neighboring data, sending and sorting the largest data to the back.
 * Worst complexity: n^2
 * Average complexity: n^2
 * Best complexity: n
 * Space complexity: 1
 */

public class BubbleSort {
    public void sort(int[] arr) {
        for(int k = 1; k < arr.length-1; k++){
            for(int i = 0; i < arr.length-k; i++){
                if(arr[i] > arr[i+1]){
                    int temp = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
