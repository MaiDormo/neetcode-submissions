class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t): return False
        
        letterS = [0] * 26
        letterT = [0] * 26
        
        for i in range(len(s)):
            idxS = ord(s[i]) - ord('a')
            idxT = ord(t[i]) - ord('a')
            letterS[idxS] += 1
            letterT[idxT] += 1
        
        return letterS == letterT


        
        