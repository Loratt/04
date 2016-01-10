s = input()
a = s.find("h")
b = s.rfind("h")
d = s[a+1:b]
print(s[:a+1]+d.replace('h', 'H')+s[b:])