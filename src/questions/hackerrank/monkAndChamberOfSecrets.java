package questions.hackerrank;

import java.util.LinkedList;
import java.util.Queue;

public class monkAndChamberOfSecrets {

    public monkAndChamberOfSecrets(){
        solve(new long[]{1,2,2,3,4,5}, 5);
    }

    public void solve(long[] values, int x){
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> temp = new LinkedList<>();
        for(int i = 0 ; i < values.length ; i++ ){
            queue.add(i);
        }

        for(int i = 0; i < x ; i++){
            int z = 0;
            int maxIndex = -1;
            long maxVal = Long.MIN_VALUE;
            while(z++ < x && !queue.isEmpty()){
                int idx = queue.poll();
                temp.add(idx);
                if(values[idx] > maxVal){
                    maxIndex = idx;
                    maxVal = values[idx];
                }
            }

            System.out.print((maxIndex+1)+" ");
            while(!temp.isEmpty()){
                int it = temp.poll();
                if(it == maxIndex)
                    continue;

                values[it] = Math.max(--values[it],0);
                queue.add(it);
            }
        }

    }

}
