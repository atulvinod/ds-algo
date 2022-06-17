package questions;

public class countBinarySubstrings {
    //TWO POINTER SOLUTION
    public static int countBinarySubstrings(String s){
        int substrings = 0;

        for(int i = 0 ; i < s.length() -1 ; i++){
            int L = i;
            int R = i+1;
            //if L is 0 and R is 1, dir = 0;
            //if R is 0 and L is 1, dir = 1;
            int dir = 0;
            if(s.charAt(L) == '0' && s.charAt(R) == '1'){
                dir = 0;
                substrings++;
            }else if (s.charAt(L) =='1' && s.charAt(R)=='0'){
                dir = 1;
                substrings++;
            }else{
                continue;
            }

            L--;
            R++;

            while( L >= 0 && R < s.length()){
                if(dir == 0 && s.charAt(L) == '0' && s.charAt(R) == '1'){
                    substrings++;
                }else if(dir == 1 && s.charAt(L) =='1' && s.charAt(R)=='0'){
                    substrings++;
                }else{
                    break;
                }
                L--;
                R++;
            }

        }

        return substrings;
    }
}
