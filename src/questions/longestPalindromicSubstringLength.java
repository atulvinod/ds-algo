package questions;

public class longestPalindromicSubstringLength {

    /**
     * The approach that we will follow is that we will expand to left and right from each character and check if the left and
     * right are equal, if they are, then its a palindrome else its not, and we will check it for even and odd length palindromes
     * */

    public int solve(String s){

        int longest = Integer.MIN_VALUE;

        for(int i = 0 ; i < s.length() ; i++){
            int left = i;
            int right = i;

            //expand to left and right from the iTh character
            //for cases like : racecar;
            while( left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                longest = Math.max(right-left+1, longest);
                left--;
                right++;
            }

            //for cases like : abbaa
            left = i;
            right = i+1;
            while( left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                longest = Math.max(right-left+1, longest);
                left--;
                right++;
            }
        }


        return longest;
    }
}
