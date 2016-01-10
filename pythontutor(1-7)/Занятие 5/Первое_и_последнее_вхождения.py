a = str(input())
b = a.find('f')
c = a.rfind('f')
if b != -1 and b != c:
   print(b, c) 
elif b == c:
   print(b)