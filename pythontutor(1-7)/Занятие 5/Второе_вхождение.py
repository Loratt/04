a = str(input())
b = a.count('f')
if b == 0:
   print(-2) 
elif b == 1:
   print(-1)
else:
   print(a.find('f', a.find('f')+1))