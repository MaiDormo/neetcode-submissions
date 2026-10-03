class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s: strs) {
            int[] letters = new int[26];
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                letters[index]++;
            }
            map.computeIfAbsent(Arrays.toString(letters), k -> new ArrayList<>()).add(s);
        }

        List<List<String>> res = new ArrayList<>(map.values());

        return res;
    }
}
