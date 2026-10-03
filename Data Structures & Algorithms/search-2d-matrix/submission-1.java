class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int l = 0;
        int r = m - 1;

        int min = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[mid][0] < target) {
                min = mid;
                l = mid + 1;
            } else if (matrix[mid][0] > target) {
                r = mid - 1;
            } else {
                return true;
            }
        }

        if (min == -1) return false;

        //position min
        l = 0; r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[min][mid] < target) {
                l = mid + 1;
            } else if (matrix[min][mid] > target) {
                r = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
