n = int(input())
hours = (n % 1440) // 60
mins = (n % 1440) % 60
print(hours)
print(mins)