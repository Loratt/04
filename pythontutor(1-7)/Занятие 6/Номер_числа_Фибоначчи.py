f = int(input())
a=1 
b=0 
n=1
while a<f:
	a=a+b
	b=a-b
	n+=1
if f==a or f==b:
    print(n)
else:
    print(-1)