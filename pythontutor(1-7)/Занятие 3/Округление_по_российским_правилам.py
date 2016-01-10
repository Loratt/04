from math import *
x = float(input())
if int((x%1)*10)>=5:
    print(ceil(x))
else:
    print(floor(x))