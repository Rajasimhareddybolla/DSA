class MyHashSet(object):

    def __init__(self):
        self.arr = set()

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        self.arr.add(key);

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        try:
            self.arr.remove(key)
        except KeyError:
            pass
        

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        try:
            self.arr.remove(key)
            self.arr.add(key)
            return True
        except :
            return False        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)