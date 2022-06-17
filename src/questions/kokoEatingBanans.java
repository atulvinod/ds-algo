package questions;

import java.util.Arrays;

public class kokoEatingBanans {

    public kokoEatingBanans(){
        minEatingSpeed(new int[]{30,23,4,11,20},5);
    }

    public int minEatingSpeed(int[] piles, int h) {
        int high = 1;
        int low = 1;
        for(int i :piles){
            high = Math.max(high,i);
        }

        while(low <  high){
            int mid = (high+low)/2;
            if(checkRate(piles, mid, h)){

                high = mid;
            }else{
                low = mid+1;
            }
        }

        return high;
    }

    public boolean checkRate(int[] piles , int k, int h){
        int  totalTime = 0;

        for(int i : piles){
            totalTime += Math.ceil((double)i/k);
        }

        return totalTime <= h;
    }
}
