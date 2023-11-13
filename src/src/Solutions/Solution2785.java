package Solutions;

public class Solution2785 {

    boolean isVowel(Character c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public String sortVowels(String s) {
        int[] count = new int[1000];

        // Store the frequencies for each character.
        for (char c : s.toCharArray()){
            if (isVowel(c)){
                count[c - 'A']++;
            }
        }

        // Sorted string having all the vowels.
        String sortedVowel = "AEIOUaeiou";
        StringBuilder ans = new StringBuilder();
        int j = 0;
        for (int i = 0; i < s.length(); i++){
            if (!isVowel(s.charAt(i))){
                ans.append(s.charAt(i));
            }
            else{
                // Skip to teh character which is having remaining count.
                while (count[sortedVowel.charAt(j) - 'A'] == 0){
                    j++;
                }

                ans.append(sortedVowel.charAt(j));
                count[sortedVowel.charAt(j) - 'A']--;
            }
        }
        return ans.toString();
    }
}

