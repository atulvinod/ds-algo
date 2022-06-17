package questions;
import java.util.*;

public class cheapestFlightsWithKStops {
    /**
     * We use the bellman ford algorithm to solve this problem
     * */
    public cheapestFlightsWithKStops(){
        findCheapestPrice(4, new int[][]{{0, 1, 100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}},0,3,1);
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0 ;
        for(int i = 0 ; i < k+1 ;i++){
            int[] tempPrices = Arrays.copyOf(prices,prices.length);
            for(int[] e : flights){
                if(prices[e[0]] == Integer.MAX_VALUE) continue;
                if(prices[e[0]]+e[2] < tempPrices[e[1]]){
                    tempPrices[e[1]] = prices[e[0]] + e[2];
                }
            }
            prices = Arrays.copyOf(tempPrices, tempPrices.length);
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
