s = input()
a = s.find("h")
b = s.rfind("h")
d = s[a:b+1]
print(s[:a]+d[::-1]+s[b+1:])