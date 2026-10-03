class Solution {
    public boolean isAnagram(String s, String t) {
        int[] letterS = new int[26];
        int[] letterT = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            letterS[index]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            letterT[index]++;
        }

        for (int i = 0; i < 26; i++) {
            if (letterS[i] != letterT[i]) return false;
        }

        return true;

    }
}
