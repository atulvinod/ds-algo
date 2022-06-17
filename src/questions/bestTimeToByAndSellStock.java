package questions;

import java.util.Stack;

public class bestTimeToByAndSellStock {
    public bestTimeToByAndSellStock(){
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public int maxProfit(int[] prices) {
        int maxProf = 0;

        if(prices.length == 1){
            return maxProf;
        }
        int left = 0;
        int right = 1;

        while(right < prices.length){
            if(prices[left] > prices[right]){
                left = left +1;
                right = left+1;
            }else{
                maxProf = Math.max(prices[right]-prices[left], maxProf);
                right++;
            }

        }
        return maxProf;
    }
}
