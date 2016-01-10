a = float(input())
hour = 30
minute = hour/60
second = minute/60
h = a//hour
m = (a / 30 * 60) % 60
s = (a / 30 * 3600) % 60
print(int(h), int(m), int(s))