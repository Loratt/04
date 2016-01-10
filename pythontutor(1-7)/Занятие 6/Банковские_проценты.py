x = int(input())
p = int(input())
y = int(input())
n=0
while x<=y:
     x=x+x*p/100
     n+=1
     if x>=y:
         print(n)
         break