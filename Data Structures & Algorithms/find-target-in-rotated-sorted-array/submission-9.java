class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int pivotIndex = -1;
        int pivotVal = Integer.MAX_VALUE;
        int res = -1;

        //normal case -> optimization
        if (nums[l] <= nums[r]) {
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

        //find pivot
        while (l <= r) {
            if (nums[l] < nums[r]) {
                if (pivotVal > nums[l]) {
                    pivotVal = nums[l];
                    pivotIndex = l;
                    break;
                }
            }

            int mid = l + (r - l) / 2;
            if (pivotVal > nums[mid]) {
                pivotVal = nums[mid];
                pivotIndex = mid;
            }
            if (nums[mid] >= nums[l]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        
        //find target
        l = 0;
        if (target >= nums[l]) { //search on the left side
            r = pivotIndex-1;
        } else {
            l = pivotIndex;
            r = nums.length - 1;
        }


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
        

        return res;
    }

}
