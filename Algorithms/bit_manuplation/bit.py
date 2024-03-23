print(0b0010<<2)
# zeros to the right which is 001000
no = 0b101
print(no)
def setBit(x , position ):
    mark = 1 << position
    return x|mark
def clearBit(x , position):
    mark = ~ 1<<position
    return x & mark
def flipABit(x,position):
    mark = 1<<position
    return x^mark
def is_set_bit(x,position): # is 1 is at the index or not
    x = x>> position
    return  1&x
print(bool(is_set_bit(0b010001,3)))
def modify(x, position , to):
    mark = 1 << position
    return (x | mark)if to else (x & ~mark)
print(modify(0b00111,3,1))
def power_of_two(x ):
    return (x & x-1)==0
print(power_of_two(4))
def multiplication(a,b):
    c = 0
    while b!=0:
        if(b & 1)!=0:
            c = c+a
        a = a<<1
        b = b>>1
    return c
def add(a , b):
    c = 0
    while a != 0 :
        c = b &a
        b = b ^a
        c = c <<1
        a = c 
    return b
def sign(x):   # gave 0 for positive no   and -1 for negitive no 
    return x >> 31
def absolute(x):
    first = x >> 31
    return (x^first) -first
print(absolute(-90000))   
print(multiplication(3,32))
print(add(8,8))