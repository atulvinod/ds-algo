package questions;

import java.util.HashMap;

public class countAndSay {
    public static String countAndSay(int n){
        if(n == 1){
            return "1";
        }

        String cns = countAndSay(n-1);
        char currentChar = cns.charAt(0);
        int charCount = 0;
        String res = "";
        for(int i = 0 ; i < cns.length() ; i++){
            if(cns.charAt(i) != currentChar){
                res +=  charCount+String.valueOf(currentChar) ;
                currentChar = cns.charAt(i);
                charCount = 1;

            }else{
                charCount ++;
            }
        }
        res +=  charCount+ String.valueOf(currentChar) ;

        return res;
    }
}
