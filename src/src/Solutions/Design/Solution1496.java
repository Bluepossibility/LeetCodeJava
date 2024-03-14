package Solutions.Design;

import java.util.HashMap;
import java.util.HashSet;

public class Solution1496 {

    private class Pair<F, S> {
        private final F first;
        private final S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        public F getFirst() {
            return first;
        }

        public S getSecond() {
            return second;
        }

        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) obj;
            return first != null ? first.equals(pair.first) : pair.first == null &&
                    (second != null ? second.equals(pair.second) : pair.second == null);
        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        public <A, B> Pair<A, B> of(A first, B second) {
            return new Pair<>(first, second);
        }
    }

    public boolean isPathCrossing(String path) {
        HashMap<String, Pair<Integer, Integer>> str2PairMap = new HashMap<>();
        str2PairMap.put("N", new Pair<>(0, 1));
        str2PairMap.put("S", new Pair<>(0, -1));
        str2PairMap.put("W", new Pair<>(-1, 0));
        str2PairMap.put("E", new Pair<>(1, 0));
        int currX = 0;
        int currY = 0;
        HashSet<Pair<Integer, Integer>> visitedPairs = new HashSet<>();
        visitedPairs.add(new Pair<>(0, 0));
        for (char direction : path.toCharArray()){
            Pair<Integer, Integer> pair = str2PairMap.get(String.valueOf(direction));
            currX += pair.first;
            currY += pair.second;
            Pair<Integer, Integer> newPair = new Pair<>(currX, currY);
            if (visitedPairs.contains(newPair)){
                return true;
            }
            else{
                visitedPairs.add(newPair);
            }
        }
        return false;
    }
}
