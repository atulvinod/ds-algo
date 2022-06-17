package questions;

public class longestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String res = "";
        if(strs.length == 1){
            return strs[0];
        }
        main:
        for(int i = 0; i < strs[0].length() ; i++){
            for(int j = 1 ; j < strs.length ; j++){
                if(i > strs[j].length()-1){
                    break main;
                }
                if(strs[j].charAt(i) != strs[0].charAt(i)){
                    break main;
                }
                if(j == strs.length - 1){
                    res += strs[0].charAt(i);
                }
            }
        }

        return res;
    }
}
