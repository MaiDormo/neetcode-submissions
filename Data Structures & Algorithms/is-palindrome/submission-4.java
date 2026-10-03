class Solution {
    public boolean isPalindrome(String s) {
        s = s.replace(" ", "");
        s = s.toLowerCase();
        int j = s.length() - 1;
        int i = 0;
        System.out.println(s);
        while (i < j) {
            
            while (i < j && !isAlpha(s.charAt(i))) i++;
            while (j > i && !isAlpha(s.charAt(j)) ) j--;
            

            if (s.charAt(i) != s.charAt(j)) {
                System.out.println(s.charAt(i) + " " + s.charAt(j));
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }

    private boolean isAlpha(char c) {
        return c >= 'a' && c <= 'z' || c >= '0' && c <= '9';
    }
}
