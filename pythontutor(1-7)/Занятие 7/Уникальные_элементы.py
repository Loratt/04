import re
s = input().split(' ')
d = []
n = 0
while n < len(s):
    if len(re.findall(s[n], str(s))) < 2:
        d.append(int(s[n]))
    n+=1
print(d)