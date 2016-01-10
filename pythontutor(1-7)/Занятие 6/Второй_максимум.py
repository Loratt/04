a=b=c=int(input())
while a!=0:
  a=int(input())
  if a>b:
    b=a
  elif a>c:
    c=a
print(c)