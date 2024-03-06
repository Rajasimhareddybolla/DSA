# class Solution(object):
#     def intersection(self, nums1, nums2):
#         """
#         :type nums1: List[int]
#         :type nums2: List[int]
#         :rtype: List[int]
#         """
#         num1 = set(nums1)
#         num2 = set(nums2)
#         return list(num1.intersection(num2))
# sol = Solution()
# print(sol.intersection([1,2,3],[3,4,5]))
class Solution(object):
    from math import ceil
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """

        answers ={}
        for no in nums1:
            for k in nums2:
                if k == no:
                    if no in answers.keys():
                        answers[no]+=1
                    else:
                        answers[no]=1
        ans = []
        print(answers)
        for (k,v) in answers.items():
            for i in range(0,int(v/2+0.5)):
                ans.append(k)
        return ans
sol = Solution()
print(sol.intersect([1],[1]))