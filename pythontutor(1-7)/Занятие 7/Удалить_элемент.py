a = input().split(' ')
k = 2
result = []
for x in range(len(a)):
    if x != k:
        print(a[x], end = " ")