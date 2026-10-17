class Solution {
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length()) return false;
        
        int[] letterS = new int['z' - 'a' + 1];
        int[] letterT = new int['z' - 'a' + 1];
        for (int i = 0; i < s.length(); i++) {
            int iS = s.charAt(i) - 'a';
            int iT = t.charAt(i) - 'a';

            letterS[iS]++;
            letterT[iT]++;
        }

        for (int i = 0; i < letterS.length; i++) {
            if (letterS[i] != letterT[i]) return false;
       }
       return true;
    }
}
