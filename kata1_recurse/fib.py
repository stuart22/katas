# Recurseive Fib (return ith fib valie)

def fib(value):

    if value == 0 :
        return 0:
    elif value == 1 :
        return 1
    else:
        return fib(n-1) + fib (n-2)




# Iterative Fib
def fib2(value)
    a, b = 0, 1
    for i in range(value):
        a,b = b, a + b
        return a



#  0 --> 0
#  1 --> 1
#  2 --> 1




# Size at which each breaks:
#  fib()
#  fib2()


#  n ==> 2^n


xxx
digits is n
10^n

2^n

1 + 1 + 1
fib(1)
fib(2)
fib(3)

#recursive
fib(n) => stack height is n
fib(n) => O(2^n)

#iterative
fib(n) => stack height is 1
fib(n) => O(n)
