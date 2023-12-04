package Solutions;

public class Solution2264 {
    public String largestGoodInteger(String num) {
        String ans = "";
        for (int i = 3; i <= num.length(); i++) {
            String subString = num.substring(i - 3, i);
            if (subString.charAt(0) == subString.charAt(1) && subString.charAt(0) == subString.charAt(2)){
                if (ans.isEmpty()){
                    ans = subString;
                }
                else{
                    if (Integer.parseInt(String.valueOf(ans.charAt(0))) < Integer.parseInt(String.valueOf(subString.charAt(0)))){
                        ans = subString;
                    }
                }
            }
        }

        return ans;
    }
}
