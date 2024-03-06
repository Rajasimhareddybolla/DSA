class Solution(object):
    def totalMoney(self, n):
        """
        :type n: int
        :rtype: int
        """
        balance = 0#monday not started
        weeks = n//7
        prev_week = 21
        for i in range(0,weeks):
            prev_week += 7
            balance += prev_week
        days = n % 7
        balance += weeks*days+(days+1)*(days)/2
        return int(balance)
so = Solution()
print(so.totalMoney(16))
            