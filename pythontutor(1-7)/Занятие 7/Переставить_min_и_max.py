x = list(map(int, input().split()))
m1, m2 = min(x), max(x)
i, j = x.index(m1), x.index(m2)
x[i], x[j] = m1, m2
print(' '.join(map(str, x)))