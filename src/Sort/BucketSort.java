import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    int array[];

    public BucketSort(int array[]) {
        this.array = array;
    }

    public void printArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
        }
    }

    public void printBuckets(ArrayList<Integer>[] buckets) {
        for (int i = 0; i < buckets.length; i++) {
            System.out.println("\nBucket number: " + i + " : ");

            for (int j = 0; j < buckets[i].size(); j++) {
                System.out.println(buckets[i].get(j) + " ");
            }
        }
    }

    public void bucketSort() {
        int numberOfBuckets = (int) Math.ceil(Math.sqrt(array.length));
        int maxValue = Integer.MIN_VALUE;
        for (int value : array) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        for (int value : array) {
            int bucketNumber = (int) Math.ceil(((float) value * numberOfBuckets) / (float) maxValue);
            buckets[bucketNumber - 1].add(value);
        }

        System.out.println("\n\nPrinting buckets before sorting: ");
        printBuckets(buckets);

        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        System.out.println("\n Printing buckets after sorting: ");
        printBuckets(buckets);

        int index = 0;

        for (ArrayList<Integer> bucket : buckets) {
            for (int value : bucket) {
                array[index] = value;
                index++;
            }
        }
    }
}
