package questions;
import java.util.*;
import java.util.stream.Collectors;

public class kthLargestInStream {

    LinkedList<Integer> q;
    int k;

    public kthLargestInStream(int k, int[] nums) {
        this.k = k;
        q = new LinkedList<Integer>();

        for(int i : nums){
            q.add(i);
        }

        //remove all the extra elements , as we only need k size
        while(q.size() > k){
            q.poll();
        }
      double d = 1.0d;
    }

    public int add(int val) {
        q.add(val);
        if(q.size() > k)
            q.poll();

        return q.peek();
    }
}
