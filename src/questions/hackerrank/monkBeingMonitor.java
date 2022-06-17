package questions.hackerrank;
import java.util.*;

public class monkBeingMonitor {

    public monkBeingMonitor(){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t-- > 0){
            int n = scan.nextInt();
            int[] h = new int[n];
            for(int i = 0 ; i < h.length ; i++){
                h[i] = scan.nextInt();
            }
            System.out.println(solve(h));
        }
    }

    public int solve(int[] heights){
        if(heights.length == 1) return heights[0];
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int h : heights){
            map.put(h, map.getOrDefault(h,0)+1);
        }
        int max = Integer.MIN_VALUE;
        Map.Entry<Integer, Integer> last = map.lastEntry();
        Map.Entry<Integer, Integer> first = map.firstEntry();

        while(!map.isEmpty()){


            if(map.size() == 3) {
                Map.Entry<Integer, Integer>  middle =  map.lastEntry();
                int m = Math.max(middle.getValue() - first.getValue(), last.getValue() - middle.getValue());
                m = Math.max(last.getValue() - first.getValue(), m);
                max = Math.max(m, max);
                break;
            };


            map.remove(last.getKey());
            map.remove(first.getKey());
        }
        max = Math.max(last.getValue() - first.getValue(), max);
        return max > 0 ? max : -1;
    }
}
