package Solutions;

import com.sun.jdi.connect.spi.TransportService;

import java.util.*;

public class Solution346 {

    public static class MovingAverage{

        int size;
        int windowSum = 0;
        int count = 0;
        Deque<Integer> queue = new ArrayDeque<>();

        public MovingAverage(int size) {
            this.size = size;
        }

        public double next(int val) {
           count++;
           queue.add(val);
           int tail = count > size ? (int) queue.poll() : 0;

           windowSum = windowSum - tail + val;

           return windowSum * 1.0 / Math.min(size, count);
        }
    }
}
