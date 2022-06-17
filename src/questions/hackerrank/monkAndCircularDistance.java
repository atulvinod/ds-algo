package questions.hackerrank;

import java.util.PriorityQueue;
import java.util.*;
public class monkAndCircularDistance {
    public monkAndCircularDistance(){

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        double[] radius = new double[n];
        for(int i = 0 ; i < n ; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            double hr = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
            radius[i] = hr;
        }
        Arrays.sort(radius);
        int q = scan.nextInt();
        while(q-- > 0){
            long r = scan.nextLong();
            System.out.println(solve(radius,r));
        }
    }

    public int solve(double[] radius, long r){
     int start  = 0;
     int end = radius.length -1;
     while(start <= end){
         int mid = (start + end) /2;
         if((long)radius[mid] >= r){
             start = mid+1;
         }else{
             end = mid-1;
         }
     }

     return start;
    }


}

