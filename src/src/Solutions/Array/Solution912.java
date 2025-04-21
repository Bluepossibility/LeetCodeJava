package Solutions.Array;

public class Solution912 {
    // * Merge Sort
    public int[] sortArray(int[] nums) {
        int[] tempArray = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, tempArray);
        return nums;
    }

    private void mergeSort(int[] arr, int left, int right, int[] tempArr){
        if (left < right){
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, tempArr);
            mergeSort(arr, mid + 1, right, tempArr);
            mergeTwoParts(arr, left, mid, right, tempArr);
        }

    }

    private void mergeTwoParts(int[] arr, int left, int mid, int right, int[] tempArr) {
        int start1 = left;
        int start2 = mid + 1;
        int length1 = mid - left + 1;
        int length2 = right - mid;

        for (int i = 0; i < length1; i++){
            tempArr[start1 + i] = arr[start1 + i];
        }
        for (int j = 0; j < length2 ; j++){
            tempArr[start2 + j] = arr[start2 + j];
        }
        // Merge the sub arrays in tempArray back into the original array 'arr' in sorted order
        int i = 0;
        int j = 0;
        int k = left;
        while (i < length1 && j < length2){
            if (tempArr[start1 + i] <= tempArr[start2 + j]){
                arr[k] = tempArr[start1 + i];
                i += 1;
            } else{
                arr[k] = tempArr[start2 + j];
                j += 1;
            }
            k += 1;
        }
        // Copy remaining elements
        while (i < length1){
            arr[k] = tempArr[start1 + i];
            i += 1;
            k += 1;
        }
        while (j < length2){
            arr[k] = tempArr[start2 + j];
            j += 1;
            k += 1;
        }
    }
}
