class Solution {
    public int lengthOfLongestSubstring(String s) {

        int l = 0;
        int r = 0;
        int max = 0;
        Map<Character,Integer> map = new HashMap<>();
        while (r < s.length()) {
            char c = s.charAt(r);
            if (map.containsKey(c) && map.get(c) >= l) {
                max = Math.max(max, r - l);
                l = map.get(c) + 1;
                map.put(c,r);
            }
            map.put(c,r);
            r++;
        }
        return Math.max(max, r - l);
    }
}
