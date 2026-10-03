class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int n = map.get(nums[i]) + 1;
                map.put(nums[i], n);
            } else {
                map.put(nums[i],0);
            }
        }

        int[] res = new int[k];
        int[][] tmp = new int[map.keySet().size()][2];
        int index = 0;
        for (var entry: map.entrySet()) {
            tmp[index][0] = entry.getKey();
            tmp[index][1] = entry.getValue();
            index++;
        }

        Arrays.sort(tmp, (row1, row2) -> Integer.compare(row1[1], row2[1]));

        index = 0;
        for (int i = tmp.length - 1; i >= tmp.length - k && i >= 0; i--) {
            res[index++] = tmp[i][0];
        }

        // System.out.println(tmp.deepToString());

        return res;
    }
}
