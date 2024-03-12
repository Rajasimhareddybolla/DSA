class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None
class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        
        if not head or not head.next:
            return False
        visited = set()
        no = 0
        while (head != None):
            visited.add(head)
            no +=1 
            if len(visited) != no:
                return True
            head = head.next
        return False
l1 = ListNode(19)
l2 = ListNode(29)
l3 = ListNode(39)
l4 = ListNode(49)
l1.next = l2
l2.next = l3
l3.next = l4
l4.next = l2
so = Solution()
print(so.hasCycle(l1))
# it produce speedd output than previous one in which it stores and check all it match or not