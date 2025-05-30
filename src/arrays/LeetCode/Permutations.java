/* You are given two integer arrays. Write a program to check 
 * if they are permutations of each other.
 */

public class Permutations {
    public boolean permutations(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }

        int sum1 = 0;
        int sum2 = 0;
        int mul1 = 0;
        int mul2 = 0;

        for (int i = 0; i < array1.length; i++) {
            sum1 += array1[i];
            sum2 += array2[i];
            mul1 *= array1[i];
            mul2 *= array2[i];
        }

        if (sum1 == sum2 && mul1 == mul2) {
            return true;
        }

        return false;
    }

    public static void runTest(String testName, boolean expected, boolean actual) {
        if (expected == actual) {
            System.out.println("The following test passed: " + testName);
        } else {
            System.out.println("The following test has failed: " + testName);
        }
    }

    public static void main(String[] args) {
        Permutations tester = new Permutations();
        System.out.println("--- Testing permutatiuns method ---");

        // Test 1:
        int[] empty1 = {};
        int[] empty2 = {};
        runTest("Empty arrays", true, tester.permutations(empty1, empty2));

        int[] single1 = { 5 };
        int[] single2 = { 5 };
        runTest("Single element arrays (same)", true, tester.permutations(single1, single2));

        int[] single3 = { 5 };
        int[] single4 = { 3 };
        runTest("Single element arrays (different)", false, tester.permutations(single3, single4));

        int[] diff1 = { 1, 2, 3 };
        int[] diff2 = { 1, 2 };
        runTest("Different lengths", false, tester.permutations(diff1, diff2));

        int[] perm1 = { 1, 2, 3 };
        int[] perm2 = { 3, 1, 2 };
        runTest("Simple permutation", true, tester.permutations(perm1, perm2));

        int[] perm3 = { 1, 2, 2, 3 };
        int[] perm4 = { 2, 3, 1, 2 };
        runTest("Permutation with duplicates", true, tester.permutations(perm3, perm4));

        int[] same1 = { 5, 5, 5 };
        int[] same2 = { 5, 5, 5 };
        runTest("All same elements", true, tester.permutations(same1, same2));

        int[] zero1 = { 0, 1, 2 };
        int[] zero2 = { 1, 0, 2 };
        runTest("Permutations with zeros", true, tester.permutations(zero1, zero2));

        int[] zero3 = { 0, 3 };
        int[] zero4 = { 1, 2 };
        runTest("Different arrays with zeros", false, tester.permutations(zero3, zero4));

        int[] neg1 = { -1, 2, 3 };
        int[] neg2 = { 3, -1, 2 };
        runTest("Permutations with negatives", true, tester.permutations(neg1, neg2));

        int[] neg3 = { -1, -2, 6 };
        int[] neg4 = { 1, 2, 0 };
        runTest("Different arrays with negatives", false, tester.permutations(neg3, neg4));

        int[] large1 = { 1000, 2000, 3000 };
        int[] large2 = { 3000, 1000, 2000 };
        runTest("Large number permutations", true, tester.permutations(large1, large2));

        int[] nonPerm1 = { 1, 2, 4 };
        int[] nonPerm2 = { 1, 3, 3 };
        runTest("Same sum, different elements", false, tester.permutations(nonPerm1, nonPerm2));

        int[] nonPerm3 = { 1, 5 };
        int[] nonPerm4 = { 2, 4 };
        runTest("Same sum, different products", false, tester.permutations(nonPerm3, nonPerm4));
    }
}
