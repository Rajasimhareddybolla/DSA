import numpy as np
# hear the cost function return how much far  we are from the data if we choose that parameters as w,b 
# cost fun summation of 1/2m(f(x(i)- y(i))**2))
def cost_function(training_models , parameters ):
    cost = 0 
    m = len(training_models) # no of training models
    for data in training_models:
        expected = parameters[0] * data[0] + parameters[1]
        cost += (expected - data[1])**2
    return cost/(2*m)
#return the df/dw(w,b) and d(w,b)/db  which is 1/m *(f(x(i) - y(i))*x(i)) and 1/m *(f(x(i)-y(i))) 
def differ(t_m , p): #hear trainin model is taken as t_m
    w_d = 0
    b_d = 0 
    m = len(t_m)
    for model in t_m:
        w_d_i = (p[0]*model[0]+p[1] - model[1])*(model[0])
        b_d_i = (p[0]*model[0]+p[1] - model[1])
        w_d += w_d_i
        b_d += b_d_i
    result = [w_d/m,b_d/m]
    return result 
# using gradient descent for this algorithm
# for min we have to do w(i+1) =w(i) +alpha * w_d
# for min we            b(i+1) =b(i) + alpha * b_d             repeate this untill w(i+1) === w(i) and b(i+1)  = b(i )
# in our case we will iterate with some no
def gradient_descent(t_d , p_d , a ,re): # hear t_d = traingin_data , p_d = parameters_data , a = alpha , re = no of repetetions req
    for i in range(0,re):
        d_p = differ(t_d,p_d) ## after differentiation parameters 
        p_d[0] -= a*(d_p[0])
        p_d[1] -= a*(d_p[1])
    return p_d
        
## data problem_solving skill :: expected rank 
train_data1 = np.array([1,300])
train_data2 = np.array([2,500])

training_data = [train_data1,train_data2]
#parameters[w,b] for our function f(x) = wx+b where w , b are the var 
parameters = [0,0] # intial_approximation

print(f"cost happende = :  {cost_function(training_data , gradient_descent(training_data,parameters,1.0e-2,10000))}")
print(f"using gradient descent the w, b for this  functions are  ")