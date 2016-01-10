s = input().split(' ')
h = int(input())
n = 0
while n < len(s):
    if h > int(s[n]):
        print(n+1)
        break
    n += 1