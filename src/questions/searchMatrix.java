package questions;

import java.util.Arrays;

public class searchMatrix {

    public static boolean searchMatrix(int[][] matrix, int target){
    int mainStart = 0;
    int mainEnd  = matrix.length - 1;
    int mainMid = 0;

    while(mainStart <= mainEnd && mainStart >= 0 && mainEnd < matrix.length){
        mainMid = (mainStart + mainEnd) /2;
        if(target >= matrix[mainMid][0] && target <= matrix[mainMid][matrix[0].length-1]){
            break;
        }
        if(target < matrix[mainMid][0]){
            mainEnd = mainMid -1;
        }
        if(target > matrix[mainMid][matrix[0].length-1]){
            mainStart = mainMid +1;
        }
    }

    int start = 0;
    int end = matrix[0].length - 1;
    int mid = 0;
    int[] res = matrix[mainMid];
    while(start <= end && start >= 0 && end < matrix[0].length){
        mid = (start + end )/2;
        if(res[mid] ==target){
            return true;
        }
        if(target > res[mid]){
            start = mid +1;
        }
        if(target < res[mid]){
            end = mid - 1;
        }
    }
    return false;
    }

}
