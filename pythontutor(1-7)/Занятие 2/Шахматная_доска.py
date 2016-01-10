a1=int(input()) 
b1=int(input())
a2=int(input())
b2=int(input())
s1=a1+b1; s2=a2+b2
if s1%2==0:
    d=(s2%2==0)
else:
    d=(s2%2!=0)
if d:
    print("Yes")
else:
    print("No")