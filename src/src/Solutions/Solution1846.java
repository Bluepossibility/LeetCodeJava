package Solutions;

import java.util.Arrays;

public class Solution1846 {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int ans = 1;
        for(int i = 1; i < arr.length; i++){
            if (arr[i] > arr[i-1] || arr[i] > i){
                ans += 1;
            }
        }
        return ans;
    }
}
