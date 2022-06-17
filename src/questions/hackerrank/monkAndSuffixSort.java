package questions.hackerrank;
import java.util.*;

public class monkAndSuffixSort {

    public monkAndSuffixSort(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int r = scanner.nextInt();

        System.out.println(solve(s,r));
    }

    public String solve(String s, int r){
        if(s.length() == 1) return s;

        LinkedList<String> suffix = new LinkedList<>();
        suffix.add(s);
        while(s.length() != 1){
            suffix.add(s.substring(1));
            s = s.substring(1);
        }

        Collections.sort(suffix);
        return suffix.get(r-1);
    }
}
