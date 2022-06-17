package questions;

import java.util.*;

import static java.util.stream.Collectors.toCollection;

public class secondMostRepeatedString {
    public static String secFrequent(String arr[], int N)
    {
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0 ; i < arr.length ; i++){
            int freq = map.getOrDefault(arr[i],0);
            map.put(arr[i], freq+1);
        }

         String secHighestFreqString = "";
         String highestFreqString = "";
        int highestFreq = Integer.MIN_VALUE;
        int secHighFreq = Integer.MIN_VALUE;

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        List<Map.Entry<String, Integer>> entries1 = entries.stream().collect(toCollection(ArrayList::new));;
        Collections.sort(entries1,(a,b)->a.getValue() - b.getValue());
        return secHighestFreqString;
    }
}
