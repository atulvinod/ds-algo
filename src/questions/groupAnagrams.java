package questions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class groupAnagrams {

    public groupAnagrams(){
        solve(new String[]{"eat","tea","tan","ate","nat","bat"});
    }

    public List<List<String>> solve(String[] strs) {
        HashMap<String, LinkedList<String>> map = new HashMap<>();

        for(int i = 0 ; i < strs.length ; i++){
            int[] char_freq = new int[26];
            for(int z = 0 ; z < strs[i].length() ; z++){
                char_freq[strs[i].charAt(z) - 'a']++;
            }
            String code = "";
            for(int z = 0 ; z < char_freq.length ; z++){
                code = code+z+ char_freq[z]+"|";
            }

            LinkedList<String> stringLinkedList = map.getOrDefault(code, new LinkedList<>());
            stringLinkedList.add(strs[i]);
            map.put(code,stringLinkedList);
        }

        List<List<String>> res = new LinkedList<>();
        for(Map.Entry<String, LinkedList<String>> e : map.entrySet()){
            res.add(e.getValue());
        }

        return res;
    }
}
