class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        
        ptr = ListNode()
        start = ptr
        carry = 0
        while(l1 != None):
            value = l1.val + l2.val+carry
            carry = value //10
            node = ListNode(value %10)
            ptr.next = node
            ptr = node
            l1 = l1.next
            l2 = l2.next
        return start.next
so = Solution()            
l1 = ListNode(1,ListNode(2,ListNode(3)))
l2 = ListNode(8,ListNode(8,ListNode(89)))
so.addTwoNumbers(l1,l2)