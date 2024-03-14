package Solutions.Graph;

import java.util.*;

public class Solution2092 {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // For each person, store the meeting time and the label of the person he/she met in a hashmap
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] meeting: meetings){
            int x = meeting[0];
            int y = meeting[1];
            int t = meeting[2];
            graph.computeIfAbsent(x, k -> new ArrayList<>()).add(new int[]{t, y});
            graph.computeIfAbsent(y, k -> new ArrayList<>()).add(new int[]{t, x});
        }
        // For each person, store the earliest time he/she knows the secret in an Array
        int[] earliest = new int[n];
        Arrays.fill(earliest, Integer.MAX_VALUE);
        earliest[0] = 0;
        earliest[firstPerson] = 0;
        // Initialize queue, each element is {label of person, time he/she knows about the secret}
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        q.offer(new int[]{firstPerson, 0});
        // Start BFS
        while (!q.isEmpty()) {
            int[] personTime = q.poll();
            int person = personTime[0];
            int time = personTime[1];
            for (int[] nextPersonTime : graph.getOrDefault(person, new ArrayList<>())) {
                int meetingTime = nextPersonTime[0];
                int nextPerson = nextPersonTime[1];
                if (meetingTime >= time && earliest[nextPerson] > meetingTime) {
                    earliest[nextPerson] = meetingTime;
                    q.offer(new int[]{nextPerson, meetingTime});
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (earliest[i] != Integer.MAX_VALUE) {
                ans.add(i);
            }
        }
        return ans;
    }
}
