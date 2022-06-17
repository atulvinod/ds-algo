package questions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class partitionLabels {
    //https://leetcode.com/problems/partition-labels/

    public partitionLabels(){
//       List<Integer> result = partitionLabels("ababcbacadefegdehijhklij");
        List<Integer> result = partitionLabels("eccbbbbdec");
        System.out.println(result);
    }


    public List<Integer> partitionLabels(String s) {       if(s.length() == 1) return new LinkedList<Integer>(List.of(1));

        List<Integer> result = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        int windowStart = 0;
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> windowChars = new HashMap<>();

        for(int i = 0; i < chars.length ; i++ ){
            char c = chars[i];
            map.put(c, map.get(c)-1);
            windowChars.put(c, windowChars.getOrDefault(c,0)+1);

            //if any character in the window has completed, ie has 0 in the character map, then we check
            //if all the characters in the current window is completed, if completed then we add the length
            //of the currrent window
            if(map.get(c) == 0){
                boolean windowCompleted = true;
                for(Map.Entry<Character, Integer> m : windowChars.entrySet()){
                    if(map.get(m.getKey()) != 0){
                        windowCompleted = false;
                        break;
                    }
                }
                if(windowCompleted){
                    result.add(i - windowStart +1);
                    windowChars.clear();
                    windowStart = i+1;
                }
            }
        }
        int lastWindow = s.length() - windowStart;
        if(lastWindow > 0 ){
            result.add(lastWindow);
        }
        return result;

    }
}
