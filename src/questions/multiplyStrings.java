package questions;

public class multiplyStrings {

    public multiplyStrings(){
        multiply("123","456");
    }

    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";

        int[][] grid = new int[num2.length()][num2.length()+num1.length()+1];

        for(int n2 = num2.length()-1; n2 >= 0 ; n2--){
            int ptr = grid[0].length - 1 - (num2.length() - n2 - 1);
            int c = 0;
            for(int n1 = num1.length() - 1 ; n1 >= 0 ;n1--){
                int mul = gv(num1.charAt(n1)) * gv(num2.charAt(n2)) + c;
                c = mul / 10;
                mul = mul % 10;
                grid[n2][ptr--] = mul;
            }
            if(c != 0){
                grid[n2][ptr] = c;
            }
        }

        int mainCarry = 0;
        String result = "";
        for(int i = grid[0].length -1 ; i >= 0 ; i-- ){
            int sum = 0;
            for(int j = 0 ; j < grid.length; j++){
                sum += grid[j][i];
            }
            int v = mainCarry + sum;
            mainCarry = v / 10;
            v = v % 10;
            result = v + result;
        }

        int i = 0;
        while(result.charAt(i) == '0') i++;

        result =  result.substring(i);
        return result;
    }

    public int gv(char c){
        int k = Integer.parseInt(""+c);
        return k;
    }
}
