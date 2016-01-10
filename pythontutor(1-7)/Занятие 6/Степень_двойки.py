a = int(input())
n = 1
while 2**n<=a:
    if 2**(n+1)>a:
        print(n)
        print(2**(n))
    n += 1