class node:
    
    def __init__(self,no = None,l_node = None, r_node = None):
        self.data = no
        self.left = l_node
        self.right = r_node
        self.repetation = 1
    def printi(self):
        for i in range(0,self.repetation):
            print(self.data)
    
class tree :
    def __init__(self,no) :
        self.nod = node(no)
    def add( self,no ):
        prev = None
        ptr = self.nod
        while ptr:
            
            if ptr.data < no:
                prev = ptr
                ptr = ptr.right
            elif ptr.data> no : 
                prev = ptr   
                ptr = ptr.left
            else :
                ptr.repetation +=1
                prev = None
                break
            
        if prev:
            if no > prev.data:
                prev.right = node(no)
            else:
                prev.left = node(no)
    def dfs_preorder(self,node ): # visit left  right 0 1 2 3 4 5 6 7 8 9
        if node != None:   
            node.printi()
            self.dfs_preorder(node.left)
            self.dfs_preorder(node.right)
    def dfs_postorder(self,node ): #  left  right visit 9  8 7 6 5 4 3 2 1 0
        if node != None:   
            self.dfs_postorder(node.left)
            self.dfs_postorder(node.right)        
            node.printi()
    def dfs_inorder(self,node ): # left visit right 0 1 2 3 4 5 6 7 8 9

        if node != None:   
            self.dfs_inorder(node.left)
            node.printi()
            self.dfs_inorder(node.right)
    def search(self ,no):
        ptr = self.nod
        while ptr:
            if no > ptr.data:
                ptr = ptr.right
            elif no < ptr.data:
                ptr = ptr.left
            else:
                return True
        return False
    def delete(self,value):
        prev = None
        ptr = self.nod
        while ptr:
            if ptr.data > value :
                prev = ptr
                ptr = ptr.right
            elif ptr.data < value:
                prev = ptr
                ptr = ptr.left
            else:
                ptr2 = ptr.right
                ptr2_prev = ptr2
                while ptr2:
                    ptr2_prev = ptr2
                    if ptr2.left == None and ptr2.right == None:
                        break
                    if ptr2.left == None:
                        ptr2 = ptr2.right
                    
                    
    def bfs(self):
        track = [self.nod]
        
        while track:
            ptr = track[0]
            track = track[1:]
            ptr.printi()
            if ptr.left:
                track.append(ptr.left)
            if ptr.right :
                track.append(ptr.right)
            
            
tr = tree(0)
tr.add(1)
tr.add(2)
tr.add(3)
tr.add(4)
tr.add(5)
tr.add(6)
tr.add(7)
tr.add(8)
tr.add(9)
tr.dfs_preorder(tr.nod)
print(tr.search(8))
print(tr.search(78))