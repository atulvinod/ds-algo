package questions;

import java.util.HashMap;

public class interleavingString {

    public interleavingString(){
       boolean x =  isInterleave("ab","bc","babc");
        System.out.println(x);
    }

    HashMap<String, Boolean> map = new HashMap<>();

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.isEmpty()) return true;
        if(s1.length() + s2.length() != s3.length()) return false;

        return dp(s1,s2,s3,0,0);
    }

    public boolean dp(String s1, String s2, String s3, int i, int j){
        //if we reach the end of both the strings, then
        //we can say that we have completed the construction of the required string
        if(i >= s1.length() && j >= s2.length()){
            return true;
        }

        if(map.containsKey(i+","+j)) return map.get(i+","+j);
        // i+j = index in the main s3 string
        //if ith index is in the bound , the character matches with the character in s3, and the rest of the string also matches
        if(i < s1.length() && s1.charAt(i) == s3.charAt(i+j) && dp(s1,s2,s3,i+1,j)){
            return true;
        }

        //similarly this
        if(j < s2.length() && s2.charAt(j) == s3.charAt(i+j) && dp(s1,s2,s3,i,j+1)){
            return true;
        }

        map.put(i+","+j,false);
        return false;
    }
}
