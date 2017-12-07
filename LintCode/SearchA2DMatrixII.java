public class SearchA2DMatrixII {
     /*
     * Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.
     * This matrix has the following properties:

     * Integers in each row are sorted from left to right.
     * Integers in each column are sorted from up to bottom.
     * No duplicate integers in each row or column.
    
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int n = matrix.length;
        int m = matrix[0].length;
        int i = n - 1;
        int j = 0;
        int count = 0;
        while (i > -1 && j < m) {
            if (matrix[i][j] > target)
                --i;
            else if (matrix[i][j] < target)
                ++j;
            else {
                --i;
                ++j;
                ++count;
            }
        }
        return count;
    }
}