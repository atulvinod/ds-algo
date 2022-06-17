package algorithms;

import java.util.Arrays;

public class binarySearch {
    public static int binarySearch(int toFind, int[] arr, int start, int end){
        Arrays.sort(arr);
        int foundAt = -1;
        while(start <= end && start < arr.length && end >=0){
            int mid = (start+end)/2;
            if(arr[mid] == toFind) {
                foundAt = mid;
                break;
            }
            if(toFind > arr[mid]){
                start = mid +1 ;
            }
            if(toFind < arr[mid]){
                end = mid - 1;
            }
        }

        return foundAt;
    }
}
