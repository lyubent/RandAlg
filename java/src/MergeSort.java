// Based on https://algs4.cs.princeton.edu/14analysis/Mergesort.java.html
// From Princeton CS' Analysis of Algorithms (https://algs4.cs.princeton.edu/14analysis/)

import java.util.Arrays;

public class MergeSort {

    // l - left side of the array, from start to middle.
    // r - right side of the array, from middle to end.
    private static int[] merge(int[] l, int[] r) {
        int[] fullArr = new int[l.length + r.length];
        int a = 0;
        int b = 0;
        for (int i = 0; i < fullArr.length; i++) {
            // parse through two sub-arrays, assign them to
            // the full array.
            if (a >= l.length) { 
                fullArr[i] = r[b++];
            } else if (b >= r.length) {
                fullArr[i] = l[a++];
            } else if (l[a] <= r[b]) { 
                fullArr[i] = l[a++];
            } else {
                fullArr[i] = r[b++];
            }
        }
        return fullArr;
    }

    public static int[] sort(int[] input) {
        int arrSize = input.length;
        // Only 1 element. No sorting required.  
        if (arrSize <= 1)
            return input;

        // midpoint markers
        int[] a = new int[arrSize/2];
        int[] b = new int[arrSize - arrSize/2];

        // Split up full array into two sub-arrays (divide dataset), L and R
        // assign vals to both temp arrays.
        for (int i = 0; i < a.length; i++) 
            a[i] = input[i];
        for (int i = 0; i < b.length; i++)
            b[i] = input[i + arrSize/2];

        return merge(sort(a), sort(b));
    }

    public static void main(String[] args) {
        int[] ds = new int[]{23, 7, 111, 42, 7, 0, -2, 52};
        System.out.println("Input:  " + Arrays.toString(ds));
        int[] sortedDs = sort(ds);
        testSorted(sortedDs);
        System.out.println("Output: " + Arrays.toString(sortedDs));
    }

    private static void testSorted(int[] arr) {
        int prev = arr[0];
        for (Integer i : arr) {
            // previous can't be more. 
            if (prev <= i)
                prev = i;
            else
                throw new RuntimeException("not sorted.");
        }
        System.out.println("Sorted - ascending.");
    }
}