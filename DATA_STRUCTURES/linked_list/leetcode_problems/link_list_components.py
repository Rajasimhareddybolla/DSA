
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
def gave_removable(nums , ptr):
    removable = []
    while ptr != None:
        try :
            while ptr !=None:
                if ptr.val in nums:
                    removable.append(nums.index(ptr.val))
                else:
                    break
        except ValueError:
            return removable
    return removable
class Solution(object):
    def numComponents(self, head, nums):
        """
        :type head: ListNode
        :type nums: List[int]
        :rtype: int
        """
        partition = 0
        while head != None:
            ptr = head
            
            head = head.next
        if len(nums) >0:
            partition+=1
        return partition 
                

sou = Solution()
print(sou.numComponents(ListNode(0,ListNode(1,ListNode(2,ListNode(3,ListNode(4))))) , [0,3,1,4]))
