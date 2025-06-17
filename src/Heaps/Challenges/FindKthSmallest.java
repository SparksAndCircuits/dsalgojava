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
}