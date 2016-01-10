from math import *
a=b=int(input())
s = 0
c = 0
q = 0
n = 0
while a!=0:
  a=int(input())
  b=b+a
  n+=1
  c=c+a*a
s = b/n
q=sqrt((c+s*s*n-2*b*s)/(n-1))
print (q)