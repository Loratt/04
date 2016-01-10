a=b=int(input())
n=1
while a!=0:
  a=int(input())
  if a>b:
    b=a
  elif a==b:
    n+=1
print (n)