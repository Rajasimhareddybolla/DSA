import copy
class Solution(object):
    def isMonotonic(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        
        # nums2_c = sorted(nums)
        # nums2_r = []
        # r =len(nums2_c)-1
        # for i in range(r,-1,-1):
        #     nums2_r.append(nums2_c[i])
        # if nums == nums2_c or nums2_r == nums:
        #     return True
        # return False
        le = len(nums)
        if nums[0]>=nums[1]:
            for i in range(0,le):
                if i != le-1:      
                    if nums[i] >= nums[i+1]:
                        pass
                    else:
                        return False
            return True
        else:
            for i in range(0,le):
                if i != le-1:      
                    if nums[i] <= nums[i+1]:
                        pass
                    else:
                        return False
            return True
                
so = Solution()
print(so.isMonotonic([1,1,0]))