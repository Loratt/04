s = input()
a = s.find("h")
b = s.rfind("h")
c = s[:a] + s[b+1:]
print(c)