class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """


        if x < 0:
            sign = -1
            x = str(x)[1:]
            x = x[::-1]
        else:
            sign = 1
            x = str(x)[::-1]

        x = int(x) *sign
        if not(-pow(2,31)<x <pow(2,31)-1):
            return 0
        
        return x
sol = Solution()
print(sol.reverse(-233))