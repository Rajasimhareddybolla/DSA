class Solution(object):
    def arrayPairSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums.sort()
        sum = 0
        le = len(nums)//2
        for i in range(0,le):
            sum += nums[i*2]
            
        return sum # return sum(sorted[::2])
so  = Solution()
print(so.arrayPairSum([1,2,3,4,5,6]))