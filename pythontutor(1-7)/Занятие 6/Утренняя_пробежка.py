x = int(input())
y = int(input())
n=1
while x<=y:
     x=x+x/10
     n+=1
     if x>=y:
         print(n)
         break