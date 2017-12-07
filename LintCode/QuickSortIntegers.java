public class QuickSortIntegers {
    /*
     * @param A: an integer array
     * @return: 
     */
    public void sortIntegers(int[] A) {
        // write your code here
        if (A == null || A.length == 0)
            return;
        quickSort(A, 0, A.length - 1);
    }
    
    private void quickSort(int[] A, int start, int end) {
        if (start >= end)
            return;
        int left = start, right = end;
        // 1. get pivot value instead of index
        int pivot = A[(left + right) / 2];
        // left <= right, not left < right
        while (left <= right) {
            // A[left] < pivot not <=
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(A, start, right);
        quickSort(A, left, end);
    }
}

/*
Given an integer array, sort it in ascending order. Use selection sort, bubble sort, insertion sort or any O(n2) algorithm.
Example: given [3, 2, 1, 4, 5], return [1, 2, 3, 4, 5].
*/
public class Solution2 {
    /*
     * @param A: an integer array
     * @return: 
     */
    public void sortIntegers(int[] A) {
        // write your code here
        if (A == null || A.length == 0)
            return;
        quickSort(A, 0, A.length - 1);
    }
    
    private void quickSort(int[] A, int start, int end) {
        System.out.println(A);
        if (start >= end)
            return;
        int left = start, right = end;
        int pivot = A[(left + right) / 2];
        while (left <= right) {
            while (A[left] < pivot) {
                left++;
            }
            while (A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(A, start, right);
        quickSort(A, left, end);
    }
}