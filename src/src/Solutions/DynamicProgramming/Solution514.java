package Solutions.DynamicProgramming;

import Solutions.Design.Solution1496;

import java.util.HashMap;
import java.util.Map;

public class Solution514 {

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

    private static final int MAX = Integer.MAX_VALUE;

    public int findRotateSteps(String ring, String key) {
        HashMap<Pair<Integer, Integer>, Integer> bestSteps = new HashMap<>();
        return tryLock(0, 0, ring, key, MAX, bestSteps);
    }

    // Find the minimum steps between two indexes of ring
    private int countSteps(int curr, int next, int ringLength){
        int stepsBetween = Math.abs(curr - next);
        int stepsAround = ringLength - stepsBetween;
        return Math.min (stepsAround, stepsBetween);
    }

    public int tryLock(int ringIndex, int keyIndex, String ring, String key, int minSteps, Map<Pair<Integer, Integer>, Integer> bestSteps){
        if (bestSteps.containsKey(new Pair<>(ringIndex, keyIndex)))
            return bestSteps.get(new Pair<>(ringIndex, keyIndex));
        if (keyIndex == key.length())
            return 0;
        for (int charIndex = 0; charIndex < ring.length(); charIndex++){
            if (ring.charAt(charIndex) == key.charAt(keyIndex)){
                int totalSteps = countSteps(ringIndex, charIndex, ring.length()) + 1 + tryLock(charIndex, keyIndex + 1, ring, key, MAX, bestSteps);
                minSteps = Math.min(minSteps, totalSteps);
                bestSteps.put(new Pair<>(ringIndex, keyIndex), minSteps);
            }
        }
        return minSteps;
    }
}
