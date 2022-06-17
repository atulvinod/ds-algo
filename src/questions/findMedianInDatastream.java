package questions;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 * */
class MedianFinder {

    /**
     * We take two heaps, left and right, left is maxheap and right is minheap
     * the elements in the left heap is less than the element in right heap
     * */
    PriorityQueue<Integer> left =  new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> right = new PriorityQueue<>();

    public MedianFinder() {

    }

    public void addNum(int num) {
        left.add(num);
        if(left.size() > 0 && right.size() > 0 && left.peek() > right.peek()){
            right.add(left.poll());
        }
        if(left.size() > right.size() + 1){
            right.add(left.poll());
        }else if(right.size() > left.size() + 1){
            left.add(right.poll());
        }

    }

    public double findMedian() {
        if(left.size() ==  right.size() ){
            return (left.peek() + right.peek()) /2.0;
        }
        return left.size() > right.size() ? left.peek() : right.peek();
    }
}


public class findMedianInDatastream {
}
