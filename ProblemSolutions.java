/******************************************************************
 *
 *   BRODY DARRAH / COMP 272, SECTION 002
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {

        // Return true if and only if B is a subset of A
        // First insert every element of A into a HashSet,
        // Then scan B and if any element isn't in the set, then not a subset.

        if (list2 == null || list2.length == 0){
            return true;
        }


        HashSet<Integer> found = new HashSet<>();
        if (list1 != null){
            for (int x : list1){
                found.add(x);
            }
        }

        // Check every element of B against set A
        for (int y : list2){
            if (!found.contains(y)) {
                return false;
            }
        }

        return true;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        // Create a min heap
        PriorityQueue<Integer> minK = new PriorityQueue<>();

        for (int val : array){
            minK.add(val);
            if (minK.size() > k){
                minK.poll(); // keep only the k largest seen so far
            }
        }
        // Root is now the k-th largest
        return minK.peek();
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {

        // Push all elements from both arrays into a min heap
        // Pop them back in order into a result array
        int len1 = 0;
        int len2 = 0;

        if (array1 != null){
            len1 = array1.length;
        }
        if (array2 != null){
            len2 = array2.length;
        }
        int total = len1 + len2; // How large the output needs to be

        // Create min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(total);

        // push all of array1 if it exists
        if (array1 != null){
            for (int x : array1){
                pq.add(x);
            }
        }
        // push all of array2
        if (array2 != null){
            for (int x : array2){
                pq.offer(x);
            }
        }

        // Drain the heap into new array (sorted)
        int[] out = new int[total];
        int i = 0;
        while (!pq.isEmpty()){
            out[i] = pq.poll(); // smallest left comes out first
            i++;
        }

        return out;
    }

}