class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        current = ""
        for i in range(0,len(s)):
            if i %2 ==0:
                if current:
                    return False
                current = s[i]
            else :
                if (current == "(" and s[i] ==")") or( current=="{" and s[i] =="}") or ( current=="[" and s[i] == "]"):
                    current =""

                else:
                    return False
        return True
so = Solution()
print(so.isValid("(]"))