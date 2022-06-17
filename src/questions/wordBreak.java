package questions;
import java.util.*;

public class wordBreak {
    HashSet<String> visited = new HashSet<>();

    public boolean wordBreak(String A, ArrayList<String> B )
    {
        return solve(A, B,"");
    }

    public boolean solve(String A, ArrayList<String> B, String prefix){
        if(visited.contains(prefix)){
            return false;
        }

        if(prefix.equals(A)){
            return true;
        }
        if(prefix.length() >= A.length()){
            return false;
        }
        if(!prefix.isBlank() && !A.contains(prefix)){
            return false;
        }

        for(int i = 0 ; i < B.size() ; i++) {
            if (solve(A, B, prefix + B.get(i)) ) {
                return true;
            }else{
                visited.add(prefix+B.get(i));
            }
        }
        return false;
    }
}
