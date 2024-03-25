class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        
        sub =strs[0]
        for i in range(0,len(strs)-1):
            tmp= ""
            for k in range(0,min(len(sub),len(strs[i+1]))):
                if sub[k] == strs[i+1][k] :
                    tmp += sub[k]
                else:
                    break
            if not tmp:
                return ""
            sub = tmp
        return sub
so = Solution()
print(so.longestCommonPrefix(["reflower","flow","flight"]))
                