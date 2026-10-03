class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap();
        List<Integer>[] freqList = new List[nums.length + 1];

        for(int i = 0; i <= nums.length; i++) {
            freqList[i] = new ArrayList<Integer>();
        }

        for(int n: nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: countMap.entrySet()) {
            freqList[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int resIdx = 0;
        for(int i = freqList.length - 1; i >= 0 && resIdx < k; i--) {
            for(int freq: freqList[i]) {
                res[resIdx++] = freq;

                if(resIdx == k)
                    return res;
            }
        }

        return res;
    }
}
