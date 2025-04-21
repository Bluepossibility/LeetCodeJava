package Solutions.LinkedLists;

import java.util.LinkedList;
import java.util.List;

public class Solution1823 {
    public int findTheWinner(int n, int k) {
        List<Integer> circle = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            circle.add(i);
        }

        int startIndex = 0;
        while (circle.size() > 1){
            int removalIndex = (startIndex + k - 1) % circle.size();
            circle.remove(removalIndex);
            startIndex = removalIndex;
        }

        return circle.getFirst();
    }
}
