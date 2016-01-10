s = 0
a = 0
n = int(input())
for i in range(1, n + 1):
    s += i
for i in range(n-1):
    a += int(input())
print(s-a)