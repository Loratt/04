s = input().split(' ')
n=1
i=1
while i < len(s):
    if s[i-1] != s[i]:
        n+=1
    i += 1
print(n)