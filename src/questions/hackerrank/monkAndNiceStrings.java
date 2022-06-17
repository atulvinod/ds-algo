package questions.hackerrank;
import java.util.*;

public class monkAndNiceStrings {

    public monkAndNiceStrings(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String[] ch = new String[n];
        String[] sorted = new String[n];
        for(int i = 0 ; i < n ; i++){
            ch[i] = scan.next();
            sorted[i] = ch[i];
        }
        solve(ch, sorted);
    }

    public void solve(String[] chars,  String[] sorted){
        int[] result = new int[chars.length];
        for(int i = 0 ; i < chars.length ; i++){
            int count = 0;
            for(int k = 0 ; k < i ; k++){
                if(chars[k].compareTo(chars[i]) < 0) count++;
            }
            result[i] = count;
        }

        for (int i : result){
            System.out.println(i);
        }
    }
}
