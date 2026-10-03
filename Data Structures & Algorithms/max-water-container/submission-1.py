class Solution:
    def maxArea(self, heights: List[int]) -> int:
        res = 0
        l = 0
        r = len(heights) - 1
        while l != r:
            tmpArea = min(heights[l], heights[r]) * (r - l)
            res = max(res,tmpArea)

            if heights[l] <= heights[r]:
                l += 1
            elif heights[l] > heights[r]:
                r -= 1
        
        return res



        