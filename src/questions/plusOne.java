package questions;
import java.util.*;

public class plusOne {

    public plusOne(){
        solve(new int[]{1,2,3});
    }

    public int[] solve(int[] digits) {
        int[] result = new int[digits.length+1];
        int carry = 1;
        for(int i = digits.length-1; i >= 0 ; i--){
            int r = digits[i]+carry;
            carry = r/10;
            result[i+1] = r%10;
        }

        result[0] = carry;
        if(result[0] == 0){
            result = Arrays.copyOfRange(result, 1, result.length);
        }

        return result;
    }
}
