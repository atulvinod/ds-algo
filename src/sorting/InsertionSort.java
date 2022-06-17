package sorting;

import java.util.List;

public class InsertionSort {
    public List<Integer> insertionSort(List<Integer> values){
        if(values.size() == 1){
            return values;
        }
        int sortedArrayIndex = 0;
        int unSortedArrayIndex = 1;
        while(unSortedArrayIndex < values.size()){
            int i = unSortedArrayIndex;
            int j = sortedArrayIndex;
            while(j > -1 && values.get(i) < values.get(j)){
                int temp = values.get(j);
                values.set(j, values.get(i));
                values.set(i, temp);
                i--;
                j--;
            }
            sortedArrayIndex++;
            unSortedArrayIndex++;
        }
        return values;
    }

}
