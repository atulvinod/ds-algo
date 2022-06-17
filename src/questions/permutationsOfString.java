package questions;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class permutationsOfString {
    public static List<String> find_permutation(String S) {
       List<String> x =  Arrays.asList(S.split(""));
       Collections.sort(x);
       return perm(x.stream().reduce("",(acc,elem)->acc+elem));
    }

    public static List<String> perm(String availableCharacters){
        if(availableCharacters.length() == 1){
            return Arrays.asList(availableCharacters);
        }
        List<String> perms = new LinkedList<>();
        for(int i = 0 ; i < availableCharacters.length() ; i++){
            char currentChar = availableCharacters.charAt(i);
            String nextAvailableString = new StringBuilder(availableCharacters).deleteCharAt(i).toString();
            List<String> nextPerms = perm(nextAvailableString);
            nextPerms.forEach((e)->{
                perms.add(currentChar+e);
            });
        }
        return perms;
    }
}