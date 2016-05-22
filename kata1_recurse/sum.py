
# Add 1 to value
def inc(value):
    return value+1

def dec(value):
    return value-1

def zero():
    return 0

def one():
    return 1

def isZero(value):
    return value == 0

def isSame(number1, number2):
    return number1 == number2


#  i/o is value ==> value
#  Only use functions
#  Not use +, -, ==, > , < numbers


# recursive summation
def valueOf(number):
    if isZero(number)
        return zero()

    return inc(valueOf(dec(value)))


# iterative summation
def valueOf2(number):
    n = zero()
    while not isSame(number,zero())
        number = dec(number)
        n = inc(n)
    return n






valueOf(5)
inc(valueOf(dec(5)))
inc(valueOf(4))
inc(inc(valueOf(dec(4))))
.....
inc(inc(inc(inc(inc(zero())))))