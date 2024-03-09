class MinStack(object):

    def __init__(self,create_inner = True):
        self.creat = create_inner
        if create_inner:
            self.s = self.__class__(False)
            self.s.push(pow(2,32))
        
        self.array = []
        self.size = 0
    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        
        if (val < self.s.top() ):
            self.s.push(val)
            
        self.array.append(val)
        self.size +=1
        
        

    def pop(self):
        """
        :rtype: None
        """
        self.size -=1
        if (self.s.top() == self.top):
            self.s.pop()
        self.array.pop()
    def top(self):
        """
        :rtype: int
        """
        if self.array:
            return self.array[self.size-1]
        
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.s.top()
        

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