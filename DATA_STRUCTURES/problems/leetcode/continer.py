class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        capacity = 0
        for i in range(0,len(height)):
            for k in range(i,len(height)):
                if i== k :
                    pass
                ne =abs(i-k)*(min(height[i],height[k]))
                if ne>capacity:
                    capacity = ne
        return capacity
so  = Solution()
print(so.maxArea([1,8,6,2,5,4,8,3,7]))