package questions;
import java.util.*;

public class lengthOfLongestSubstringWithoutRepeating {
    /**
     * We use a sliding window approach, we take two pointers, start and end
     * and a frequency map for each character's frequency
     *
     * */

    public int lengthOfLongestSubstring(String s) {
        if(s.equals(" ")){
            return 1;
        }
        if(s.length()==0){
            return 0;
        }
        if(s.trim().length()==0 && s.length()!=0){
            return 1;
        }
        if(s.length()==1){
            return 1;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        int end = 0;
        int length = Integer.MIN_VALUE;
        while(start <= end && end < s.length()){
            int f = map.getOrDefault(s.charAt(end),0);
            //increment end and increase the character's frequency , until we reach a character
            //whose frequency is already 1
            if(f == 0){
                map.put(s.charAt(end),f+1);
                length = Math.max(length, end - start +1);
                end++;

            }else{

                //Since we have reached a character whose freq is already one, we will
                //increase start and decrease the freqeuncy of start character until the
                //freq of end character is again 1.
                while(start < end && map.getOrDefault(s.charAt(end),0) == 1){
                    map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                    start++;
                }
            }
        }

        return length;
    }
}
