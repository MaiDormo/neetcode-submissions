class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        
        // 1. Normal case -> optimization (Optional, but keeps your logic)
        // If start < end, it is already fully sorted.
        if (nums[l] < nums[r]) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }

        // 2. Find Pivot (The Minimum Value Index)
        // We use l < r because we want to stop exactly when l == r (the pivot)
        while (l < r) {
            int mid = l + (r - l) / 2;
            
            // Logic: Compare mid with right
            if (nums[mid] > nums[r]) {
                // If mid is greater than right, the cliff is to the right.
                // mid cannot be the min, so we do mid + 1
                l = mid + 1;
            } else {
                // If mid is <= right, the min is at mid or to the left.
                // We keep mid in the search space.
                r = mid;
            }
        }
        
        int pivotIndex = l; // After the loop, l == r == pivotIndex

        // 3. Decide in which portion to search
        l = 0;
        r = nums.length - 1;

        if (pivotIndex == 0) {
            // Case: The array wasn't rotated (e.g. [1, 2, 3]) or passed the first check
            l = 0; 
            r = nums.length - 1;
        } else if (target >= nums[0] && target <= nums[pivotIndex - 1]) {
            // Target is in the left (larger) sorted portion
            l = 0;
            r = pivotIndex - 1;
        } else {
            // Target is in the right (smaller) sorted portion
            // Note: nums[pivotIndex] is the smallest value
            l = pivotIndex;
            r = nums.length - 1;
        }

        // Final Binary Search
        return binarySearch(nums, l, r, target);
    }

    // Helper method to keep code clean
    private int binarySearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target < nums[mid]) {
                r = mid - 1;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}