package questions;

public class longestPalindromicSubstring {

    public longestPalindromicSubstring(){
        longestPalindrome("babad");
    }

    public String longestPalindrome(String s) {
        String result = "";

        for(int i = 0 ; i < s.length() ; i++){
            int l = i;
            int r = i;

            while(l >= 0 && r < s.length()){
                if(s.charAt(l) == s.charAt(r)){
                    String t = s.substring(l,r+1);
                    if(t.length() > result.length()){
                        result = t;
                    }
                    l--;
                    r++;
                }else{
                    break;
                }
            }

            l = i;
            r = i+1;

            while(l >= 0 && r < s.length()){
                if(s.charAt(l) == s.charAt(r)){
                    String t = s.substring(l,r+1);
                    if(t.length() > result.length()){
                        result = t;
                    }
                    l--;
                    r++;
                }else{
                    break;
                }
            }
        }

        return result;
    }
}
