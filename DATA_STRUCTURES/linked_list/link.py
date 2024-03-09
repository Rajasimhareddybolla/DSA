#implement the details in python
class listnode:
    value = 0 
    next = None
    def __init__(self,data,next = None):
        self.value = data
        self.next = next
    def getvalue(self):
        return self.value
    def getnext (self):
        return self.next
l = listnode(23,listnode(34,listnode(89)))
print(l.getnext().next.value)