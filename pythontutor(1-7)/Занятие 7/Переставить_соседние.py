x = input().split()
for i, j in enumerate(x):
    if i % 2:
        x[i], x[i-1] = x[i-1], x[i]
print(' '.join(map(str, x)))