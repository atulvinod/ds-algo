package questions;

public class hammingWeight {
    public hammingWeight(int n) {
        String z = ""+n;
        int o = 0;
        for(int i = 0 ; i < z.length();i++){
            o += (z.charAt(i) == '1' ? 1 : 0);
        }
        System.out.println(o);
    }
}
