package questions.hackerrank;
import java.util.*;

public class monkAndSortingAlgorithm {

    public monkAndSortingAlgorithm(){
        solve(new LinkedList<>(List.of("40", ",74" ,"35", "7" ,"99" ,"64" ,"57" ,"51" ,"63" ,"68")));
    }

    public void solve(List<String> values){
        TreeMap<String, List<String>> sortOrder = new TreeMap<>();
        int zeroCount = 0;
        int i = 1;
        while(zeroCount != values.size()){
            zeroCount = 0;
            sortOrder.clear();
            for (String v : values){
                int end = v.length() - 1 - ((1+(5*(i-1))) -1);
                int start = v.length() - 1 - ((5*i) - 1);
                if(start < 0 && end < 0){
                    List<String> strings = sortOrder.getOrDefault("0", new LinkedList<>());
                    strings.add(v);
                    sortOrder.put("0", strings);
                    zeroCount++;
                }else{
                    String key = v.substring(start < 0 ? 0 : start,end+1);
                    List<String> strings = sortOrder.getOrDefault(key, new LinkedList<>());
                    strings.add(v);
                    sortOrder.put(key, strings);
                }
            }
            if(values.size() == zeroCount) break;
            values.clear();

            for(Map.Entry<String,List<String>> m : sortOrder.entrySet()){
                for(String v : m.getValue()){
                    System.out.print(v+" ");
                    values.add(v);
                }
            }
            i++;
            System.out.println();
        }

    }

}
