public class Main{

    public int calculateWays(int n){
        //for odd points , a combination is not possible
        if(n == 0 || n == 1 || n % 2 != 0) return 0;

        int[] ways = new int[n+1];
        ways[0] = 0;
        ways[1] = 0;

        for(int i = 2 ; i < n+1 ; i+=2){
            //After 6, we can take a pair of points
            //~ n(6) = n(4) + pair of points({12,36,54},{23,14,65},{54,63,12}) = 5
            ways[i] = ways[(i-2)] + ( i >= 6 ?  i / 2 : 1);
        }

        return ways[n];
    }

    public static void main(String[] args){
        Main m = new Main();
        System.out.println(m.calculateWays(6));
    }
}
