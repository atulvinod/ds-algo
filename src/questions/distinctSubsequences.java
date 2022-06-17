package questions;

public class distinctSubsequences {

    public distinctSubsequences(){
        numDistinct("babgbag","bag");
    }

    int res = 0;
    public int numDistinct(String s, String t) {

        int result = dfs(0,"",s,t);
        return res;
    }


    public int dfs(int index,String prefix , String s, String t){
        if(index >= s.length() || prefix.length() > t.length()){
            return 0;
        }

        if(prefix.equals(t)){
            System.out.println("index "+index);
            res++;
        }

        return dfs(index+1,prefix+s.charAt(index),s,t )+dfs(index+1, prefix,s,t);
    }

}
