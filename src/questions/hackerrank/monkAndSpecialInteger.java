package questions.hackerrank;
import java.util.*;
public class monkAndSpecialInteger {

    public monkAndSpecialInteger(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int values[] = new int[n];
        double x = scan.nextDouble();
        for(int i = 0 ; i < n; i++){
            values[i]= scan.nextInt();
        }
        System.out.println(solve(values, x));
    }

    public double solve(int[] values, double x){
       double[] subsum = new double[values.length+1];
        boolean isAnyElementGreaterThanX = false;
       for(int i = 1 ; i < subsum.length ; i++){
        subsum[i] = subsum[i-1]+values[i-1];
        if(values[i-1] > x){
            isAnyElementGreaterThanX = true;
        }
       }

       if(isAnyElementGreaterThanX) return -1;

       if(subsum[values.length] < x){
           return subsum[values.length];
       }

       int start = 1;
       int end = subsum.length - 1;
       int result = -1;
       while(start <= end){
           int mid = (start + end) / 2;
           boolean valid = true;
           for(int i = mid ; i < subsum.length ; i++){
               if(subsum[i]-subsum[i-mid] > x){
                   valid = false;
                   break;
               }
           }

           if(valid){
               result = mid;
               start = mid+1;
           }else{
               end = mid-1;
           }
       }

       return result;
    }
}
