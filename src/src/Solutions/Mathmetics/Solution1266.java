package Solutions.Mathmetics;

public class Solution1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i = 1; i < points.length; i++){
            int horizontalDist = Math.abs(points[i][0] - points[i - 1][0]);
            int verticalDist = Math.abs(points[i][1] - points[i - 1][1]);
            ans += Math.min(horizontalDist, verticalDist) + Math.abs(verticalDist - horizontalDist);
        }
        return ans;
    }
}
