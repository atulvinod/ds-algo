package questions;


//Recursive method
public class minNumberOfFlips {
    public static int minFlips(String S) {
        return solve(S,0,0);
    }

    public static int solve(String s, int index, int currentFlips){
        if(index >= s.length()){
            return currentFlips;
        }
        //recurse with two conditions, once with initial index flipped and one without the flip
        StringBuilder sb = new StringBuilder(s);

        if(index == 0){
            int flippedValue = 0;
            int withoutFlip = 0;
            if(s.charAt(0)=='0'){
                sb.setCharAt(0,'1');
                flippedValue = solve(sb.toString(),index+1, 1);
            }else{
                sb.setCharAt(0,'0');
                flippedValue = solve(sb.toString(),index+1, 1);
            }

            withoutFlip = solve(s, index+1,0);
            return Math.min(flippedValue, withoutFlip);
        }else{
            if(s.charAt(index-1) == s.charAt(index)){
                if(s.charAt(index)=='1'){
                    sb.setCharAt(index,'0');
                    return solve(sb.toString(), index+1, currentFlips+1);
                }else{
                    sb.setCharAt(index,'1');

                    return solve(sb.toString(), index+1, currentFlips+1);

                }
            }else{
                return solve(s, index+1, currentFlips);
            }
        }
    }
}
