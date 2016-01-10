max = 0
m = -1
s = input().split(' ')
n = 0
for i in s:
    i = int(i)
    if i > max:
        max = i
        m = n
    n += 1
print(max, m)