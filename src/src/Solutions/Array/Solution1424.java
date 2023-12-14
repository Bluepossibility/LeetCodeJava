package Solutions.Array;

import java.util.*;

public class Solution1424 {

    public static int[] findDiagonalOrder(List<List<Integer>> nums) {
        HashMap<Integer, List<Integer>> diagonalMap = new HashMap<>();
        for (int r = nums.size() - 1; r >= 0; r--){
            for (int c = 0; c < nums.get(r).size(); c++){
                int diagonalDiff = (nums.size() - r) - c;
                List<Integer> previousDiagonal = diagonalMap.getOrDefault(diagonalDiff, new ArrayList<>());
                previousDiagonal.add(nums.get(r).get(c));
                diagonalMap.put(diagonalDiff, previousDiagonal);
            }
        }

        List<Integer> ansList = new ArrayList<>();
        SortedSet<Integer> diagonalMapSortedKeys = new TreeSet<>(diagonalMap.keySet()).descendingSet();
        for (Integer diagonalDiff : diagonalMapSortedKeys){
            ansList.addAll(diagonalMap.get(diagonalDiff));
        }
        return ansList.stream().mapToInt(i->i).toArray();
    }
}
