class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t): return False
        
        letterS = {}
        letterT = {}
        
        for i in range(len(s)):
            letterS[s[i]] = letterS.get(s[i],0) + 1
            letterT[t[i]] = letterT.get(t[i],0) + 1
        
        return letterS == letterT


        
        