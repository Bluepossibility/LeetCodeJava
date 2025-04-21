package Solutions.StringManipulation;

public class Solution1945 {
    public int getLucky(String s, int k) {
        int l = s.length();
        StringBuilder sb = new StringBuilder();
        for (Character c : s.toCharArray()){
            // convert s into an integer by replacing each letter with its position in the alphabet
            int alphaPosition = c - 'a' + 1;
            sb.append(alphaPosition);
        }
        String convertedString = sb.toString();

        int sum = 0;
        while (k > 0){
            sum = 0;
            // transform the integer by replacing it with the sum of its digits
            for (int i = 0; i < convertedString.length(); i++) {
                sum += Integer.parseInt(String.valueOf(convertedString.charAt(i)));
            }
            convertedString = "" + sum;
            k--;
        }
        return sum;
    }
}
