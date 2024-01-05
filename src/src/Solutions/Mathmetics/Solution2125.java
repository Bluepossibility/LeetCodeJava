package Solutions.Mathmetics;

public class Solution2125 {
    public int numberOfBeams(String[] bank) {
        int ans = 0;
        int prev = numberOfOnes(bank[0]);
        for (int i = 1; i < bank.length; i++) {
            if (prev == 0){
                prev = numberOfOnes(bank[i]);
            }
            else if (numberOfOnes(bank[i]) != 0){
                ans += prev * numberOfOnes(bank[i]);
                prev = numberOfOnes(bank[i]);
            }
        }
        return ans;
    }

    private int numberOfOnes(String s){
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1'){
                cnt += 1;
            }
        }
        return cnt;
    }
}
