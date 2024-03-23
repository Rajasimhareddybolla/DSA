class Solution(object):
    def subStrHash(self, s, power, modulo, k, hashValue):
        """
        :type s: str
        :type power: int
        :type modulo: int
        :type k: int
        :type hashValue: int
        :rtype: str
        """
        ln = len(s)
        s_str = s[:k]
        hash = self.find_hash(s_str,power,modulo)
        if hash == hashValue:
            return s_str
        for i in range(k,ln):
            hash = self.alter(s_str[0], s[i], hash, len(s_str), power, modulo)
            s_str = s_str[1:] + s[i]
            if hashValue == hash:
                return s_str
                
        return -1
    def find_hash(self, s, power, modulo):
        ln = len(s)
        hash = 0 
        for i in range(0,ln):
            hash += (ord(s[i])-ord('a') +1)* (power **i)
        return hash % modulo
    def alter(self, l_c, p_c, pre_hash, length, power, mod):
        new_hash = ((pre_hash - (ord(l_c) - ord('a') + 1)) / power) + (ord(p_c) - ord('a') + 1) * (power ** (length - 1))
        return int(new_hash) % mod
sol = Solution ()
print(sol.subStrHash('leetcode',7,20,2,0))