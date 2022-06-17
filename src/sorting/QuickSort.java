package sorting;

public class QuickSort {
    /*
      * Algorithm for quick sort
      * We choose a pivot element (can be any random element), all the elements on the left of the
      * pivot should be less and elements on the right should be greater than the pivot.
      * we choose two pointers , start and end
      *
      * Steps (quickSort)
      * > Move start pointer (++) until a value greater or equal to pivot is found
      * > Move end pointer (--) until a value less than the pivot is found
      * > If end pointer is greater than the start pointer, swap the start and end pointer elements, else swap end ptr element and pivot element
      * > call quickSort on left and right subarrays
     */

    public static int[] quickSort(int[] elements){
        elements = quickSort(elements, 0, elements.length -1);
        return elements;
    }

    private static int[] quickSort(int[] elements , int start, int end){
        if(start >= end){
            return elements;
        }
        int pivotIndex = start;
        int startPtr = start;
        int endPtr = end;
        while(startPtr < endPtr){
            while(elements[startPtr] <= elements[pivotIndex] && startPtr < elements.length-1){
                startPtr++;
            }
            while(elements[endPtr] > elements[pivotIndex] ){
                endPtr--;
            }
            if(startPtr < endPtr)
            swap(elements, startPtr, endPtr);
        }

        swap(elements, endPtr, pivotIndex);
        pivotIndex = endPtr;
        quickSort(elements, start, pivotIndex-1);
        quickSort(elements, pivotIndex+1, end);
        return elements;
    }

    private static void swap(int elements[], int x, int y){
        int temp = elements[x];
        elements[x]  = elements[y];
        elements[y] = temp;
    }
}
