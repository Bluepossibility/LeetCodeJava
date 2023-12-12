package Solutions.Mathmetics;

public class Solution1688 {
    public static int numberOfMatches(int n) {
        if (n == 1){
            return 1;
        }
        else if (n % 2 == 0){
            return numberOfMatches(n / 2 ) +  n / 2;
        }
        else {
             return numberOfMatches(n / 2 + 1) + n / 2;
        }
    }
}
