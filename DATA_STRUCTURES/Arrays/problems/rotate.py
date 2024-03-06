
import copy


class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        nums1 = []
        nums1[0:k] = nums[-k:]
        nums1[k:] = nums[0:len(nums)-k]
        nums = nums1
        return nums
so = Solution()
print(so.rotate([1,2,3,4,5],3))