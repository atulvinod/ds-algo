package questions;

public class yogeshAndPrimes {
    public int yogeshP(int a, int b, int k){
        int primes[] = new int[b+1];
        primes[0] = 1;
        primes[1] = 0;

        for(int i = 2; i < primes.length ; i++){
            if(primes[i] == 0){
                int multiplier = 2;
                int curindex = i * multiplier;
                while (curindex < primes.length) {
                    primes[curindex] = 1;
                    curindex = i * (multiplier++);
                }
            }
        }

        int start = a;
        int end = b;
        int p = Integer.MAX_VALUE;
        while(start <= end){
            int mid = (start+end)/2;
            if(countPrimes(primes,start, mid) >= k){
                p = Math.min(p,mid);
                end = mid - 1;
            }else{
                start = mid+1;
            }
        }

        return p == Integer.MAX_VALUE ? -1 : p;
    }

    public int countPrimes(int[] primes, int start, int end){
        int count = 0;

        while(start <= end){
            if(primes[start] == 0) count++;
            start++;
        }

        return count;
    }
}
