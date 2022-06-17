package questions.hackerrank;
import java.util.*;

public class monkAndSearch {

    public monkAndSearch(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] v = new int[n];
        for(int i = 0 ; i < n ; i++){
            v[i] = scan.nextInt();
        }
        Arrays.sort(v);
        int q = scan.nextInt();
        while(q-- > 0){
            int o = scan.nextInt();
            int x = scan.nextInt();
            System.out.println(solve(v, o, x));
        }
    }

    int solve(int[] values, int op, int x){
        x+= op;
        if(x > values[values.length-1]) return 0;
        if(x < values[0]) return values.length;

        int start = 0;
        int end = values.length -1;
        int index = -1;
        search:
        while(start < end && start < values.length && end >=0){
            int mid = (start+end)/2;
            if(values[mid] == x) {
                index = mid;
                break search;
            }else{
                if(x > mid){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }

        return values.length -index;

    }
}
