package sorting;

public class MergeSort {
    public int[] mergeSort(int[] values){
        return sort(values);
    }

    private int[] sort(int[] values){
        if(values.length == 1){
            return values;
        }
        int mid = (values.length -1) /2;
        int [] sortedL = sort(createSubArray(values, 0, mid));
        int [] sortedR = sort(createSubArray(values, mid +1 , values.length -1));

        return mergeArrays(sortedL, sortedR);
    }

    private int[] mergeArrays(int[] L, int[] R){
        int totalLength = L.length + R.length;
        int[] temp = new int[totalLength];
        int iL = 0;
        int iR = 0;
        int iTemp = 0;
        while(iL < L.length && iR < R.length){
            if(L[iL] < R[iR]){
                temp[iTemp++] = L[iL++];
            }else{
                temp[iTemp++] = R[iR++];
            }
        }
        while(iL < L.length){
            temp[iTemp++] = L[iL++];
        }
        while(iR < R.length){
            temp[iTemp++] = R[iR++];
        }
        return temp;
    }

    private int[] createSubArray(int[] values, int start, int end){
        int[] temp = new int[end - start +1 ];
        for(int i = start , j = 0; i <= end ; i++ , j++){
                temp[j] = values[i];
        }
        return temp;
    }
}
