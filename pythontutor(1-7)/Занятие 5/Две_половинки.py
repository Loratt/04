from math import *
s = input()
a = ceil(len(s)/2)
print(s[a:len(s)+1]+s[0:a])