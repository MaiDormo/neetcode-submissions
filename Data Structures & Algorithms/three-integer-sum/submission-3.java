class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < n-1; i++) {
            int target = -nums[i];
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int tmp = nums[l] + nums[r];
                if (tmp > target) r--;
                else if (tmp < target) l++;
                else {
                    List<Integer> triplets = new ArrayList<>();
                    triplets.add(nums[i]);
                    triplets.add(nums[l]);
                    triplets.add(nums[r]);
                    res.add(triplets);
                    l++;
                    r--;
                }
            }
        }
        return new ArrayList<>(res);
    }
}
