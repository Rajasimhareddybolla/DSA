import random
no = random.randint(1000,2000)
p = random.randrange(2**(no-1)+1,2**(no-1))

a= random.randint()
b = random.randint(0,p-1)
def hash(k):
    has = k*a + b +