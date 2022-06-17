package algorithms;

public class unionOfTwoArrays {
    public static void unionArray (int[] A, int [] B){
        int k = 0;
        int l  = 0 ;
        while( k < A.length){
            if(A[k] < B[l]){
                System.out.println(A[k]);
                k++;
            }else if(B[l] < A[k]){
                System.out.println(B[l]);
                l++;
            }else{
                System.out.println(B[l]);
                k++;
                l++;
            }
        }
        while(l < B.length){
            System.out.println(B[l++]);
        }
    }

}
