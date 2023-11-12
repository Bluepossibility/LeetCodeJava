package Solutions;

import java.util.*;

public class Solution815 {
    /*
    You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.

    For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.
    You will start at the bus stop source (You are not on any bus initially), and you want to go to the bus stop target. You can travel between bus stops by buses only.

    Return the least number of buses you must take to travel from source to target. Return -1 if it is not possible.
    */


    public int numBusesToDestination(int[][] routes, int source, int target) {
        // * Return 0 if the source and target are the same.
        if (source == target) {
            return 0;
        }

        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        // * Initialize an empty map from an integer to a list of integers adjList to store the edges. The key is the bus stop and the value is the list of integers denoting the indices of routes that have this stop.
        for (int r = 0; r < routes.length; r++){
            for (int stop : routes[r]){
                // Add all the routes that have this stop
                ArrayList<Integer> route = adjList.getOrDefault(stop, new ArrayList<>());
                route.add(r);
                adjList.put(stop, route);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<Integer>(routes.length);
        // Insert all the routes in the queue that have the source stop.
        for (int route : adjList.get(source)){
            q.add(route);
            vis.add(route);
        }
        int busCount = 1;
        while(!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int route = q.remove();

                // Iterate over the stops in the current route.
                for (int stop: routes[route]){
                    // Return the current buses taken count if the target is found.
                    if (stop == target) {
                        return busCount;
                    }
                    // Iterate over the next possible routes from the current stop.
                    for (int nextRoute : adjList.get(stop)){
                        if (!vis.contains(nextRoute)){
                            vis.add(nextRoute);
                            q.add(nextRoute);
                        }
                    }
                }
            }
            busCount++;
        }
        return -1;
    }
}
