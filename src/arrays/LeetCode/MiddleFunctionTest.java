package arrays.LeetCode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MiddleFunctionTest {

    @Test
    public void testEmptyArray() {
        int[] input = {};
        int[] expected = {};
        int[] result = MiddleFunction.middle(input);
        assertArrayEquals(expected, result, "Empty array should return empty array");
    }

    @Test
    public void testSingleElement() {
        int[] input = { 5 };
        int[] expected = {};
        int[] result = MiddleFunction.middle(input);
        assertArrayEquals(expected, result, "Single element array should return an empty array");
    }

    @Test
    public void testTwoElements() {
        int[] input = { 1, 2 };
        int[] expected = {};
        int[] result = MiddleFunction.middle(input);
        assertArrayEquals(expected, result, "Two element array should return an empty array");
    }

    @Test
    public void testThreeElements() {
        int[] input = { 1, 2, 3 };
        int[] expected = { 2 };
        int[] result = MiddleFunction.middle(input);
        assertArrayEquals(expected, result, "Three element array should return middle element");
    }

    @Test
    public void testFourElements() {
        int[] input = { 1, 2, 3, 4 };
        int[] expected = { 2, 3 };
        int[] result = MiddleFunction.middle(input);
        assertArrayEquals(expected, result, "Four element array should return two middle elements");
    }

    @Test
    public void testFiveElements() {
        int[] input = { 10, 20, 30, 40, 50 };
        int[] expected = { 20, 30, 40 };
        int[] result = MiddleFunction.middle(input);
        assertArrayEquals(expected, result, "Five element array should return three middle elements");
    }

    @Test
    public void testLargerArray() {
        int[] input = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] expected = { 2, 3, 4, 5, 6, 7 };
        int[] result = MiddleFunction.middle(input);
        assertArrayEquals(expected, result, "Larger array should exclude first and last elements");
    }

    @Test
    public void testNegativeNumbers() {
        int[] input = { -5, -3, -1, 0, 1, 3, 5 };
        int[] expected = { -3, -1, 0, 1, 3 };
        int[] result = MiddleFunction.middle(input);
        assertArrayEquals(expected, result, "Should work correctly with negative numbers");
    }

    @Test
    public void testDuplicateNumbers() {
        int[] input = { 1, 1, 1, 1, 1 };
        int[] expected = { 1, 1, 1 };
        int[] result = MiddleFunction.middle(input);
        assertArrayEquals(expected, result, "Should work correctly with duplicate numbers");
    }

    @Test
    public void testNullArray() {
        int[] input = null;
        assertThrows(NullPointerException.class, () -> {
            MiddleFunction.middle(input);
        }, "Null input should throw NullPointerException");
    }

    @Test
    public void testResultArrayLength() {
        int[] input = { 1, 2, 3, 4, 5, 6 };
        int[] result = MiddleFunction.middle(input);
        assertEquals(input.length - 2, result.length, "Result array length should be input length minus 2");
    }

    @Test
    public void testOriginalArrayUnmodified() {
        int[] input = { 1, 2, 3, 4, 5 };
        int[] originalCopy = input.clone();
        MiddleFunction.middle(input);
        assertArrayEquals(originalCopy, input, "Original array should not be modified");
    }

}
