b=0
a=1
n=1
c=int(input())
while n<c:
	a=a+b
	b=a-b
	n+=1
print(a)