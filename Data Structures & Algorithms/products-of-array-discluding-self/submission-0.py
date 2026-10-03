class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        multLeft = [0] * len(nums)
        multRight = [0] * len(nums)

        multLeft[0] = nums[0]
        for i in range(1,len(nums)):
            multLeft[i] = multLeft[i-1] * nums[i]
        
        multRight[len(nums)-1] = nums[len(nums)-1]
        for i in range(len(nums) - 2, -1, -1):
            multRight[i] = multRight[i+1] * nums[i]

        res = [0] * len(nums)
        for i in range(len(nums)):
            partLeft = multLeft[i-1] if (i - 1) >= 0 else 1
            partRight = multRight[i+1] if (i + 1) < len(nums) else 1
            res[i] = partLeft * partRight

        return res
        