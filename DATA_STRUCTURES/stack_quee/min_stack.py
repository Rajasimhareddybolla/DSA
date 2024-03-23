class MinStack(object):

    def __init__(self):
        self.min = []
        self.array = []
        self.size = 0
    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.array.append(val)
        

    def pop(self):
        """
        :rtype: None
        """
        self.array.pop()
    def top(self):
        """
        :rtype: int
        """
        return self.array[len() -1]
        

    def getMin(self):
        """
        :rtype: int
        """
        return min(self.array)
        

# Your MinStack object will be instantiated and called as such:
val = 90
obj = MinStack()
obj.push(val)
obj.push(val)
obj.push(val)
param_4 = obj.getMin()
obj.pop()
param_3 = obj.top()
param_4 = obj.getMin()