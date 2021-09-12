package insertionSort;

/** InsertionSort
 * Starting with the second element(arr[i]), specifies a position to insert compared to the elements on the left,
 * then moves the element back and inserts the data into the designated position.
 * Worst complexity: n^2
 * Average complexity: n^2
 * Best complexity: n
 * Space complexity: 1
 */

public class InsertionSort {
    public int[] sort(int[] arr) {
        for(int i = 1; i < arr.length; i++){
            // select index and store the value corresponding to the index
            int index = i;
            int temp_value = arr[index];

            /** Shift values
            // compare 'temp_value' with its left values.
            // when the left value is larger than 'temp_value', the left value is shifted to the right
            // Shift process ends until there is no more left value or the left value is smaller than 'temp_value'*/
            while(index > 0 && (arr[index-1] > temp_value)){
                arr[index] = arr[index-1];
                index--;
            }
            arr[index] = temp_value;
        }
        return arr;
    }
}
