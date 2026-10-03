class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        tmp = {}
        
        for i,val in enumerate(nums):
            if val in tmp:
                return [tmp.get(val),i]
            else:
                tmp[target - val] = i
        return []