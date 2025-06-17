/*
 * Implement a method in Java named findKthSmallest. This method takes two parameters
 * as input: an array of integers nums and integer k. The array nums can have both 
 * positive and negative integers and can be of any size. The integer k is guaranteed
 * to be in the range of 1 to the length of the array inclusive.
 * 
 * Find the kth smallest element in the array nums. In other words, if the elements of 
 * the array were sorted in ascending order. the elements at the kth postion
 * (1-indexed) is the output
 */

import java.util.ArrayList;

import java.util.List;

public class FindKthSmallest {
    public static int findKthSmallest(int[] nums, int k) {
        Heap maxHeap = new Heap();

        for (int num : nums) {
            maxHeap.insert(num);

            if (maxHeap.getHeap().size() > k) {
                maxHeap.remove();
            }
        }

        return maxHeap.remove();
    }

    /*
     * Implement a function name stream max that processes a stream of integers and
     * returns the max number encountered so far for each input number.
     * This function should take in an array of integers and return a list of
     * integers given an array of integers, your function should iterate over the
     * array and for each number it should find the max number that number.
     */

    public static List<Integer> streamMax(int[] nums) {
        Heap maxHeap = new Heap();
        List<Integer> maxStream = new ArrayList<>();

        for (int num : nums) {
            maxHeap.insert(num);
            maxStream.add(maxHeap.getHeap().get(0));
        }
    
        return maxStream;
     }
}